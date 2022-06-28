package athena.module.note;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import athena.module.note.model.NoteCreateInput;
import athena.module.note.model.NoteResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private NoteService service;

  @Autowired
  private ObjectMapper objectMapper;

  @Before
  public void setUp() {}

  @Test
  public void testGetNote() throws Exception {
    String username = "sahat.nicholas";
    String password = "123456789";

    String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
        .content(body)
        .contentType("application/json"))
        .andExpect(status().isOk()).andReturn();

    String response = result.getResponse().getContentAsString();
    response = response.replace("{\"token\":\"", "");
    String token = response.replace("\"}", "");

    NoteResponse noteResponse = NoteResponse.builder()
        .id("1")
        .title("title1")
        .body("body1")
        .archived(false)
        .build();

    when(service.getNote("1")).thenReturn(noteResponse);

    mockMvc.perform(get("/notes/{id}", "1")
        .header("Authorization", "Bearer " + token))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(noteResponse.getId()))
        .andExpect(jsonPath("$.title").value(noteResponse.getTitle()))
        .andExpect(jsonPath("$.body").value(noteResponse.getBody()))
        .andDo(print());
  }

  @Test
  public void testCreateNote() throws Exception {
    String username = "sahat.nicholas";
    String password = "123456789";

    String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
        .content(body)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();

    String response = result.getResponse().getContentAsString();
    response = response.replace("{\"token\":\"", "");
    String token = response.replace("\"}", "");

    NoteResponse noteResponse = NoteResponse.builder()
        .id("1")
        .title("title1")
        .body("body1")
        .archived(false)
        .build();

    NoteCreateInput noteCreateInput = NoteCreateInput.builder()
        .title("title1")
        .body("body1")
        .build();

    when(service.createNote(noteCreateInput)).thenReturn(noteResponse);

    mockMvc.perform(post("/notes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(noteCreateInput))
        .header("Authorization", "Bearer " + token))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(noteResponse.getId()))
        .andExpect(jsonPath("$.title").value(noteResponse.getTitle()))
        .andExpect(jsonPath("$.body").value(noteResponse.getBody()))
        .andDo(print());
  }

}

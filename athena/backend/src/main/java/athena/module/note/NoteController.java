package athena.module.note;

import athena.module.note.model.NoteCreateInput;
import athena.module.note.model.NoteResponse;
import athena.module.note.model.NoteUpdateInput;
import java.util.Map;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class NoteController {

  private final NoteService noteService;

  public NoteController(NoteService noteService) {
    this.noteService = noteService;
  }

  @RequestMapping(value = "/notes", method = RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> getNotes(
      @RequestParam(defaultValue = "false") boolean archived,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "2") int size
  ) {
    Pageable paging = PageRequest.of(page, size);
    Map<String, Object> notes = noteService.getNotes(paging, archived);
    return new ResponseEntity<>(notes, HttpStatus.OK);
  }

  @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
  public ResponseEntity<NoteResponse> getNote(@PathVariable("id") String id) {
    NoteResponse note = noteService.getNote(id);
    return new ResponseEntity<>(note, HttpStatus.OK);
  }

  @RequestMapping(value = "/notes", method = RequestMethod.POST)
  public ResponseEntity<NoteResponse> createNote(@RequestBody NoteCreateInput input) {
    NoteResponse note = noteService.createNote(input);
    return new ResponseEntity<>(note, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/notes/{id}", method = RequestMethod.PATCH)
  public ResponseEntity<NoteResponse> updateNote(@PathVariable("id") String id, @RequestBody
      NoteUpdateInput input) {
    NoteResponse note = noteService.updateNote(id, input);
    return new ResponseEntity<>(note, HttpStatus.OK);
  }

  @RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<HttpStatus> deleteNote(@PathVariable("id") String id) {
    noteService.deleteNote(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

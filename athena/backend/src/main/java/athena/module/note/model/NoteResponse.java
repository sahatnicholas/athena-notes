package athena.module.note.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {

  private String id;
  private String title;
  private String body;
  private boolean archived;

}
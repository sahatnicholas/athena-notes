package athena.module.note.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteCreateInput {

  private String title;
  private String body;

}

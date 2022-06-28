package athena.module.note;

import athena.authentication.SecurityContextHolderService;
import athena.common.base.service.AthenaBaseServiceImpl;
import athena.common.patch.PatchService;
import athena.module.note.model.NoteCreateInput;
import athena.module.note.model.NoteResponse;
import athena.module.note.model.NoteUpdateInput;
import athena.module.user.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class NoteService extends AthenaBaseServiceImpl<Note> implements PatchService {

  private final NoteRepository repository;
  private final NoteMapper mapper;
  private final UserService userService;
  private final SecurityContextHolderService<String> securityContextHolderService;

  public NoteService(NoteRepository repository, NoteMapper mapper, UserService userService,
                     SecurityContextHolderService<String> securityContextHolderService) {
    super(repository);
    this.repository = repository;
    this.mapper = mapper;
    this.userService = userService;
    this.securityContextHolderService = securityContextHolderService;
  }

  public Map<String, Object> getNotes(Pageable pageable, boolean archived) {
    String userId = securityContextHolderService.getCurrentUserId();
    Page<Note> pageNotes = repository.findAllByUserIdAndArchived(userId, archived, pageable);

    Map<String, Object> response = new HashMap<>();
    response.put("notes", mapper.toResponses(pageNotes.getContent()));
    response.put("currentPage", pageNotes.getNumber());
    response.put("totalItems", pageNotes.getTotalElements());
    response.put("totalPages", pageNotes.getTotalPages());

    return response;
  }

  public NoteResponse getNote(String id) {
    String userId = securityContextHolderService.getCurrentUserId();
    return mapper.toResponse(repository.findOneByIdAndUserId(id, userId));
  }

  public NoteResponse createNote(NoteCreateInput input) {
    Note note = new Note();

    String userId = securityContextHolderService.getCurrentUserId();
    note.setUserId(userId);
    note.setTitle(input.getTitle());
    note.setBody(input.getBody());
    note.setArchived(false);

    return mapper.toResponse(create(note));
  }

  public NoteResponse updateNote(String id, NoteUpdateInput input) {
    String userId = securityContextHolderService.getCurrentUserId();
    Note note = repository.findOneByIdAndUserId(id, userId);
    note = patch(note, input);
    return mapper.toResponse(update(note));
  }

  public void deleteNote(String id) {
    String userId = securityContextHolderService.getCurrentUserId();
    Note note = repository.findOneByIdAndUserId(id, userId);
    delete(note);
  }

}

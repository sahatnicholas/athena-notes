package athena.module.note;

import athena.common.base.repository.BaseRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends BaseRepository<Note, String> {

  Page<Note> findAllByUserIdAndArchived(String userId, boolean archived, Pageable pageable);

  Note findOneByIdAndUserId(String id, String userId);
}

package athena.common.base.service;

import athena.common.base.entity.BaseEntity;
import athena.common.base.repository.BaseRepository;
import athena.common.exception.DataExistsException;
import athena.common.exception.DataNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public class BaseServiceImpl<T extends BaseEntity<I>, I> implements BaseService<T, I> {

  protected final BaseRepository<T, I> repository;

  public BaseServiceImpl(BaseRepository<T, I> repository) {
    this.repository = repository;
  }

  @Override
  public List<T> findAll() {
    return repository.findAll();
  }

  @Override
  public Page<T> findAll(Specification<T> spec, Pageable pageable) {
    return repository.findAll(spec, pageable);
  }

  @Override
  public Optional<T> findById(I id) {
    return repository.findById(id);
  }

  @Override
  public T create(T entity) {
    if (entity.getId() != null && findById(entity.getId()).isPresent()) {
      throw new DataExistsException(entity.getClass(), "with id " + entity.getId());
    }
    return repository.saveAndFlush(entity);
  }

  @Override
  public T update(T entity) {
    return repository.saveAndFlush(entity);
  }

  @Override
  public void delete(T entity) {
    repository.delete(entity);
    repository.flush();
  }

  @Override
  public T findOneById(I id) {
    return findById(id).orElseThrow(DataNotFoundException::new);
  }
}

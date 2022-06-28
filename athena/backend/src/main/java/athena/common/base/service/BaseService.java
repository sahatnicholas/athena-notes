package athena.common.base.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BaseService<T, I> {

  List<T> findAll();

  Page<T> findAll(Specification<T> spec, Pageable pageable);

  Optional<T> findById(I id);

  T findOneById(I id);

  T create(T entity);

  T update(T entity);

  void delete(T entity);
}

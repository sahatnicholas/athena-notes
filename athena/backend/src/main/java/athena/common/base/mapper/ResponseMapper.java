package athena.common.base.mapper;

import java.util.List;
import java.util.Set;

public interface ResponseMapper<T, R> {

  R toResponse(T dbObject);

  List<R> toResponses(List<T> dbObjects);

  Set<R> toResponses(Set<T> dbObjects);

}

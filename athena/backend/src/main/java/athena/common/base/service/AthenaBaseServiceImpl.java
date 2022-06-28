package athena.common.base.service;

import athena.common.base.entity.AthenaBaseEntity;
import athena.common.base.repository.BaseRepository;

public class AthenaBaseServiceImpl<T extends AthenaBaseEntity>
    extends BaseServiceImpl<T, String> {

  public AthenaBaseServiceImpl(BaseRepository<T, String> repository) {
    super(repository);
  }
}

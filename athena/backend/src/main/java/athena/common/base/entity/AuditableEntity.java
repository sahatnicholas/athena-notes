package athena.common.base.entity;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class AuditableEntity extends AthenaBaseEntity {

  @CreatedBy
  private String createdBy;

  @CreatedDate
  private Instant createdDate;

  @LastModifiedBy
  private String lastModifiedBy;

  @LastModifiedDate
  private Instant lastModifiedDate;

}

package athena.common.base.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public class AthenaBaseEntity implements BaseEntity<String> {

  @Id
  @Column(columnDefinition = "char(36)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  protected String id;

}

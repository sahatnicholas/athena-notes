package athena.module.note;

import athena.common.base.entity.AuditableEntity;
import athena.common.constant.Constant;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.TypeDef;

@Entity(name = "note")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Note extends AuditableEntity {

  private String userId;

  private String title;
  private String body;
  private Boolean archived;

}

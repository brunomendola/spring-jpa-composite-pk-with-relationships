package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"activity", "subId"}, callSuper = false)
@ToString(of = {"activity", "subId"})
@Entity
@Table(name = "S3TSG_SAT_SAZ")
public class ActivityAction implements Serializable {
  @EmbeddedId
  @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED)
  private ActivityActionPK pk = new ActivityActionPK();
  @ManyToOne
  @JoinColumn(name = "SAT_SAZ_SAT_COD", referencedColumnName = "SAT_COD", nullable = false, insertable = false, updatable = false)
  private Activity activity;
  @Column(name = "SAT_SAZ_SUBID", nullable = false, length = 10, insertable = false, updatable = false)
  private String subId;
  @ManyToOne
  @JoinColumn(name = "SAT_SAZ_SAZ_COD", referencedColumnName = "SAZ_COD", nullable = false)
  private Action action;

  public ActivityAction(Activity activity, Action action, String subId) {
    this.setActivity(activity);
    this.action = action;
    this.setSubId(subId);
  }

  private void setActivity(Activity activity) {
    this.activity = activity;
    this.pk.setActivity(activity);
  }

  private void setSubId(String subId) {
    this.subId = subId;
    this.pk.setSubId(subId);
  }

}

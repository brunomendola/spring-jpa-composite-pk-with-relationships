package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"activity", "subId"}, callSuper = false)
@ToString(of = {"activity", "subId"})
@Entity
@IdClass(ActivityActionPK.class)
@Table(name = "S3TSG_SAT_SAZ")
public class ActivityAction implements Serializable {
  @Column(name = "SAT_SAZ_SAT_COD", nullable = false, length = 10)
  @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED)
  private String activityCode;

  @ManyToOne
  @JoinColumn(name = "SAT_SAZ_SAT_COD", referencedColumnName = "SAT_COD", nullable = false, insertable = false, updatable = false)
  private Activity activity;
  @Id
  @Column(name = "SAT_SAZ_SUBID", nullable = false, length = 10)
  private String subId;
  @ManyToOne
  @JoinColumn(name = "SAT_SAZ_SAZ_COD", referencedColumnName = "SAZ_COD", nullable = false)
  private Action action;

  public ActivityAction(Activity activity, Action action, String subId) {
    this.setActivity(activity);
    this.action = action;
    this.subId = subId;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
    this.activityCode = activity.getCode();
  }
}

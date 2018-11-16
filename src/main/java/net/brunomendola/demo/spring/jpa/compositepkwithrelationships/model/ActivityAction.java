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
  @Id
  @ManyToOne
  @JoinColumn(name = "SAT_SAZ_SAT_COD", referencedColumnName = "SAT_COD", nullable = false)
  private Activity activity;
  @Id
  @Column(name = "SAT_SAZ_SUBID", nullable = false, length = 10)
  private String subId;
  @ManyToOne
  @JoinColumn(name = "SAT_SAZ_SAZ_COD", referencedColumnName = "SAZ_COD", nullable = false)
  private Action action;

  public ActivityAction(Activity activity, Action action, String subId) {
    this.activity = activity;
    this.action = action;
    this.subId = subId;
  }

}

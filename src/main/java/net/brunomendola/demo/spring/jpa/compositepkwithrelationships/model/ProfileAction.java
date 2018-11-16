package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"profile", "action"}, callSuper = false)
@ToString(of = {"profile", "action"})
@Entity
@IdClass(ProfileActionPK.class)
@Table(name = "S3TSG_SPR_SAT_SAZ")
public class ProfileAction implements Serializable {
  @Id
  @ManyToOne
  @JoinColumn(name = "SPR_SAT_SAZ_SPR_COD", referencedColumnName = "SPR_COD", nullable = false)
  private Profile profile;
  @Id
  @ManyToOne
  @JoinColumns({@JoinColumn(name = "SPR_SAT_SAZ_SAT_COD", referencedColumnName = "SAT_SAZ_SAT_COD", nullable = false), @JoinColumn(name = "SPR_SAT_SAZ_SAZ_SUBID", referencedColumnName = "SAT_SAZ_SUBID", nullable = false)})
  private ActivityAction action;

  public ProfileAction(Profile profile, ActivityAction action) {
    this.profile = profile;
    this.action = action;
  }

}

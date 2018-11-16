package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"profile", "action"}, callSuper = false)
@ToString(of = {"profile", "action"})
@Entity
@Table(name = "S3TSG_SPR_SAT_SAZ")
public class ProfileAction implements Serializable {
  @EmbeddedId
  @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED)
  private ProfileActionPK pk = new ProfileActionPK();
  @ManyToOne
  @JoinColumn(name = "SPR_SAT_SAZ_SPR_COD", referencedColumnName = "SPR_COD", nullable = false, insertable = false, updatable = false)
  private Profile profile;
  @ManyToOne
  @JoinColumns({@JoinColumn(name = "SPR_SAT_SAZ_SAT_COD", referencedColumnName = "SAT_SAZ_SAT_COD", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "SPR_SAT_SAZ_SAZ_SUBID", referencedColumnName = "SAT_SAZ_SUBID", nullable = false, insertable = false, updatable = false)})
  private ActivityAction action;

  public ProfileAction(Profile profile, ActivityAction action) {
    this.setProfile(profile);
    this.setAction(action);
  }

  private void setAction(ActivityAction action) {
    this.action = action;
    this.pk.setAction(action);
  }

  private void setProfile(Profile profile) {
    this.profile = profile;
    this.pk.setProfile(profile);
  }

}

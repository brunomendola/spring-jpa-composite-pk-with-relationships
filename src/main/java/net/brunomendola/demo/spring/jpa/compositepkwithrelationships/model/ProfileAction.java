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
  @Column(name = "SPR_SAT_SAZ_SPR_COD", nullable = false, length = 10)
  @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED)
  private String profileCode;
  @Id
  @Column(name = "SPR_SAT_SAZ_SAT_COD", nullable = false, length = 10)
  @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED)
  private String activityCode;
  @Id
  @Column(name = "SPR_SAT_SAZ_SAZ_SUBID", nullable = false, length = 10)
  @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED)
  private String actionSubId;

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

  private void setProfile(Profile profile) {
    this.profile = profile;
    this.profileCode = profile.getCode();
  }

  private void setAction(ActivityAction action) {
    this.action = action;
    this.activityCode = action.getActivityCode();
    this.actionSubId = action.getSubId();
  }
}

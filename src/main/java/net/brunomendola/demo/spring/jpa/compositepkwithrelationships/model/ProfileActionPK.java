package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProfileActionPK implements Serializable {
  @ManyToOne
  @JoinColumn(name = "SPR_SAT_SAZ_SPR_COD", referencedColumnName = "SPR_COD", nullable = false)
  private Profile profile;
  @ManyToOne
  @JoinColumns({@JoinColumn(name = "SPR_SAT_SAZ_SAT_COD", referencedColumnName = "SAT_SAZ_SAT_COD", nullable = false), @JoinColumn(name = "SPR_SAT_SAZ_SAZ_SUBID", referencedColumnName = "SAT_SAZ_SUBID", nullable = false)})
  private ActivityAction action;

}

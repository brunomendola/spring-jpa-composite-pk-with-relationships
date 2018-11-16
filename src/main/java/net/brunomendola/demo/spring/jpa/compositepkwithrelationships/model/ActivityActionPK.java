package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ActivityActionPK implements Serializable {
  @ManyToOne
  @JoinColumn(name = "SAT_SAZ_SAT_COD", referencedColumnName = "SAT_COD", nullable = false)
  private Activity activity;
  @Column(name = "SAT_SAZ_SUBID", nullable = false, length = 10)
  private String subId;

}

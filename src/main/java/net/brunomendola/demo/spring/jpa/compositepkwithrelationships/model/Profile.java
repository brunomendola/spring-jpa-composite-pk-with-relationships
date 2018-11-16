package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "code", callSuper = false)
@ToString(of = "code")
@Entity
@Table(name = "S3TSG_SPR")
public class Profile implements Serializable {
  @Id
  @Column(name = "SPR_COD", nullable = false, length = 10)
  private String code;

  public Profile(String code) {
    this.code = code;
  }

}

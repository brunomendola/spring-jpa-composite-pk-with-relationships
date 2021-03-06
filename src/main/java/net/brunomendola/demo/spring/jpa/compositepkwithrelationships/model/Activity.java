package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "code", callSuper = false)
@ToString(of = "code")
@Entity
@Table(name = "S3TSG_SAT")
public class Activity implements Serializable {
  @Id
  @Column(name = "SAT_COD", nullable = false, length = 10)
  private String code;

  public Activity(String code) {
    this.code = code;
  }

}

package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "code", callSuper = false)
@ToString(of = "code")
@Entity
@Table(name = "S3TSG_SAZ")
public class Action implements Serializable {
  @Id
  @Column(name = "SAZ_COD", nullable = false, length = 10)
  private String code;

  public Action(String code) {
    this.code = code;
  }

}

package net.brunomendola.demo.spring.jpa.compositepkwithrelationships.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileActionPK implements Serializable {
  private String profileCode;
  private String activityCode;
  private String actionSubId;

}

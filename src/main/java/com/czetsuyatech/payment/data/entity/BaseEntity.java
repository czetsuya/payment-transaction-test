package com.czetsuyatech.payment.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base of all entity classes.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler"})
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

  public static final int NB_PRECISION = 23;
  public static final int NB_DECIMALS = 12;

  @Id
  @GeneratedValue
  @Column(updatable = false)
  private Long id;

  @Version
  @Column(name = "version")
  private Integer version;
}

package com.czetsuyatech.payment.data.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entity of the payment installments.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Entity
@Table(name = "payment_transaction_line")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString(callSuper = true)
public class PaymentTransactionLine extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private PaymentTransaction paymentTransaction;

  @Column(name = "paid_amount", precision = NB_PRECISION, scale = NB_DECIMALS)
  private BigDecimal paidAmount;
}

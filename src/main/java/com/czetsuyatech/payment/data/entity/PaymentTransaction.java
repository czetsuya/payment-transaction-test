package com.czetsuyatech.payment.data.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entity of the parent transaction.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Entity
@Table(name = "payment_transaction")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString(callSuper = true)
public class PaymentTransaction extends BaseEntity {

  public PaymentTransaction(String sender, String receiver, BigDecimal totalAmount) {
    this.sender = sender;
    this.receiver = receiver;
    this.totalAmount = totalAmount;
  }

  @OneToMany(mappedBy = "paymentTransaction", fetch = FetchType.LAZY)
  private List<PaymentTransactionLine> paymentTransactionLines;

  @Column(name = "sender", nullable = false)
  private String sender;

  @Column(name = "receiver", nullable = false)
  private String receiver;

  @Column(name = "total_amount", precision = NB_PRECISION, scale = NB_DECIMALS)
  private BigDecimal totalAmount;
}

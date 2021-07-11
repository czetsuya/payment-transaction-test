package com.czetsuyatech.payment.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto of the payment transaction. It contains the total and paid amount fields.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Data
@NoArgsConstructor
public class PaymentTransactionDto extends BaseEntityDto {

  private Long id;
  private String sender;
  private String receiver;
  private BigDecimal totalAmount = new BigDecimal(0);
  private BigDecimal paidAmount = new BigDecimal(0);

  public PaymentTransactionDto(Long id, String sender, String receiver, BigDecimal totalAmount, BigDecimal paidAmount) {
    this.id = id;
    this.sender = sender;
    this.receiver = receiver;
    this.totalAmount = totalAmount;
    if (paidAmount != null) {
      this.paidAmount = paidAmount;
    }
  }
}

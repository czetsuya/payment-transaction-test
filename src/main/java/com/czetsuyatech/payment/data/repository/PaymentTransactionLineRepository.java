package com.czetsuyatech.payment.data.repository;

import com.czetsuyatech.payment.business.domain.PaymentTransactionDto;
import com.czetsuyatech.payment.data.entity.PaymentTransactionLine;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for payment transaction line.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Repository
public interface PaymentTransactionLineRepository extends BaseRepository<PaymentTransactionLine, Long> {

  @Query(value =
      "SELECT new com.czetsuyatech.payment.business.domain.PaymentTransactionDto(l.id, l.paymentTransaction.sender, l"
          + ".paymentTransaction.receiver, l.paymentTransaction.totalAmount, l.paidAmount) FROM "
          + "PaymentTransactionLine l WHERE l.paymentTransaction.id = :paymentTransactionId")
  List<PaymentTransactionDto> findInstallmentsByTransaction(@Param("paymentTransactionId") Long paymentTransactionId);
}

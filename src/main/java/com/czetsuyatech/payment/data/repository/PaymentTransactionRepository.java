package com.czetsuyatech.payment.data.repository;

import com.czetsuyatech.payment.business.domain.PaymentTransactionDto;
import com.czetsuyatech.payment.data.entity.PaymentTransaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for payment transaction.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Repository
public interface PaymentTransactionRepository extends BaseRepository<PaymentTransaction, Long> {

  @Query(value = "SELECT new com.czetsuyatech.payment.business.domain.PaymentTransactionDto(t.id, t.sender, t"
      + ".receiver, t.totalAmount, SUM(l.paidAmount)) FROM PaymentTransaction t LEFT JOIN t.paymentTransactionLines l"
      + " GROUP BY t")
  List<PaymentTransactionDto> findAllTransactions(Pageable pageable);
}

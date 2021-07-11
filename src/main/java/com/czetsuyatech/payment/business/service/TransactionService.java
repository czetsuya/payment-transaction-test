package com.czetsuyatech.payment.business.service;

import com.czetsuyatech.payment.business.domain.PaymentTransactionDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 * Payment transaction functions.
 */
public interface TransactionService {

  /**
   * Gets paged transactions from the database.
   *
   * @param pageable paging information
   * @return list of payment transactions
   * @see PaymentTransactionDto
   */
  List<PaymentTransactionDto> findAllTransactions(Pageable pageable);

  /**
   * Gets all the installment payments of a particular transaction.
   *
   * @param paymentTransactionId id of the parent transaction
   * @return list of payment transactions
   * @see PaymentTransactionDto
   */
  List<PaymentTransactionDto> findInstallmentsByTransaction(Long paymentTransactionId);
}

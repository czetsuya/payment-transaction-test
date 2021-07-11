package com.czetsuyatech.payment.business.service.impl;

import com.czetsuyatech.payment.business.domain.PaymentTransactionDto;
import com.czetsuyatech.payment.business.service.TransactionService;
import com.czetsuyatech.payment.data.repository.PaymentTransactionLineRepository;
import com.czetsuyatech.payment.data.repository.PaymentTransactionRepository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
@Service
public class PaymentTransactionService implements TransactionService {

  private PaymentTransactionRepository paymentTransactionRepository;
  private PaymentTransactionLineRepository paymentTransactionLineRepository;

  public PaymentTransactionService(
      PaymentTransactionRepository paymentTransactionRepository,
      PaymentTransactionLineRepository paymentTransactionLineRepository) {
    this.paymentTransactionRepository = paymentTransactionRepository;
    this.paymentTransactionLineRepository = paymentTransactionLineRepository;
  }

  public List<PaymentTransactionDto> findAllTransactions(Pageable pageable) {
    return paymentTransactionRepository.findAllTransactions(pageable);
  }

  public List<PaymentTransactionDto> findInstallmentsByTransaction(Long paymentTransactionId) {
    return paymentTransactionLineRepository.findInstallmentsByTransaction(paymentTransactionId);
  }
}

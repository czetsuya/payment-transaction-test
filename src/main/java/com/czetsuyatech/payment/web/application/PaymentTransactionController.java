package com.czetsuyatech.payment.web.application;

import com.czetsuyatech.payment.business.domain.PaymentTransactionDto;
import com.czetsuyatech.payment.business.service.TransactionService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for payments.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping(value = "/payment-transactions")
public class PaymentTransactionController extends AbstractController {

  private TransactionService transactionService;

  public PaymentTransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @GetMapping
  public ResponseEntity<List<PaymentTransactionDto>> getPagedPaymentTransactions(
      @RequestParam(required = false) Integer size,
      @RequestParam(required = false) Integer page) {

    Pageable pageable = initPage(page, size);

    List<PaymentTransactionDto> result = transactionService.findAllTransactions(pageable);

    return ResponseEntity.ok().body(result);
  }

  @GetMapping(value = "/{paymentTransactionId}/installments")
  public ResponseEntity<List<PaymentTransactionDto>> getInstallmentsByPaymentId(
      @PathVariable Long paymentTransactionId) {

    List<PaymentTransactionDto> result =
        transactionService.findInstallmentsByTransaction(paymentTransactionId);

    return ResponseEntity.ok().body(result);
  }
}

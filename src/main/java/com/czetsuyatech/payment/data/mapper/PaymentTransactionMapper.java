package com.czetsuyatech.payment.data.mapper;

import com.czetsuyatech.payment.business.domain.PaymentTransactionDto;
import com.czetsuyatech.payment.data.entity.PaymentTransaction;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

/**
 * Payment transaction mapper.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Mapper
public interface PaymentTransactionMapper extends Converter<PaymentTransaction, PaymentTransactionDto> {

  PaymentTransactionDto convert(PaymentTransaction paymentTransaction);
}

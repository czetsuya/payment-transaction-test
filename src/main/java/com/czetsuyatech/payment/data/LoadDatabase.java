package com.czetsuyatech.payment.data;

import com.czetsuyatech.payment.data.repository.PaymentTransactionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is use to seed the database for testing.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Configuration
@Log4j2
public class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(final PaymentTransactionRepository paymentTransactionRepository) {

    return args -> {
      /*//1
      paymentTransactionRepository.save(new PaymentTransaction("ABC", "XYZ", BigDecimal.valueOf(200L)));

      //2
      paymentTransactionRepository.save(new PaymentTransaction("XYZ", "MNP", new BigDecimal(100)));
      //3
      paymentTransactionRepository.save(new PaymentTransaction("XYZ", "MNP", new BigDecimal(300)));
      //4
      paymentTransactionRepository.save(new PaymentTransaction("ABC", "MNP", new BigDecimal(1000)));
      //5
      paymentTransactionRepository.save(new PaymentTransaction("XYZ", "ABC", new BigDecimal(50)));
      //6
      paymentTransactionRepository.save(new PaymentTransaction("MNP", "PQRS", new BigDecimal(200)));
      //7
      paymentTransactionRepository.save(new PaymentTransaction("ABC", "PQRS", new BigDecimal(200)));*/
    };
  }
}

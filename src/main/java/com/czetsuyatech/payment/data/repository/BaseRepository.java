package com.czetsuyatech.payment.data.repository;

import com.czetsuyatech.payment.data.entity.BaseEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base of all repositories.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, I extends Serializable> extends JpaRepository<T, I> {

}

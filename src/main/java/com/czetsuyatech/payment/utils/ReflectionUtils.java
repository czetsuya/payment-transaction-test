package com.czetsuyatech.payment.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

/**
 * Utility methods for reflection.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class ReflectionUtils {

  private ReflectionUtils() {

  }

  @SuppressWarnings("rawtypes")
  public static Object getParameterTypeClass(Class clazz, int parameterIndex) {
    while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
      clazz = clazz.getSuperclass();
    }

    Object o = ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[parameterIndex];

    if (o instanceof TypeVariable) {
      return ((TypeVariable) o).getBounds()[parameterIndex];

    } else {
      return o;
    }
  }
}

package com.czetsuyatech.payment.web.application;

import com.czetsuyatech.payment.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Base REST endpoint controller that contain common methods.
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public abstract class AbstractController {

  public static final int DEFAULT_PAGE_SIZE = 10;

  /**
   * Binds the validator and default date format. For example, if we passed a string {@linkplain java.util.Date} with
   * the given format it is automatically parsed.
   *
   * @param binder data binder
   * @see CustomDateEditor
   */
  @InitBinder
  protected void initBinder(WebDataBinder binder) {

//    binder.setValidator(validator);

    SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtils.SDF_STRING);
    binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, true));
  }

  protected Pageable initPage(Integer page, Integer size) {

    if (size == null) {
      size = DEFAULT_PAGE_SIZE;
    }
    if (page == null) {
      page = 0;
    }

    return PageRequest.of(page, size);
  }
}

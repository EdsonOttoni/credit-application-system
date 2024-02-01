package me.dio.credit.application.system.exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDate

@RestControllerAdvice
class RestExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun handlerValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails> {
    val errs: MutableMap<String, String?> = HashMap()
    ex.bindingResult.allErrors.stream().forEach { error: ObjectError ->
      val fieldName: String = (error as FieldError).field
      val messageError: String? = error.defaultMessage
      errs[fieldName] = messageError
    }

    return ResponseEntity(
      ExceptionDetails(
        title = "Bad Request! Consult the documentation",
        timestamp = LocalDate.now(),
        status = HttpStatus.BAD_REQUEST.value(),
        exception = ex.javaClass.toString(),
        details = errs
      ), HttpStatus.BAD_REQUEST
    )
  }

  @ExceptionHandler(DataAccessException::class)
  fun handlerValidException(ex: DataAccessException): ResponseEntity<ExceptionDetails> {
    return ResponseEntity(
      ExceptionDetails(
        title = "Conflict! Consult the documentation",
        timestamp = LocalDate.now(),
        status = HttpStatus.CONFLICT.value(),
        exception = ex.javaClass.toString(),
        details = mutableMapOf(ex.cause.toString() to ex.message)
      ), HttpStatus.CONFLICT
    )
  }

  @ExceptionHandler(BusinessException::class)
  fun handlerValidException(ex: BusinessException): ResponseEntity<ExceptionDetails> {
    return ResponseEntity(
      ExceptionDetails(
        title = "BAD_REQUEST! Consult the documentation",
        timestamp = LocalDate.now(),
        status = HttpStatus.BAD_REQUEST.value(),
        exception = ex.javaClass.toString(),
        details = mutableMapOf(ex.cause.toString() to ex.message)
      ), HttpStatus.BAD_REQUEST
    )
  }

  @ExceptionHandler(IllegalStateException::class)
  fun handlerValidException(ex: IllegalStateException): ResponseEntity<ExceptionDetails> {
    return ResponseEntity(
      ExceptionDetails(
        title = "BAD_REQUEST! Consult the documentation",
        timestamp = LocalDate.now(),
        status = HttpStatus.BAD_REQUEST.value(),
        exception = ex.javaClass.toString(),
        details = mutableMapOf(ex.cause.toString() to ex.message)
      ), HttpStatus.BAD_REQUEST
    )
  }
}
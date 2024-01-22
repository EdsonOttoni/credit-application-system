package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
  @field:NotNull(message = "Invalid Input") val creditValue: BigDecimal,
  @field:Future val dayFirstOfInstallment: LocalDate,
  val numberOfInstallments: Int,
  @field:NotNull(message = "Invalid Input") val customerId: Long
) {

  fun toEntity(): Credit = Credit(
    creditValue = this.creditValue,
    dayFistInstallment = this.dayFirstOfInstallment,
    customer = Customer(id = this.customerId)
  )

}

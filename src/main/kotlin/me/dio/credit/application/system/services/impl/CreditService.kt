package me.dio.credit.application.system.services.impl

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.shared.exception.BusinessException
import me.dio.credit.application.system.repositories.CreditRepository
import me.dio.credit.application.system.services.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
  private val creditRepository: CreditRepository, private val customerService: CustomerService
) : ICreditService {
  override fun save(credit: Credit): Credit {
    credit.apply {
      customer = customerService.findById(credit.customer?.id!!)
    }

    return this.creditRepository.save(credit)
  }

  override fun findAllByCustomer(customerId: Long): List<Credit> {
    return this.creditRepository.findAllByCustomer(customerId)
  }

  override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
    val credit: Credit =
      (this.creditRepository.findByCreditCode(creditCode) ?: throw BusinessException("CreditCode $creditCode not found"))
    return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact admin")
  }
}
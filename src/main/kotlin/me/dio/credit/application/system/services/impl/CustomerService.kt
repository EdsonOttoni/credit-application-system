package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.repositories.CustomerRepository
import me.dio.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
  private val customerRepository: CustomerRepository
) : ICustomerService {
  override fun save(customer: Customer): Customer = this.customerRepository.save(customer)
  override fun findByEmail(email: String): Customer =
    this.customerRepository.findByEmail(email) ?: throw RuntimeException("User not found")

  override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
    throw RuntimeException("Id $id not found")
  }

  override fun delete(id: Long) {
    val customer: Customer = this.findById(id)
    this.customerRepository.delete(customer)
  }
}


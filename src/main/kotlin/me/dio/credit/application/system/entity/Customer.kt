package me.dio.credit.application.system.entity

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.math.BigDecimal

@Entity
data class Customer(
  @Column(nullable = false) var firstName: String = "",
  @Column(nullable = false) var lastName: String = "",
  @Column(nullable = false, unique = true) var cpf: String = "",
  @Column(nullable = false, unique = true) var email: String = "",
  @Column(nullable = false) private var password: String = "",
  @Column(nullable = false) @Embedded var address: Address = Address(),
  @Column(nullable = false) var income: BigDecimal = BigDecimal.ZERO,
  @Column(nullable = false) @OneToMany(
    fetch = FetchType.LAZY,
    mappedBy = "customer",
    cascade = arrayOf(CascadeType.REMOVE)
  ) var credits: List<Credit> = mutableListOf(),
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
) : UserDetails {
  override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
    return null
  }

  override fun getPassword(): String {
    return password
  }

  override fun getUsername(): String {
    return email
  }

  override fun isAccountNonExpired(): Boolean {
    return true
  }

  override fun isAccountNonLocked(): Boolean {
    return true
  }

  override fun isCredentialsNonExpired(): Boolean {
    return true
  }

  override fun isEnabled(): Boolean {
    return true
  }
}
package me.dio.credit.application.system.shared.exception

data class BusinessException(override val message: String?): RuntimeException(message) {
}
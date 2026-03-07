package dev.gustavoraposo.honey_money_mobile.domain.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<String>
}
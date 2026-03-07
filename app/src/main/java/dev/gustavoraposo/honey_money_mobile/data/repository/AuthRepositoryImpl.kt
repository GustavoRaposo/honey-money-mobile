package dev.gustavoraposo.honey_money_mobile.data.repository

import dev.gustavoraposo.honey_money_mobile.data.remote.AuthApiService
import dev.gustavoraposo.honey_money_mobile.data.remote.dto.LoginRequestDto
import dev.gustavoraposo.honey_money_mobile.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService
) : AuthRepository {

    override suspend fun login(email: String, password: String): Result<String> {
        return try {
            val response = authApiService.login(LoginRequestDto(email, password))
            if (response.isSuccessful) {
                val accessToken = response.body()?.accessToken
                if (accessToken != null) {
                    Result.success(accessToken)
                } else {
                    Result.failure(Exception("Resposta vazia do servidor"))
                }
            } else {
                Result.failure(Exception("Erro ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

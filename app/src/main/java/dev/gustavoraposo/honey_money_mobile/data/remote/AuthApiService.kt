package dev.gustavoraposo.honey_money_mobile.data.remote

import dev.gustavoraposo.honey_money_mobile.data.remote.dto.LoginRequestDto
import dev.gustavoraposo.honey_money_mobile.data.remote.dto.LoginResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequestDto): Response<LoginResponseDto>
}
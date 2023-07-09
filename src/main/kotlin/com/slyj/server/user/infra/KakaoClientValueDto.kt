package com.slyj.server.user.infra

import com.fasterxml.jackson.annotation.JsonProperty

class KakaoClientValueDto(
    val clientId: String?,
    val redirectUri: String?,
    private val grantType: String = "authorization_code",
    val code: String?
) {
    fun toUrlEncodedString(): String {
        return "code=${code}&client_id=${clientId}&redirect_uri=${redirectUri}&grant_type=${grantType}"
    }
}

class KakaoAccessTokenResponse(
    @JsonProperty("token_type")
    val tokenType: String? = null,

    @JsonProperty("access_token")
    val accessToken: String? = null,

    @JsonProperty("id_token")
    val idToken: String? = null,

    @JsonProperty("expires_in")
    val expiresIn: Int? = null,

    @JsonProperty("refresh_token")
    val refreshToken: String? = null,

    @JsonProperty("refresh_token_expires_in")
    val refreshTokenExpiresIn: Int? = null
)
package com.slyj.server.user.infra

import com.fasterxml.jackson.annotation.JsonProperty

class GoogleClientValueDto(
    val clientId: String,
    val clientSecret: String,
    val scope: String,
    val redirectUri: String,
    val grantType: String = "authorization_code",
    val code: String
)

class GoogleAccessTokenResponse(
    @JsonProperty("access_token")
    var accessToken: String,

    @JsonProperty("expires_in")
    var expiresIn: String? = null,

    @JsonProperty("refresh_token")
    var refreshToken: String? = null,

    @JsonProperty("scope")
    var scope: String? = null,

    @JsonProperty("token_type")
    var tokenType: String? = null
)
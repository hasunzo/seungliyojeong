package com.slyj.server.user.application

import com.slyj.server.user.SocialProperty
import com.slyj.server.user.SocialProvider.GOOGLE
import com.slyj.server.user.SocialProvider.KAKAO
import com.slyj.server.user.infra.GoogleApiClient
import com.slyj.server.user.infra.GoogleClientValueDto
import com.slyj.server.user.infra.GoogleOAuthApiClient
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.URI

@Component
class SocialService(
    private val googleOAuthApiClient: GoogleOAuthApiClient,
    private val googleApiClient: GoogleApiClient
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Value("\${social.google.client-id}")
    lateinit var clientId: String

    @Value("\${social.google.client-secret}")
    lateinit var clientSecret: String

    @Value("\${social.google.scope}")
    lateinit var scope: String

    @Value("\${social.google.redirect-url}")
    lateinit var redirectUri: String

    fun socialProperty(request: RegisterUserRequest): SocialProperty =
        when (request.type) {
            KAKAO -> fetchKakao(request)
            GOOGLE -> fetchGoogle(request)
            else -> throw IllegalArgumentException()
        }

    fun fetchKakao(request: RegisterUserRequest): SocialProperty {
        TODO("카카오 소셜 로그인 개발")
    }

    fun fetchGoogle(request: RegisterUserRequest): SocialProperty {
        val googleRequest = GoogleClientValueDto(
            clientId = clientId,
            clientSecret = clientSecret,
            scope = scope,
            redirectUri = redirectUri,
            code = request.token
        )

        val accessToken = googleOAuthApiClient.getAccessToken(googleRequest)
        return googleApiClient.getUserInfo("Bearer ".plus(accessToken.accessToken))
    }
}
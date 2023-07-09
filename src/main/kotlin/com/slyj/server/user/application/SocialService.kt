package com.slyj.server.user.application

import com.slyj.server.user.SocialProperty
import com.slyj.server.user.SocialProvider.GOOGLE
import com.slyj.server.user.SocialProvider.KAKAO
import com.slyj.server.user.infra.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SocialService(
    private val googleOAuthApiClient: GoogleOAuthApiClient,
    private val googleApiClient: GoogleApiClient,
    private val kakaoOAuthApiClient: KakaoOAuthApiClient,
    private val kakaoApiClient: KakaoApiClient
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Value("\${social.google.client-id}")
    lateinit var googleClientId: String

    @Value("\${social.google.client-secret}")
    lateinit var googleClientSecret: String

    @Value("\${social.google.scope}")
    lateinit var googleScope: String

    @Value("\${social.google.redirect-uri}")
    lateinit var googleRedirectUri: String

    @Value("\${social.kakao.client-id}")
    lateinit var kakaoClientId: String

    @Value("\${social.kakao.redirect-uri}")
    lateinit var kakaoRedirectUri: String

    fun socialProperty(request: RegisterUserRequest): SocialProperty =
        when (request.type) {
            KAKAO -> fetchKakao(request)
            GOOGLE -> fetchGoogle(request)
            else -> throw IllegalArgumentException()
        }

    fun fetchKakao(request: RegisterUserRequest): SocialProperty {
        val kakaoRequest = KakaoClientValueDto(
            clientId = kakaoClientId,
            redirectUri = kakaoRedirectUri,
            code = request.token
        )

        val accessToken = kakaoOAuthApiClient.getAccessToken(kakaoRequest.toUrlEncodedString())
        return kakaoApiClient.getUserInfo("Bearer ".plus(accessToken.accessToken))
    }

    fun fetchGoogle(request: RegisterUserRequest): SocialProperty {
        val googleRequest = GoogleClientValueDto(
            clientId = googleClientId,
            clientSecret = googleClientSecret,
            scope = googleScope,
            redirectUri = googleRedirectUri,
            code = request.token
        )

        val accessToken = googleOAuthApiClient.getAccessToken(googleRequest)
        return googleApiClient.getUserInfo("Bearer ".plus(accessToken.accessToken))
    }
}
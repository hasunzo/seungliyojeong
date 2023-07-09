package com.slyj.server.user.infra

import com.slyj.server.user.GoogleProperty
import com.slyj.server.user.KakaoProperty
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(name = "google-oauth-api", url = "https://oauth2.googleapis.com")
interface GoogleOAuthApiClient {

    @PostMapping(value = ["/token"])
    fun getAccessToken(request: GoogleClientValueDto): GoogleAccessTokenResponse
}

@FeignClient(name = "google-api", url = "https://www.googleapis.com")
interface GoogleApiClient {
    //    @GetMapping(value = ["/oauth2/v1/userinfo"])
    //    @RequestMapping(method = [RequestMethod.GET], value = ["/oauth2/v1/userinfo"])
//    @RequestLine("GET /oauth2/v1/userinfo")
//    @Headers("Authorization: Bearer {accessToken}")
    @GetMapping("/oauth2/v2/userinfo")
    fun getUserInfo(@RequestHeader("Authorization") accessToken: String): GoogleProperty
}

@FeignClient(name = "kakao-oauth-api", url = "https://kauth.kakao.com", configuration = [KakaoFeignConfiguration::class])
interface KakaoOAuthApiClient {

    @PostMapping(value = ["/oauth/token"]/*, consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE]*/)
    fun getAccessToken(string: String): KakaoAccessTokenResponse
}

@FeignClient(name = "kakao-api", url = "https://kapi.kakao.com")
interface KakaoApiClient {
    @PostMapping("/v2/user/me")
    fun getUserInfo(@RequestHeader("Authorization") accessToken: String): KakaoProperty
}
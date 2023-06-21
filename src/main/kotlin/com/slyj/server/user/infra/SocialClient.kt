package com.slyj.server.user.infra

import com.slyj.server.user.GoogleProperty
import feign.HeaderMap
import feign.Headers
import feign.Param
import feign.RequestLine
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
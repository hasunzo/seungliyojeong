package com.slyj.server.user.api

import com.slyj.server.common.domain.ApiResponse
import com.slyj.server.user.application.RegisterUserRequest
import com.slyj.server.user.application.UserAuthenticationService
import com.slyj.server.user.infra.GoogleAccessTokenResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/users")
@RestController
class UserRestController(
    private val userAuthenticationService: UserAuthenticationService
) {
    @PostMapping("/register")
    fun generateToken(
        @RequestBody @Valid request: RegisterUserRequest
    ): ResponseEntity<ApiResponse<String>> {
        val token = userAuthenticationService.generateTokenByRegister(request)
        return ResponseEntity.ok(ApiResponse.success(token))
    }

    @PostMapping("/register/callback")
    fun callback(@RequestBody request: GoogleAccessTokenResponse) {

    }
}
package com.slyj.server.user.application

import com.slyj.server.common.security.JwtTokenProvider
import com.slyj.server.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class UserAuthenticationService(
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val socialService: SocialService
) {
    fun generateTokenByRegister(request: RegisterUserRequest): String {
        val socialProfile = socialService.socialProperty(request)
        check(!userRepository.existsByEmail(socialProfile.email)) { "이미 가입된 이메일입니다." }
        val user = request.toEntity(socialProfile)
        userRepository.save(user)
        return jwtTokenProvider.createToken(user.email)
    }
}
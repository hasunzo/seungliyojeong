package com.slyj.server.user.application

import com.slyj.server.user.SocialProperty
import com.slyj.server.user.SocialProvider
import com.slyj.server.user.domain.User

data class RegisterUserRequest(
    // google: code
    val token: String,
    val type: SocialProvider,
    val name: String,
    val team: String
) {
    fun toEntity(socialProperty: SocialProperty): User {
        // TODO 팀 추가 필요
        return User(name = name, email = socialProperty.email)
    }
}
package com.slyj.server.user

import com.fasterxml.jackson.annotation.JsonProperty

class KakaoProperty(
//    override val email: String = "",
    @JsonProperty("id")
    override val userId: String = "",
    @JsonProperty("kakao_account")
    val kakaoAccount: KakaoAccount
) : SocialProperty {
    override val email: String
        get() = kakaoAccount.email
}

class KakaoAccount(
    val email: String
)
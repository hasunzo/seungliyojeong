package com.slyj.server.user

enum class SocialProvider(
    val endPoint: String,
    val propertyMetaClass: Class<out SocialProperty>
) {
    KAKAO("https://kapi.kakao.com/v2/user/me", KakaoProperty::class.java),
    GOOGLE("https://oauth2.googleapis.com/token", GoogleProperty::class.java)
}
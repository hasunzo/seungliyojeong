package com.slyj.server.user.infra

import feign.RequestInterceptor
import feign.RequestTemplate
import feign.codec.Encoder
import feign.form.FormEncoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter

@Configuration
class KakaoFeignConfiguration {
    @Bean
    fun requestInterceptor(): RequestInterceptor =
        RequestInterceptor { template ->
            template.header(
                "Content-Type",
                "application/x-www-form-urlencoded"
            )
        }
}
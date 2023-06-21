package com.slyj.server.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter


@Configuration
class WebConfig {
    @Bean
    fun requestLoggingFilter(): CommonsRequestLoggingFilter {
        val c = CommonsRequestLoggingFilter()
        c.setIncludeHeaders(true)
        c.setIncludeQueryString(true)
        c.setIncludePayload(true)
        c.setIncludeClientInfo(true)
        c.setMaxPayloadLength(100000)
        return c
    }
}
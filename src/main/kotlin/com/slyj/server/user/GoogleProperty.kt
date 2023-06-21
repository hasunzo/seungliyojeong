package com.slyj.server.user

import com.fasterxml.jackson.annotation.JsonProperty

class GoogleProperty(
    @JsonProperty(value = "email")
    override val email: String,
    @JsonProperty(value = "id")
    override val userId: String
) : SocialProperty
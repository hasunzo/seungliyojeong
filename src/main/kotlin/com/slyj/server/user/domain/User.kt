package com.slyj.server.user.domain

import jakarta.persistence.*

@Entity
@Table(name = "Users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @Column(nullable = false)
    val name: String,

    @Column
    val email: String

    // TODO 팀 추가 필요
)
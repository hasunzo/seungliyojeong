package com.server.slyj.user.domain

import jakarta.persistence.*

@Entity
@Table(name = "Users")
class User(
    @Column(nullable = false)
    val name: String,

    @Column
    val email: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
)
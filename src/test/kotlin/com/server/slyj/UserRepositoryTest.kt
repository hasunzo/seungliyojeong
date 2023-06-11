package com.server.slyj

import com.server.slyj.user.domain.User
import com.server.slyj.user.repository.UserRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("local")
@SpringBootTest
class UserRepositoryTest(
    @Autowired
    private val repository: UserRepository
) {
    @Test
    fun name() {
        val user = User("name", "email")
        val save = repository.save(user)
        Assertions.assertThat(user.name).isEqualTo(save.name)
    }
}
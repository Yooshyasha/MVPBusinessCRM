package com.yooshyasha.mvpbussinescrm.services

import com.yooshyasha.mvpbussinescrm.entities.User
import com.yooshyasha.mvpbussinescrm.repos.UsersRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserServiceTest {
    @Mock
    private lateinit var usersRepository: UsersRepository

    @InjectMocks
    private lateinit var userService: UserService

    @Test
    fun testSuccessful_getUserById() {
        val uuid = UUID.randomUUID()

        Mockito.`when`(usersRepository.findById(uuid)).thenReturn(Optional.of(User().also { it.id = uuid }))
    }
}
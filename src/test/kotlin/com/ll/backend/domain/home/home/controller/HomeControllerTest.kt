package com.ll.backend.domain.home.home.controller

import com.ll.backend.domain.home.home.HomeController
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Controller
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import kotlin.test.Test

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class HomeControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    @DisplayName("메인")
    fun t1() {
        val resultActions = mvc
            .perform(
                MockMvcRequestBuilders.get("/")
            )
            .andDo(MockMvcResultHandlers.print())

        resultActions
            .andExpect(MockMvcResultMatchers.handler().handlerType(HomeController::class.java))
            .andExpect(MockMvcResultMatchers.handler().methodName("main"))
            .andExpect(MockMvcResultMatchers.status().isOk())
    }
}
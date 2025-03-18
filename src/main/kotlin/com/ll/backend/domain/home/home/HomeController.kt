package com.ll.backend.domain.home.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.net.InetAddress

@Controller
class HomeController {
    @GetMapping("/")
    @ResponseBody
    fun main(): String {
        val localHost = InetAddress.getLocalHost()

        val hostname = localHost.hostName

        return "main, hostname : $hostname"
    }
}
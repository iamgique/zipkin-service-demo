package com.iamgique.profileservice.controller

import com.iamgique.profileservice.services.ProfileService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@EnableAutoConfiguration
@RestController
@RequestMapping("/api")
class ProfileController @Autowired constructor(
        private val profileService: ProfileService
) {
    private val log: Logger = LogManager.getLogger(ProfileController::class.java.getName())

    @GetMapping
    fun hello(): String {
        return "Hello Kotlin!!"
    }

    @GetMapping("/profile")
    fun getProfile(name: String): String {
        return "Hello $name"
    }

    @GetMapping("/profile/{id}")
    fun getProfileById(@PathVariable(value = "id") id: Int): String {
        log.info("Get profile by id: $id")
        val profile = profileService.getProfileById(id);
        return "Name: ${profile?.name} Lastname: ${profile?.lastname} \nBank Account: ${profile?.bankAccount} \nBalance: ${profile?.balance}"
    }
}
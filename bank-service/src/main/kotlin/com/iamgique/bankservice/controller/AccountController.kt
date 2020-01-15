package com.iamgique.bankservice.controller

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AccountController {
    private val log: Logger = LogManager.getLogger(AccountController::class.java.getName())

    @GetMapping
    fun hello(): String {
        return "Hello Bank Service"
    }

    @GetMapping("/bank-account/{user-id}")
    fun getBankAccountByUserId(@PathVariable(value = "user-id") userId: Int): String {
        log.info("Get bank account by user id: $userId")
        return when (userId) {
            1 -> "303-111-5891"
            2 -> "303-111-5892"
            3 -> "303-111-5893"
            else -> throw Exception("Not found")
        }
    }
}
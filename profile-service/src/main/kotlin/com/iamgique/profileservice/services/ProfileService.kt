package com.iamgique.profileservice.services

import com.iamgique.profileservice.model.Profile
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ProfileService(restTemplateBuilder: RestTemplateBuilder) {
    private val log: Logger = LogManager.getLogger(ProfileService::class.java.getName())

    var restTemplate: RestTemplate = restTemplateBuilder.build()
    fun getProfileById(id: Int): Profile? {
        val profile = Profile()
        try {
            profile.name = getNameById(id)
            profile.lastname = getLastNameById(id)
            log.info("Call bank account by id: $id")
            profile.bankAccount = restTemplate.getForObject("http://localhost:8082/api/bank-account/$id", String::class.java)!!
            profile.balance = restTemplate.getForObject("http://localhost:8083/api/balance/${profile.bankAccount}", Double::class.java)!!

        } catch (e: Exception) {
            log.error(e)
        }
        return profile;
    }

    fun getNameById(id: Int): String {
        return when (id) {
            1 -> "Ryan"
            2 -> "David"
            3 -> "Peter"
            else -> "Unknown"
        }
    }

    fun getLastNameById(id: Int): String {
        return when (id) {
            1 -> "Gique"
            2 -> "Beckham"
            3 -> "Corp"
            else -> "Unknown"
        }
    }
}
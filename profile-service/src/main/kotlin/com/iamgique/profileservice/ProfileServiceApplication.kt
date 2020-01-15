package com.iamgique.profileservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProfileServiceApplication

fun main(args: Array<String>) {
	runApplication<ProfileServiceApplication>(*args)
}
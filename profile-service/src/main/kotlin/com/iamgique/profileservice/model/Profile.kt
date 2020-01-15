package com.iamgique.profileservice.model

import java.text.DecimalFormat

class Profile {
    var name: String = ""
        get() = field
        set(value) { field = value }

    var lastname: String = ""
        get() = field
        set(value) { field = value }

    var bankAccount: String = ""
        get() = field
        set(value) { field = value }

    var balance: Double = 0.00
        get() = field
        set(value) { field = value }
}
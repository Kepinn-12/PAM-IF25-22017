package com.example.tugas3pam_124140073

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
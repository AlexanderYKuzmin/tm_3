package com.kuzmin.tm_3.domain

interface AuthRepository {
    fun authenticate(username: String, password: String): String
}
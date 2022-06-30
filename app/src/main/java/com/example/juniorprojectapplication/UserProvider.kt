package com.example.juniorprojectapplication

import com.example.juniorprojectapplication.data.model.User

class UserProvider {

    companion object{

        private val users = listOf(
            User(username = "William", password = "12345"),
            User(username = "Nicolas", password = "123"),
            User(username = "Maria", password = "12345")
        )

        fun getUsers():List<User>{
            return users
        }

    }
}
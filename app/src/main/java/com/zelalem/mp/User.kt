package com.zelalem.mp

import java.io.Serializable

class User(firstName: String, lastName: String, userName: String, password: String): Serializable{
    var firstName = firstName
    var lastName = lastName
    var userName = userName
    var password = password
}
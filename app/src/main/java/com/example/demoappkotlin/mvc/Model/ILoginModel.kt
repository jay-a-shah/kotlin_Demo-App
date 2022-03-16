package com.example.demoappkotlin.mvc.Model

interface ILoginModel {
       fun getUserEmail(): String?
       fun getUserPassword(): String?
       fun isValid(): Int
}
package com.example.unittestingexample.mock

class UserRepository {
    val users = listOf<User>(
        User(1,"Jaivik","thisisjaivik@gmail.com","jaivik0123"),
        User(2,"Vatsal","vatsal786@gmail.com","vatsal786"),
        User(3,"deep","deepchaudhary@gmail.com","deep0123")
    )

    fun loginUser(email:String,password:String):LOGIN_STATUS{
        val users = users.filter { user->user.email==email }
        return if(users.size==1){
            if (users[0].password==password){
                LOGIN_STATUS.SUCCESS
            }
            else{
                LOGIN_STATUS.INVALID_PASSWORD
            }
        }else{
            LOGIN_STATUS.INVALID_USER
        }
    }
}
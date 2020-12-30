package com.example.monappli.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monappli.domain.usecase.CreateUserUseCase
import com.example.monappli.domain.usecase.GetUserUseCase
import com.example.monappli.domain.usecase.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
  private val createUserUseCase: CreateUserUseCase,
  private val getUserUseCase: GetUserUseCase

) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

   fun onClickedCreate(emailUser: String, password: String){
       viewModelScope.launch(Dispatchers.IO) {
           val newUser = User(emailUser)
           createUserUseCase.invoke(newUser)
          val loginStatus = LoginCreate
           withContext(Dispatchers.Main){
               loginLiveData.value = loginStatus
           }
           println("testCreate")
       }
   }
   fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user : User? = getUserUseCase.invoke(emailUser)
           val loginStatus = if(user != null){
                LoginSuccess(user.email)
            } else {
                LoginError
            }

            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
      // counter.value = (counter.value ?: 0) + 1
   }

    }

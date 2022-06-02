package com.sadikahmetozdemir.univera.ui.signup

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sadikahmetozdemir.univera.base.BaseViewModel
import com.sadikahmetozdemir.univera.utils.DataHelperManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val dataHelperManager: DataHelperManager) :
    BaseViewModel() {
    val username = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")


    fun sendRegisterRequest() = viewModelScope.launch {
        if (!validateFile(
                username.value.toString(),
                email.value.toString(),
                password.value.toString()
            )
        ) {
            showMessage("Boş Alanları Doldurunuz.")
            return@launch
        } else {
            val userToken = dataHelperManager.saveToken(UUID.randomUUID().toString())
            val name = dataHelperManager.saveUsername(username.value.toString())
            val userPassword = dataHelperManager.savePassword(password.value.toString())
            goLogin()


        }
    }

    private fun validateFile(username: String, email: String, password: String): Boolean {
        if (username.isEmpty()) {
            return false
        }
        if (email.isEmpty()) {
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false
        }
        if (password.isEmpty()) {
            return false
        }

        return true
    }

    fun goLogin() {
        viewModelScope.launch {
            navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
        }
    }

}
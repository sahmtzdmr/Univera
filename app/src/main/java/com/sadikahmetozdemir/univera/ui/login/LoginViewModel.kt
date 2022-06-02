package com.sadikahmetozdemir.univera.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sadikahmetozdemir.univera.base.BaseViewModel
import com.sadikahmetozdemir.univera.core.shared.remote.Auth
import com.sadikahmetozdemir.univera.utils.DataHelperManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val dataHelperManager: DataHelperManager) :
    BaseViewModel() {
    val user = MutableLiveData<Auth>()
    val username = MutableLiveData("")
    val password = MutableLiveData("")
    fun sendLoginRequest() = viewModelScope.launch {
        if (username.value.isNullOrBlank() || password.value.isNullOrBlank()) {
            showMessage("Gerekli Alanları Doldurunuz.")
            return@launch
        } else if (username.value == dataHelperManager.getUsername() || password.value == dataHelperManager.getPassword()) {
            navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        }
        else
            showMessage("Kullanıcı bilgileri yanlış.")
    }
    fun goRegister() {
        viewModelScope.launch {
            navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }
    }

}
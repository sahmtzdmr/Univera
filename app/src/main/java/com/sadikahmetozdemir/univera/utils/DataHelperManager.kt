package com.sadikahmetozdemir.univera.utils


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class DataHelperManager @Inject constructor(private val context: Context) {
    suspend fun saveToken(token: String) {
        context.dataStore.edit {
            it[TOKEN] = token
        }
    }

    suspend fun getToken(): String = context.dataStore.data.map {
        it[TOKEN] ?: ""
    }.first()

    suspend fun getUsername(): String = context.dataStore.data.map {
        it[USERNAME] ?: ""
    }.first()

    suspend fun getPassword(): String = context.dataStore.data.map {
        it[PASSWORD] ?: ""
    }.first()

    suspend fun saveUsername(username: String) {
        context.dataStore.edit {
            it[USERNAME] = username
        }
    }

    suspend fun savePassword(password: String) {
        context.dataStore.edit {
            it[PASSWORD] = password
        }

    }

    suspend fun isLogin(): Boolean = getToken().isNotBlank()


    companion object {
        private val PASSWORD = stringPreferencesKey("password")
        private val USERNAME = stringPreferencesKey("username")
        private val TOKEN = stringPreferencesKey("token")
        val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(
            "Data")
    }
}
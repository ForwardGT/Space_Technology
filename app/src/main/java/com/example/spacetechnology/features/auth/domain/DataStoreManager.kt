package com.example.spacetechnology.features.auth.domain

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.spacetechnology.features.auth.domain.entity.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("data_store")

class DataStoreManager(
    private val context: Context
) {
    suspend fun setUserData(userData: UserData) {
        context.dataStore.edit { pref ->
            pref[EMAIL_KEY] = userData.email
            pref[PASSWORD_KEY] = userData.password
        }
    }

    fun getUserData() = context.dataStore.data.map { pref ->
        return@map UserData(
            email = pref[EMAIL_KEY] ?: "",
            password = pref[PASSWORD_KEY] ?: ""
        )
    }

    suspend fun setProfileImagePath(imagePath: String) {
        context.dataStore.edit { pref ->
            pref[IMAGE_URI_KEY] = imagePath
        }
    }

    fun getProfileImagePath(): Flow<String?> {
        return context.dataStore.data.map { pref ->
            pref[IMAGE_URI_KEY]
        }
    }


    private companion object {
        val EMAIL_KEY = stringPreferencesKey("email")
        val PASSWORD_KEY = stringPreferencesKey("password")
        val IMAGE_URI_KEY = stringPreferencesKey("profile_image_path")
    }
}
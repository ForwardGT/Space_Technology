package com.example.spacetechnology.dao

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.spacetechnology.features.auth.domain.entity.UserData
import com.example.spacetechnology.features.my_posts.domain.entity.PostMyPosts
import com.example.spacetechnology.notification.SubscribeState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("data_store")

class DataStore(
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
            pref[IMAGE_URI_KEY] ?: ""
        }
    }

    suspend fun clearPhotoImagePath() {
        context.dataStore.edit { pref ->
            pref[IMAGE_URI_KEY] = ""
        }
    }

    suspend fun deleteProfile() {
        context.dataStore.edit { pref ->
            pref[EMAIL_KEY] = ""
            pref[PASSWORD_KEY] = ""
        }
    }

    suspend fun setIsLoginUser(isLogin: Boolean) {
        context.dataStore.edit { pref ->
            pref[IS_LOGIN_KEY] = isLogin
        }
    }

    fun getIsLoginUser(): Flow<Boolean> {
        return context.dataStore.data.map { pref ->
            pref[IS_LOGIN_KEY] ?: false
        }
    }

    fun getPostsForMyPosts(): Flow<List<PostMyPosts>> {
        return context.dataStore.data.map { pref ->
            val postsJson = pref[POSTS_LIST_KEY] ?: "[]"
            Json.decodeFromString(postsJson)
        }
    }

    suspend fun setPost(newPost: PostMyPosts, maxSize: Int = 5) {
        context.dataStore.edit { pref ->
            val currentPostsJson = pref[POSTS_LIST_KEY] ?: "[]"
            val currentPosts = Json.decodeFromString<List<PostMyPosts>>(currentPostsJson)
            val updatedPosts = if (currentPosts.size < maxSize) {
                currentPosts + newPost
            } else {
                currentPosts.drop(1) + newPost
            }
            pref[POSTS_LIST_KEY] = Json.encodeToString(updatedPosts)
        }
    }

    suspend fun deleteAllPosts() {
        context.dataStore.edit { pref ->
            pref[POSTS_LIST_KEY] = "[]"
        }
    }


    suspend fun setSubscribeTopic(stateSubscribe: SubscribeState) {
        context.dataStore.edit { pref ->
            pref[IS_SUBSCRIBE_NEWS_KEY] = stateSubscribe.news
            pref[IS_SUBSCRIBE_SALES_KEY] = stateSubscribe.sales
        }
    }

    fun getSubscribeTopic(): Flow<SubscribeState> {
        return context.dataStore.data.map { pref ->
            return@map SubscribeState(
                news = pref[IS_SUBSCRIBE_NEWS_KEY] ?: false,
                sales = pref[IS_SUBSCRIBE_SALES_KEY] ?: false
            )
        }
    }


    private companion object {
        val EMAIL_KEY = stringPreferencesKey("email")
        val PASSWORD_KEY = stringPreferencesKey("password")
        val IMAGE_URI_KEY = stringPreferencesKey("profile_image_path")
        val IS_LOGIN_KEY = booleanPreferencesKey("is_login")
        val POSTS_LIST_KEY = stringPreferencesKey("posts_list")
        val IS_SUBSCRIBE_NEWS_KEY = booleanPreferencesKey("is_news")
        val IS_SUBSCRIBE_SALES_KEY = booleanPreferencesKey("is_sales")
    }
}
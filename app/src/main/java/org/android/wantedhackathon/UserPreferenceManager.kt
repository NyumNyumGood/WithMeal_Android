package org.android.wantedhackathon

class UserPreferenceManager (private val sharedPreferencesManager: SharedPreferencesManager) {

    fun saveUserAccessToken(token: String?) =
        sharedPreferencesManager.putSharedPref(ACCESS_TOKEN, token)

    fun fetchUserAccessToken(): String = sharedPreferencesManager.getSharedPrefs(ACCESS_TOKEN, "")

    fun saveUserRefreshToken(token: String?) =
        sharedPreferencesManager.putSharedPref(REFRESH_TOKEN, token)

    fun fetchUserRefreshToken(): String = sharedPreferencesManager.getSharedPrefs(REFRESH_TOKEN, "")

    fun saveUserAccountId(accountId: Int?) = sharedPreferencesManager.putSharedPref(ACCOUNT_ID, accountId)

    fun fetchUserAccountId(): Int = sharedPreferencesManager.getSharedPrefs(ACCOUNT_ID, -1)

    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val ACCOUNT_ID = "account_id"
    }
}

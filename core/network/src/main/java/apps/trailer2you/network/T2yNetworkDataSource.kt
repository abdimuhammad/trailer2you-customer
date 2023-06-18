package apps.trailer2you.network

import apps.trailer2you.network.model.NetworkSignIn

interface T2yNetworkDataSource {

    suspend fun signIn(
        email: String,
        password: String,
        fcmToken: String
    ): NetworkSignIn

}
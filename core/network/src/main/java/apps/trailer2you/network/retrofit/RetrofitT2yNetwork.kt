package apps.trailer2you.network.retrofit

import apps.trailer2you.network.BuildConfig
import apps.trailer2you.network.T2yNetworkDataSource
import apps.trailer2you.network.model.NetworkSignIn
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

private const val T2yBaseUrl = BuildConfig.BASE_URL

@Singleton
class RetrofitT2yNetwork @Inject constructor(okHttpClient: OkHttpClient, private val gson: Gson) :
    T2yNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(T2yBaseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(RetrofitT2yNetworkApi::class.java)


    override suspend fun signIn(
        email: String,
        password: String,
        fcmToken: String
    ): NetworkSignIn {
        val requestMap: MutableMap<String, Any> = hashMapOf()
        requestMap["email"] = email
        requestMap["password"] = password
        requestMap["fcmDeviceToken"] = fcmToken
        return networkApi.postSignIn(body = gson.toJson(requestMap).toRequestBody()).responseData
    }
}
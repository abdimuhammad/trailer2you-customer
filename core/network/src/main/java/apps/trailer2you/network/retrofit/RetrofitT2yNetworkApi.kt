package apps.trailer2you.network.retrofit

import apps.trailer2you.network.model.NetworkSignIn
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitT2yNetworkApi {

    @POST("customer/signin")
    suspend fun postSignIn(
        @Body body: RequestBody
    ): NetworkResponse<NetworkSignIn>

}
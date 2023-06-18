package apps.trailer2you.network.retrofit

import android.content.SharedPreferences
import apps.trailer2you.common.extension.string
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkInterceptor(sharedPreferences: SharedPreferences) : Interceptor {

    private val token by sharedPreferences.string("")

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = initHeader(chain)
        val request = builder.build()
        return chain.proceed(request)
    }

    private fun initHeader(chain: Interceptor.Chain): Request.Builder {
        val request = chain.request()
        return request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .addHeader("charset", "utf-8")
            .addHeader("Cache-Control", "no-cache")
            .addHeader("Cache-Control", "no-store")
            .addHeader("authorization", "$token")
            .method(request.method, request.body)
    }

}
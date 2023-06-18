package apps.trailer2you.network.retrofit

import com.google.gson.annotations.SerializedName

data class NetworkResponse<T>(
    @SerializedName("success") var success: Boolean,
    @SerializedName("message") var message: String,
    @SerializedName("dataObj") var responseData: T
)

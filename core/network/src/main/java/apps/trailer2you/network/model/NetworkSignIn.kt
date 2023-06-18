package apps.trailer2you.network.model

import com.google.gson.annotations.SerializedName

data class NetworkSignIn(
    @SerializedName("userObj") val userObj: UserObj,
    @SerializedName("token") val token: String,
)

data class UserObj(
    @SerializedName("photo") val userPhoto: UserPhoto,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("dob") val dob: String,
    @SerializedName("mobile") val mobile: String,
    @SerializedName("address") val currentAddress: UserAddress,
    @SerializedName("recentAddress") val recentAddresses: List<UserAddress>,
    @SerializedName("driverLicense") val driverLicense: DriverLicense,
)

data class UserPhoto(
    @SerializedName("contentType") val contentType: String,
    @SerializedName("data") val url: String
)

data class UserAddress(
    @SerializedName("_id") val id: String,
    @SerializedName("streetAddress") val address: String,
    @SerializedName("location") val userLocation: UserLocation
)

data class UserLocation(
    @SerializedName("type") val type: String,
    @SerializedName("coordinates") val coordinates: List<Double>
)

data class DriverLicense(
    @SerializedName("scans") val scans: List<DriverLicenseScan>,
    @SerializedName("state") val state: String,
    @SerializedName("card") val number: String,
    @SerializedName("expiry") val expiry: String
)

data class DriverLicenseScan(
    @SerializedName("type") val type: String,
    @SerializedName("data") val url: String
)
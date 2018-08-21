package moj.memes.base.network.model

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class MemesDto(
        @Json(name = "success") val success: Boolean,
        @Json(name = "data") val data: Memes
)
@JsonSerializable
data class Memes(
        @Json(name = "memes") val memes: List<Meme>
)

@JsonSerializable
data class Meme(
        @Json(name = "id") val id: Int,
        @Json(name = "name") val name: String,
        @Json(name = "url") val imageUrl: String,
        @Json(name = "height") val imageHeight: Int,
        @Json(name = "width") val imageWidth: Int
)




@JsonSerializable
data class WheatherDto(
        @Json(name = "zip") var zip: Int?,
        @Json(name = "coord") val coord: Coordination,
        @Json(name = "weather") val weathers: List<Weather>,
        @Json(name = "base") val base: String,
        @Json(name = "main") val main: Main
)

@JsonSerializable
data class Coordination(
        @Json(name = "lon") val lon: Double,
        @Json(name = "lat") val lat: Double
)

@JsonSerializable
data class Weather(
        @Json(name = "id") val id: Int,
        @Json(name = "main") val main: String,
        @Json(name = "description") val description: String,
        @Json(name = "icon") val icon: String
)

@JsonSerializable
data class Main(
        @Json(name = "temp") val temp: Double,
        @Json(name = "pressure") val main: Int,
        @Json(name = "humidity") val humidity: Int,
        @Json(name = "temp_min") val temp_min: Int,
        @Json(name = "temp_max") val temp_max: Int
)
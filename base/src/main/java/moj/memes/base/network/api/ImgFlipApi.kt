package moj.memes.base.network.api

import io.reactivex.Single
import moj.memes.base.network.model.MemesDto
import moj.memes.base.network.model.WheatherDto
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ImgFlipApi {

    @GET("get_memes")
    fun fetchMemes(): Single<MemesDto>

    @GET("http://api.openweathermap.org/data/2.5/weather")
    fun fetchMeme(@QueryMap map: @JvmSuppressWildcards Map<String, String>): Single<WheatherDto>
}

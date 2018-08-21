package moj.memes.repository

import io.reactivex.Single
import moj.memes.base.network.api.ImgFlipApi
import moj.memes.base.network.model.WheatherDto
import javax.inject.Inject

class MemeRepositoryImpl @Inject constructor(private val api: ImgFlipApi) : MemeRepository {

    override fun fetchMeme(id: Int): Single<WheatherDto> {
        val queryMap = mapOf(
                "mode" to "json",
                "units" to "metric",
                "cnt" to "7",
                "APPID" to "15646a06818f61f7b8d7823ca833e1ce",
                "zip" to id.toString()
        )
        return api.fetchMeme(queryMap)
    }

}

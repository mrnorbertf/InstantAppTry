package moj.memes.repository

import io.reactivex.Single
import moj.memes.base.network.model.WheatherDto

interface MemeRepository {

    fun fetchMeme(id: Int): Single<WheatherDto>
}

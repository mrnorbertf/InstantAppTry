package moj.memes.domain

import moj.memes.base.domain.UseCase
import moj.memes.base.network.model.WheatherDto
import moj.memes.domain.FetchMemeUseCase.Result

interface FetchMemeUseCase : UseCase<Result> {

    sealed class Result {
        data class OnSuccess(val meme: WheatherDto) : Result()
        object OnError : Result()
    }

    fun execute(id: Int)
}

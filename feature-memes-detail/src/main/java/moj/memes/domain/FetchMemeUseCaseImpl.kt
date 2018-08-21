package moj.memes.domain

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moj.memes.base.domain.BaseUseCase
import moj.memes.base.network.model.WheatherDto
import moj.memes.domain.FetchMemeUseCase.Result
import moj.memes.repository.MemeRepository
import timber.log.Timber
import javax.inject.Inject

class FetchMemeUseCaseImpl @Inject constructor(
        private val repository: MemeRepository,
        private val mapper: Mapper
) : BaseUseCase<Result>(),
        FetchMemeUseCase {

    override fun execute(id: Int) {
        repository.fetchMeme(id)
                .map(mapper::map)
                .map {
                    it.zip = id
                    it
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::success, ::error)
                .track()
    }

    private fun success(meme: WheatherDto) {
        liveData.value = Result.OnSuccess(meme)
    }

    private fun error(throwable: Throwable) {
        Timber.e(throwable)
        liveData.value = Result.OnError
    }
}

package moj.memes.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import moj.memes.domain.FetchMemeUseCase

class DetailViewModelImpl(
        private val state: MediatorLiveData<State>,
        private val fetchMemesUseCase: FetchMemeUseCase
) : DetailViewModel() {

    init {
        state.addSource(fetchMemesUseCase.getLiveData(), ::onFetchMemesResult)
    }

    override fun onCleared() {
        fetchMemesUseCase.cleanUp()
    }

    override fun getState(): LiveData<State> = state

    override fun fetchMeme(id: Int) {
        state.value = State.ShowLoading
        fetchMemesUseCase.execute(id)
    }

    private fun onFetchMemesResult(result: FetchMemeUseCase.Result?) {
        when (result) {
            is FetchMemeUseCase.Result.OnSuccess -> {
                state.value = State.MemeLoaded(result.meme)
                state.value = State.ShowContent
            }
            is FetchMemeUseCase.Result.OnError -> state.value = State.ShowError
        }
    }
}

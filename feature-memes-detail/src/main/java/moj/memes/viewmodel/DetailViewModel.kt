package moj.memes.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import moj.memes.base.model.Meme
import moj.memes.base.network.model.WheatherDto

abstract class DetailViewModel : ViewModel() {

    sealed class State {
        data class MemeLoaded(val meme: WheatherDto) : State()
        object ShowLoading : State()
        object ShowContent : State()
        object ShowError : State()
    }

    abstract fun getState(): LiveData<State>

    abstract fun fetchMeme(id: Int)
}

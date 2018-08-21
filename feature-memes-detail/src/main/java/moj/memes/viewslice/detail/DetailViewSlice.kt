package moj.memes.viewslice.detail

import android.arch.lifecycle.LiveData
import moj.memes.base.viewslice.ViewSlice
import moj.memes.base.model.Meme
import moj.memes.base.network.model.WheatherDto

interface DetailViewSlice : ViewSlice {

    sealed class Action {
        data class MemeClicked(val meme: WheatherDto) : Action()
    }

    fun getAction(): LiveData<Action>

    fun showMeme(meme: WheatherDto)
}

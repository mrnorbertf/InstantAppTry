package moj.memes.viewslice.detail

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_demo.*
import moj.memes.base.model.Meme
import moj.memes.base.network.model.WheatherDto
import moj.memes.base.viewslice.BaseViewSlice
import moj.memes.viewslice.detail.DetailViewSlice.Action
import javax.inject.Inject

class DetailViewSliceImpl @Inject constructor(
        private val actionLiveData: MutableLiveData<Action>
) : BaseViewSlice(),
        DetailViewSlice {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
    }

//    private fun setUpRecyclerView() {
//        memes_recycler_view.layoutManager = layoutManager
//        memes_recycler_view.adapter = adapter
//    }

    override fun getAction(): LiveData<Action> = actionLiveData

    override fun showMeme(meme: WheatherDto) {
        demo_text.text = meme.toString()
//        Picasso.with(meme_image.context).load(meme.imageUrl).into(meme_image)
    }
}

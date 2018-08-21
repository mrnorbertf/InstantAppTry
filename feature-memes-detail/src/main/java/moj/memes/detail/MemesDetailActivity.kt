package moj.memes.detail

import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_demo.*
import moj.memes.base.extension.getContentView
import moj.memes.base.extension.observe
import moj.memes.base.model.EXTRA_MEME
import moj.memes.base.model.Meme
import moj.memes.base.view.BaseActivity
import moj.memes.viewslice.state.StateViewSlice
import moj.memes.viewmodel.DetailViewModel
import moj.memes.viewmodel.DetailViewModel.State
import moj.memes.viewslice.detail.DetailViewSlice
import moj.memes.viewslice.detail.DetailViewSlice.Action
import javax.inject.Inject

class MemesDetailActivity(override val layoutResourceId: Int = R.layout.activity_demo) : BaseActivity() {

    @Inject
    lateinit var viewModel: DetailViewModel
    @Inject
    lateinit var stateViewSlice: StateViewSlice
    @Inject
    lateinit var detailViewSlice: DetailViewSlice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewSlices()
        setUpViewSliceActionObservers()
        setUpViewModelStateObservers()


        val meme: Meme? = intent.extras?.getParcelable(EXTRA_MEME)
        viewModel.fetchMeme(if (meme == null) 117534 else 94043)
        getExtras()
    }

    private fun initViewSlices() {
        stateViewSlice.init(lifecycle, getContentView())
        detailViewSlice.init(lifecycle, getContentView())
    }

    private fun setUpViewSliceActionObservers() {
        observe(detailViewSlice.getAction()) { onActionChanged(it) }
    }

    private fun setUpViewModelStateObservers() {
        observe(viewModel.getState()) { onStateChanged(it) }
    }

    private fun onActionChanged(action: Action) =
    when (action) {
        is Action.MemeClicked -> Toast.makeText(this, action.meme.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun onStateChanged(state: State) = when (state) {
        is State.MemeLoaded -> detailViewSlice.showMeme(state.meme)
        State.ShowLoading -> stateViewSlice.showLoading()
        State.ShowContent -> stateViewSlice.showContent()
        State.ShowError -> stateViewSlice.showError()
    }


    private fun getExtras() {
        val meme: Meme? = intent.extras?.getParcelable(EXTRA_MEME)
        meme?.let {
            demo_text.text = it.toString()
            Picasso.with(this).load(it.imageUrl).into(meme_image)
        }
    }
}

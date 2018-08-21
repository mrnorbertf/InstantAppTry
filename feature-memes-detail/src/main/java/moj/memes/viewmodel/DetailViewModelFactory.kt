package moj.memes.viewmodel

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import moj.memes.domain.FetchMemeUseCase
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(
        private val fetchMemeUseCase: FetchMemeUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(p0: Class<T>): T {
        return DetailViewModelImpl(
                MediatorLiveData(),
                fetchMemeUseCase
        ) as T
    }
}

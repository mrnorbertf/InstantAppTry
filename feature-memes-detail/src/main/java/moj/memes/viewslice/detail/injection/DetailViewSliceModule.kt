package moj.memes.viewslice.detail.injection

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import moj.memes.base.injection.qualifiers.ForActivity
import moj.memes.base.injection.scopes.PerActivity
import moj.memes.viewslice.detail.DetailViewSlice
import moj.memes.viewslice.detail.DetailViewSlice.Action
import moj.memes.viewslice.detail.DetailViewSliceImpl

@Module
class DetailViewSliceModule {

    @Provides
    @PerActivity
    fun provideDetailViewSlice(viewSlice: DetailViewSliceImpl): DetailViewSlice = viewSlice

    @Provides
    @PerActivity
    fun provideDetailActionLiveData(): MutableLiveData<Action> = MutableLiveData()
}
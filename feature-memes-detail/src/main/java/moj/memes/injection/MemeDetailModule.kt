package moj.memes.injection

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import dagger.Module
import dagger.Provides
import moj.memes.base.injection.qualifiers.ForActivity
import moj.memes.base.injection.scopes.PerActivity
import moj.memes.detail.MemesDetailActivity
import moj.memes.domain.FetchMemeUseCase
import moj.memes.domain.FetchMemeUseCaseImpl
import moj.memes.repository.MemeRepository
import moj.memes.repository.MemeRepositoryImpl
import moj.memes.viewmodel.DetailViewModel
import moj.memes.viewmodel.DetailViewModelFactory
import moj.memes.viewslice.detail.injection.DetailViewSliceModule
import moj.memes.viewslice.state.injection.StateViewSliceModule

@Module(includes = [
    MemeDetailModule.Repository::class,
    MemeDetailModule.UseCase::class,
    MemeDetailModule.ViewModel::class,
    MemeDetailModule.View::class,
    DetailViewSliceModule::class,
    StateViewSliceModule::class
])
class MemeDetailModule {

    @Module
    class Repository {
        @Provides
        @PerActivity
        fun provideMemeRepository(repository: MemeRepositoryImpl): MemeRepository = repository
    }

    @Module
    class UseCase {
        @Provides
        @PerActivity
        fun provideFetchMemesUseCase(useCase: FetchMemeUseCaseImpl): FetchMemeUseCase = useCase
    }

    @Module
    class ViewModel {
        @Provides
        @PerActivity
        fun provideListViewModel(activity: MemesDetailActivity, factory: DetailViewModelFactory): DetailViewModel =
                ViewModelProviders.of(activity, factory).get(DetailViewModel::class.java)
    }

    @Module
    class View {
        @Provides
        @PerActivity
        @ForActivity
        fun provideContext(activity: MemesDetailActivity): Context = activity
    }
}

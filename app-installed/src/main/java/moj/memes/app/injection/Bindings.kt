package moj.memes.app.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import moj.memes.base.injection.scopes.PerActivity
import moj.memes.detail.MemesDetailActivity
import moj.memes.injection.MemeDetailModule
import moj.memes.list.injection.MemesListModule
import moj.memes.list.view.MemesListActivity

@Module
abstract class Bindings {

    @PerActivity
    @ContributesAndroidInjector(modules = [MemesListModule::class])
    abstract fun bindMemesListActivity(): MemesListActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [MemeDetailModule::class])
    abstract fun bindMemesDetailActivity(): MemesDetailActivity
}

package id.android.anvil.home.module

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import id.android.anvil.core.scope.ApplicationScope
import id.android.anvil.home.data.HomeDatasource
import id.android.anvil.home.data.HomeFactory
import id.android.anvil.home.domain.HomeRepository
import id.android.anvil.home.domain.HomeRepositoryImpl
import id.android.anvil.home.domain.HomeUsecase
import id.android.anvil.home.presentation.HomeViewModel
import retrofit2.Retrofit
import id.android.anvil.core.qualifier.ViewModel as ViewModels

@Module
@ContributesTo(ApplicationScope::class)
abstract class HomeModule {

  companion object {

    @Provides
    fun providesHomeDatasource(retrofit: Retrofit): HomeDatasource =
      retrofit.create(HomeDatasource::class.java)

    @Provides
    fun providesHomeFactory(datasource: HomeDatasource): HomeFactory =
      HomeFactory(datasource)

    @Provides
    fun providesHomeRepository(factory: HomeFactory): HomeRepositoryImpl =
      HomeRepositoryImpl(factory)

    @Provides
    fun providesHomeUsecase(repository: HomeRepository): HomeUsecase =
      HomeUsecase(repository)
  }

  @Binds
  abstract fun bindHomeRepository(repository: HomeRepositoryImpl): HomeRepository

  @Binds
  @IntoMap
  @ViewModels(HomeViewModel::class)
  abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}
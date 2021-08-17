package id.android.anvil.core.module

import androidx.lifecycle.ViewModelProvider
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import id.android.anvil.core.factory.ViewModelFactory
import id.android.anvil.core.scope.ApplicationScope

@Module
@ContributesTo(ApplicationScope::class)
abstract class ApplicationModule {

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
package id.android.anvil.core.module

import androidx.lifecycle.ViewModelProvider
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import id.android.anvil.core.scope.ApplicationScope

@Suppress("Unused")
@Module
@ContributesTo(ApplicationScope::class)
abstract class ApplicationModule {

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
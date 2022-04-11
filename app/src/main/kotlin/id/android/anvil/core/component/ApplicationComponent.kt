package id.android.anvil.core.component

import android.app.Application
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import id.android.anvil.core.scope.ApplicationScope
import id.android.anvil.core.scope.SingleIn
import id.android.anvil.detail.presentation.DetailActivity
import id.android.anvil.home.presentation.HomeActivity

@SingleIn(ApplicationScope::class)
@MergeComponent(ApplicationScope::class)
interface ApplicationComponent {

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: Application): Builder

    fun build(): ApplicationComponent
  }

  fun inject(activity: HomeActivity)
  fun inject(activity: DetailActivity)
}
package id.android.anvil

import android.app.Application
import id.android.anvil.core.component.ApplicationComponent
import id.android.anvil.core.component.DaggerApplicationComponent

class App : Application() {

  companion object {
    lateinit var component: ApplicationComponent
      private set
  }

  override fun onCreate() {
    component = DaggerApplicationComponent.builder().application(this).build()
    super.onCreate()
  }
}
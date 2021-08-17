package id.android.anvil.core.qualifier

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FUNCTION
import kotlin.reflect.KClass

@Target(
  CLASS,
  FUNCTION
)
@Retention(RUNTIME)
@MapKey
annotation class ViewModel(val value: KClass<out ViewModel>)
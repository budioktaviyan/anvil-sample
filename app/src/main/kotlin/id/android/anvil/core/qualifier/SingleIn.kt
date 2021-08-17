package id.android.anvil.core.qualifier

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.reflect.KClass

@Retention(RUNTIME)
@Scope
annotation class SingleIn(val value: KClass<*>)
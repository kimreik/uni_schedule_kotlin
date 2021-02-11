package schedule.model

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class InitOnceProperty<T>(private val setCallback: (() -> Unit)?) : ReadWriteProperty<Any, T> {

    private object EMPTY

    private var value: Any? = EMPTY

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        if (value == EMPTY) {
            throw IllegalStateException("Value isn't initialized")
        } else {
            return value as T
        }
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        if (this.value != EMPTY) {
            throw IllegalStateException("Value already initialized")
        }
        this.value = value
        setCallback?.invoke()
    }
}

inline fun <reified T> initOnce(noinline setCallback: (() -> Unit)? = null): ReadWriteProperty<Any, T> =
    InitOnceProperty(setCallback)

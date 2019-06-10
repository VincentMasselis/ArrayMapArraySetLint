@file:Suppress("NOTHING_TO_INLINE")

package com.vincentmasselis.arraymaparrayset

import androidx.collection.ArrayMap
import androidx.collection.ArraySet

fun <K, V> Map<out K, V>.toArrayMap() = ArrayMap<K, V>(size).also { it.putAll(this) }

fun <T> Iterable<T>.toArraySet() = when (this) {
    is Collection<T> -> ArraySet(this)
    else -> ArraySet<T>().apply { addAll(this) }
}
package com.blueiobase.app.android.shopper.data.map.base

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * This class transforms JSON strings into the correct Object Type.
 *
 * [T] : The type to be created from the JSON [String].
 * @author IO DevBlue
 * @since 1.0.0
 */
class JsonMapper<T> {

    private val gson = Gson()

    /**
     * Transforms the [jsonString] into its correct type [T]
     * @param jsonString The JSON [String] to be parsed.
     * @return The type inferred from the context
     */
    fun map(jsonString: String): T {
        val type = object : TypeToken<T>() {}.type
        return gson.fromJson(jsonString, type)
    }

}
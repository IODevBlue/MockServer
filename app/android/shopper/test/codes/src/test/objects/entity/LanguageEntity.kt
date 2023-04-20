package com.blueiobase.app.android.shopper.data.entity

import com.google.gson.annotations.SerializedName

/**
 * This class represents a language in the data layer.
 * @author IO DevBlue
 * @since 1.0.0
 */
data class LanguageEntity(
    /** Short code for the country name. */
    @SerializedName("value")
    var countryCodeISO: String,
    /** The name of this language. */
    var name: String)
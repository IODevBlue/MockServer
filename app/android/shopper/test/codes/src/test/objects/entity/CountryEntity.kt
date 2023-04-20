package com.blueiobase.app.android.shopper.data.entity

import com.google.gson.annotations.SerializedName

/**
 * This class represents a Country in the data layer.
 * @author IO DevBlue
 * @since 1.0.0
 */
data class CountryEntity(
    /** Full name of the country. */
    var name: String) {

    /** Phone code for this country. */
    @SerializedName("dial_code")
    var phoneCode = ""
    /** Short code for the country name. */
    @SerializedName("code")
    var countryCodeISO = ""
        set(value) {
            field = value.lowercase()
        }

    override fun toString(): String {
        return "Country(name=$name, phoneCode=$phoneCode, countryCode=$countryCodeISO )"

    }
}
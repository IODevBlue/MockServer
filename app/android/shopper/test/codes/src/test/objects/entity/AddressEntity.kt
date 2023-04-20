package com.blueiobase.app.android.shopper.data.entity

/**
 * This class represents an address in the data layer to describe and register locations.
 *
 * @author IO DevBlue
 * @since 1.0.0
 */
data class AddressEntity(
    /** Street number of this address.*/
    var streetNumber: Int,
    /** Street name of this address.*/
    var streetName: String,
    /** City where this address is located.*/
    var city: String ) {

    /** A optional identifier set by the User to identify this particular address.*/
    var addressIdentifier = ""

    /** State where this address is located.*/
    var state = ""

    /** Country where this address is located.*/
    var country = ""

    /** Postal code of this address.*/
    var postalCode = ""

    /** Zip code of this address.*/
    var zip = 0

    /** Addition Information to provide more context on the address.*/
    var additionInformation = ""

    override fun toString() = "No. $streetNumber, $streetName, $city"
}
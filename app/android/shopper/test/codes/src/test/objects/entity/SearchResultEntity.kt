package com.blueiobase.app.android.shopper.data.entity

import com.blueiobase.app.android.shopper.data.enums.EntityType

/**
 * This represents an individual search result queried by the user.
 * @author IO DevBlue
 * @since 1.0.0
 */
data class SearchResultEntity (
    /** The main title of this [SearchResultEntity]. */
    val title: String) {

    /** The auxiliary text accompanying this [SearchResultEntity]. */
    var subtitle: String = ""
    /** The picture associated with this [SearchResultEntity]. */
    var picture: String = ""
    /** The type of data entity this search result is. */
    var entityType: EntityType? = null
}
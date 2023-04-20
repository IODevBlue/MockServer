package com.blueiobase.app.android.shopper.data.entity


/**
 * This class holds a list of [SearchResultEntity] that correspond to the [searchParameter].
 * @author IO DevBlue
 * @since 1.0.0
 */
data class SearchResultListEntity(
    /** The search parameter used to structure the results stored in the [searchList]. */
    val searchParameter: String) {

    /** The list of search results. */
    val searchList = arrayListOf<SearchResultEntity>()

}
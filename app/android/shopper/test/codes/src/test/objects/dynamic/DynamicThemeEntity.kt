package com.blueiobase.app.android.shopper.data.entity.dynamic

import com.blueiobase.app.android.shopper.data.enums.ThemeType

/**
 * Class representing a remote theme used to theme the client application.
 * @author IO DevBlue
 * @since 1.0.0
 */
data class DynamicThemeEntity(
    /** The ID of this theme. Every remote theme has an ID. */
    val id: Int,
    /** The name of this theme. Every remote theme has a name. */
    val themeName: String
) {
    /** The type of theme. Light or Dark. */
    var themeType: ThemeType? = null
    /** The brand color for the application. */
    var primaryColor = -1
    /** The icon color for this theme. */
    var iconColor = -1
    /** Primary text color for this theme. */
    var textColor = -1
    /** The secondary text color for this theme. */
    var secondaryTextColor = -1
    /** The tertiary text color for this theme. */
    var tertiaryTextColor = -1
    /** The status bar background color. */
    var statusBarColor = -1
    /** The search bar widget background color if any is present. */
    var searchBarColor = -1
}
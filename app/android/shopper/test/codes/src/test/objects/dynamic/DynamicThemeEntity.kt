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
    var primaryColor = ""
    /** The icon color for this theme. */
    var iconColor = ""
    /** Primary text color for this theme. */
    var textColor = ""
    /** The secondary text color for this theme. */
    var secondaryTextColor = ""
    /** The tertiary text color for this theme. */
    var tertiaryTextColor = ""
    /** The status bar background color. */
    var statusBarColor = ""
    /** The search bar widget background color if any is present. */
    var searchBarColor = ""
}
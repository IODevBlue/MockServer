package com.blueiobase.app.android.shopper.ui.activity.main.dynamic

/**
 * This class represents dynamic content added to the left navigation drawer for the [MainActivity].
 *
 * This is useful in scenarios where there is a need to redirect to content (e.g promotional content, news flash etc)
 * on the web.
 * @author IO DevBlue
 * @since 1.0.0
 */
data class DynamicLeftDrawerItem(
    /** Every dynamic content **must** redirect to an external webpage. */
    val redirectUrl: String,
    /** Every dynamic menu item must have a title. */
    val title: String,
    /** The Url for the icon to be displayed at the left hand side of the [title]. */
    val leftIconImageUrl: String = "",
    /** The Url for the icon to be displayed at the right hand side of the [title]. */
    val rightIconImageUrl: String = "")
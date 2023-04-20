package com.blueiobase.app.android.shopper.data.entity

import com.blueiobase.app.android.shopper.data.entity.base.BaseUserEntity

/**
 * This class represents a buyer in the data layer.
 * @author IO DevBlue
 * @since 1.0.0
 */
data class BuyerEntity(
    /** First name for this buyer.*/
    override val firstName: String,
    /** Last name for this buyer.*/
    override val lastName: String): BaseUserEntity(firstName, lastName) {

    private constructor(): this("", "") //For Gson serializer.

    override var userType = UserType.Buyer

    /** The total amount this buyer has spent on buying goods. */
    var totalSpending = 0

    /** The total amount of products this buyer has bought so far. */
    var totalPurchases = 0

    override fun toString() = super.toString() +
            "Total Spending: $totalSpending" +
            "Total Purchases: $totalPurchases"
}
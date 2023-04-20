package com.blueiobase.app.android.shopper.data.entity.base

import com.blueiobase.app.android.shopper.data.entity.AddressEntity
import com.blueiobase.app.android.shopper.data.entity.CountryEntity
import com.blueiobase.app.android.shopper.data.entity.LanguageEntity
import java.net.InetAddress
import java.util.*


/**
 * The base class for all users in the data layer.
 *
 * Every registered user must have a mandatory first and last name.
 *
 * @author IO DevBlue
 * @since 1.0.0
 */
abstract class BaseUserEntity(
    /** First name for this user.*/
    @Transient open val firstName: String,
    /** Last name for this user.*/
    @Transient open val lastName: String) {

    /** Class representing a user's gender. */
    enum class Gender { MALE, FEMALE, UNSPECIFIED }
    /** Class representing a user's online status. */
    enum class OnlineStatus { ONLINE, OFFLINE, BUSY }
    /** Class representing the type of user using the app. */
    enum class UserType { Buyer, Seller, Anonymous }

    /** Unique ID of this user. */
    var id = ""

    //********** BIOGRAPHY **********//
    /** Optional nickname for a user. */
    open var nickName = ""

    /** Email address for this user.*/
    open var email = ""

    /** Gender of this user. The default is unspecified. */
    open var gender = Gender.UNSPECIFIED

    /** Main telephone line for this user. */
    open var telephoneLine = 0L

    /** Auxiliary telephone line for this user. */
    open var telephoneLine2 = 0L

    /** Country of origin for this user. */
    open var country: CountryEntity? = null

    /** Optional information provided by the user. */
    open var biography = ""

    /** The home address of this user. */
    open var homeAddress: AddressEntity? = null

    /** Profile image Uri in [String] format for this user. */
    open var profileImage = ""

    /**
     * Cached version of the [profile image][profileImage].
     *
     * This might not be needed if a 3rd party image loader eg Fresco, Glide, Picasso is used, however it
     * might come in handy in cases where there is no internet connection.
     */
    open var cachedProfileImage = ""

    /**
     * The overall rating for this user.
     *
     * NOTE: By default the value of the rating should in the range 0.0 to 10.0.
     */
    open var rating = 0.0
        set(value) {
            require(value in 0.0..10.0){"Expected rating should be between 0 and 10"}
            field = value
        }

    /** The type of user this is. */
    @Transient open var userType = UserType.Anonymous

    /** The IP Address of this user. Use this variable with caution. */
    open var ipAddress: InetAddress? = null

    /** Common addresses saved by this user. */
    open val savedAddresses = arrayListOf<AddressEntity>()

    /** Languages this user can converse in. */
    open val languages = arrayListOf<LanguageEntity>()

    /** A list of reviews about this user from other users. */
    open val reviews = arrayListOf<Pair<BaseUserEntity, String>>()



    //********** FINANCE **********//
    /** Current account balance for this user. */
    open var balance = 0



    //********** CHAT **********//
    /** Online availability of this user. */
    open var onlineStatus = OnlineStatus.OFFLINE

    /** The last [time][Date.getTime] the user appeared online. */
    open var lastSeen = 0L



    //********** SALES **********//
    /** The last [time][Date.getTime] a was delivery made or received by this user. */
    open var lastDelivery = 0L

    /** The number of active orders this user has not completed. */
    open var activeOrders = 0

    /** The number of cancelled orders this user has made. */
    open var cancelledOrders = 0

    /** The number of completed orders this user has made. */
    open var completedOrders = 0


    override fun toString() =
        "Name: $firstName $lastName, Nickname: $nickName ||" +
                "Phone Numbers: $telephoneLine, $telephoneLine2 ||" +
                "Gender: $gender" +
                "Country: $country" +
                "User Type: $userType" +
                "Biography: $biography" +
                "Available Balance: $balance" +
                "Email: $email ||" +
                "Home Address: ${if(homeAddress == null) "None" else homeAddress?.toString()}" +
                "Rating: $rating" +
                "IP Address: $ipAddress" +
                "Online Status: $onlineStatus" +
                "Last Seen: $lastSeen" +
                "Last Delivery: $lastDelivery" +
                "Active Orders: $activeOrders" +
                "Completed Orders: $completedOrders"

}
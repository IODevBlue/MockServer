package test.objects

import java.io.FileOutputStream
import java.io.FileInputStream
import com.google.gson.Gson
import java.io.File
import com.blueiobase.app.android.shopper.data.entity.BuyerEntity
import com.blueiobase.app.android.shopper.data.entity.base.BaseUserEntity
import com.blueiobase.app.android.shopper.data.repository.CountryRepository
import com.blueiobase.app.android.shopper.data.entity.AddressEntity
import com.blueiobase.app.android.shopper.data.repository.LanguageRepository
import com.blueiobase.app.android.shopper.data.entity.SearchResultListEntity
import com.blueiobase.app.android.shopper.data.entity.SearchResultEntity
import com.blueiobase.app.android.shopper.data.enums.EntityType
import com.blueiobase.app.android.shopper.data.enums.ThemeType
import com.blueiobase.app.android.shopper.ui.activity.main.dynamic.DynamicLeftDrawerItem
import com.blueiobase.app.android.shopper.data.entity.dynamic.DynamicThemeEntity

class ShopperExec {
	
	private val gson = Gson()
	private val countryRepo = CountryRepository()
	private val langRepo = LanguageRepository()
	private val path = "C:\\Github_Projects\\MockServer\\app\\android\\shopper\\test"
	
	private var jsonPath = "$path\\%s.json"
	private var dynamicPath = "$path\\dynamic\\%s.json"
	
	private var repo = "https://github.com/IODevBlue/MockServer/raw/main/app/android/shopper/test"
	private val imagePath = "https://raw.githubusercontent.com/IODevBlue/MockServer/main/app/android/shopper/test/images/%s.jpg"
  private val productEntity = EntityType.PRODUCT     
	
	/**
	 * Add a 15% alpha to the searchBarColor in the implementing client app.
	 * The searchBarColor is always 85% lighter than the statusBarColor.
	 */
	fun createDynamicThemePair() {
		val file = File(String.format(dynamicPath, "TestDynamicThemePair"))
		if(!file.exists()) file.createNewFile()
		else {
			file.apply {
				delete()
				createNewFile()
			}
		}
		val themePair = DynamicThemeEntity(1000, "TestDynamicThemePair: Light").apply {
			themeType = ThemeType.LIGHT
			primaryColor = "#C5E1A5" 
			iconColor = "#5E35B1"
			textColor = "#0091EA"
			secondaryTextColor = "#5E35B1"
			tertiaryTextColor =  "#AAAAAA"
			statusBarColor = "#0091EA"
			searchBarColor = "#0091EA"
		} to DynamicThemeEntity(2000, "TestDynamicThemePair: Dark").apply {
			themeType = ThemeType.DARK
			primaryColor = "#37474F"
			iconColor = "#FFA7A6"
			textColor = "#FFF8E1"
			secondaryTextColor = "#FFA7A6"
			tertiaryTextColor = "#AAAAAA"
			statusBarColor = "#FFA7A6"
			searchBarColor = "#FFA7A6"
		}
		
		FileOutputStream(file).use {
			val s = gson.toJson(themePair).toByteArray()
			it.write(s)
		}
		FileInputStream(file).use {
			val b = it.readAllBytes()
			val sb = StringBuilder()
			for(i in 0 until b.size) {
				sb.append(b[i].toInt().toChar())
			}
			val s = sb.toString()
			val list = gson.fromJson(s, Pair::class.java)
			list.toList().forEach {
				println(it)
			}
		}		
	}
	
	fun createDynamicMainItems() {
		val file = File(String.format(dynamicPath, "TestDynamicMainActivityDrawerItems"))
		if(!file.exists()) file.createNewFile()
		else {
			file.apply {
				delete()
				createNewFile()
			}
		}
		
		val arr = arrayListOf ( DynamicLeftDrawerItem(
			"https://github.com/IODevBlue",
			"Check out my Github!", "https://avatars.githubusercontent.com/u/95544678?v=4",
			"https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png")
		)
		FileOutputStream(file).use {
			val s = gson.toJson(arr).toByteArray()
			it.write(s)
		}
		FileInputStream(file).use {
			val b = it.readAllBytes()
			val sb = StringBuilder()
			for(i in 0 until b.size) {
				sb.append(b[i].toInt().toChar())
			}
			val s = sb.toString()
			val list = gson.fromJson(s, ArrayList::class.java)
			list.forEach {
				println(it)
			}
		}		
	}
	   
	fun createRecentlyViewedHistory() {
		val file = File(String.format(jsonPath, "TestRecentlyViewedHistory"));
		if(!file.exists()) file.createNewFile()
		else {
			file.apply {
				delete()
				createNewFile()
			}
		}
		val srle = SearchResultListEntity("TestRecentlyViewedHistory")
		val repoImages = "$repo/images"
		srle.searchList.addAll(arrayListOf(
			SearchResultEntity("Air conditioner").apply{
				subtitle="State of the art 21st century product"
				picture = "$repoImages/air_conditioner.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Body lotion").apply{
				subtitle="Deeply moisturizes and hydrates the skin."
				picture = "$repoImages/body_lotion.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Chess board").apply{
				subtitle="Play the game of Chess!"
				picture = "$repoImages/chess_board.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Dr Strange movie").apply{
				subtitle="Watch Dr. Strange and the Avengers do battle."
				picture = "$repoImages/dr_strange.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Electric machine").apply{
				subtitle="Machine for Electric fun stuff."
				picture = "$repoImages/electric_machine.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Fan").apply{
				subtitle="Fan yourself with this tool!."
				picture = "$repoImages/fan.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Gold chains").apply{
				subtitle="Chains on your wrist."
				picture = "$repoImages/gold_chains.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Hair Straightner").apply{
				subtitle="Electric hair styler for you."
				picture = "$repoImages/hair_straightner.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Ice cream machine").apply{
				subtitle="Ice cream, Vanilla. Make them all!!!"
				picture = "$repoImages/ice_cream_machine.jpg"
				entityType = EntityType.PRODUCT
			},
			SearchResultEntity("Jojo bizarre adventure").apply{
				subtitle="Yare Yare Daze."
				picture = "$repoImages/jojo.jpg"
				entityType = EntityType.PRODUCT
			}
		))
		
		FileOutputStream(file).use {
			val s = gson.toJson(srle).toByteArray()
			it.write(s)
		}
		
		FileInputStream(file).use {
			val b = it.readAllBytes()
			val sb = StringBuilder()
			for(i in 0 until b.size) {
				sb.append(b[i].toInt().toChar())
			}
			val s = sb.toString()
			val fsrle = gson.fromJson(s, SearchResultListEntity::class.java)
			println(fsrle)
		}
	}
	
	fun createSearchResultList() {
		val file = File(String.format(jsonPath, "TestSearchResultList"))
		if(!file.exists()) file.createNewFile()
		else {
			file.apply {
				delete()
				createNewFile()
			}
		}
		
		val srle = SearchResultListEntity("TestSearchResultList")
		srle.searchList.addAll(arrayListOf(
			SearchResultEntity("Air conditioner").apply{subtitle="State of the art 21st century product"; picture=String.format(imagePath, "air_conditioner"); entityType=productEntity},
			SearchResultEntity("Body lotion").apply{subtitle="Deeply moisturizes and hydrates the skin."; picture=String.format(imagePath, "body_lotion"); entityType=productEntity},
			SearchResultEntity("Chess board").apply{subtitle="Play the game of Chess!"; picture=String.format(imagePath, "chess_board");  entityType=productEntity},
			SearchResultEntity("Dr Strange movie").apply{subtitle="Watch Dr. Strange and the Avengers do battle."; picture=String.format(imagePath, "dr_strange"); entityType=productEntity},
			SearchResultEntity("Electric machine").apply{subtitle="Machine for Electric fun stuff."; picture=String.format(imagePath, "electric_machine"); entityType=productEntity},
			SearchResultEntity("Fan").apply{subtitle="Fan yourself with this tool!."; picture=String.format(imagePath, "fan");  entityType=productEntity},
			SearchResultEntity("Gold chains").apply{subtitle="Chains on your wrist."; picture=String.format(imagePath, "gold_chains");  entityType=productEntity},
			SearchResultEntity("Hair Straightner").apply{subtitle="Electric hair styler for you."; picture=String.format(imagePath, "hair_straightner"); entityType=productEntity},
			SearchResultEntity("Ice cream machine").apply{subtitle="Ice cream, Vanilla. Make them all!!!"; picture=String.format(imagePath, "ice_cream_machine"); entityType=productEntity},
			SearchResultEntity("Jojo bizarre adventure").apply{subtitle="Yare Yare Daze."; picture=String.format(imagePath, "jojo"); entityType=productEntity},
			SearchResultEntity("Killer bee action figure").apply{subtitle="WHHEEEEEEEEEE!!!!"; picture=String.format(imagePath, "killer_bee"); entityType=productEntity},
			SearchResultEntity("Lotus flowers").apply{subtitle="Flowers to change your mood."; picture=String.format(imagePath, "lotus"); entityType=productEntity},
			SearchResultEntity("Manchester united jersey").apply{subtitle="The Red Devils"; picture=String.format(imagePath, "manu"); entityType=productEntity},
			SearchResultEntity("Nerd glasses").apply{subtitle="Wanna look like you know scientific stuff?"; picture=String.format(imagePath, "nerd_glass"); entityType=productEntity},
			SearchResultEntity("Ovaltine").apply{subtitle="Healthy. Milky. Tea. For you."; picture=String.format(imagePath, "ovaltine"); entityType=productEntity},
			SearchResultEntity("Pet food").apply{subtitle="For Healthy pets to make them strong"; picture=String.format(imagePath, "pet_food"); entityType=productEntity},
			SearchResultEntity("Queen rose fragrance").apply{subtitle="Eau De Parfum"; picture=String.format(imagePath, "queen_rose"); entityType=productEntity},
			SearchResultEntity("Rat terminator").apply{subtitle="Rodent stopper. Pump action."; picture=String.format(imagePath, "rat"); entityType=productEntity},
			SearchResultEntity("Sakura").apply{subtitle="Chaaaaaaannaaaaarroooo"; picture=String.format(imagePath, "sakura"); entityType=productEntity},
			SearchResultEntity("Turn tables").apply{subtitle="Spin the wheel. Get the feel."; picture=String.format(imagePath, "turn_table"); entityType=productEntity},
			SearchResultEntity("USB cables").apply{subtitle="Trustworthy for your devices."; picture=String.format(imagePath, "usb"); entityType=productEntity},
			SearchResultEntity("Vitalis roll-on").apply{subtitle="Fragranced Deodorant."; picture=String.format(imagePath, "vitalis"); entityType=productEntity},
			SearchResultEntity("Xray chart").apply{subtitle="Study the human anatomy."; picture=String.format(imagePath, "xray"); entityType=productEntity},
			SearchResultEntity("Yoyo toy").apply{subtitle="Bounce. Bounce. Bounce."; picture=String.format(imagePath, "yoyo"); entityType=productEntity},
			SearchResultEntity("Zebra costume").apply{subtitle="Unlock your inner Zebra chi with this costume."; picture=String.format(imagePath, "zebra"); entityType=productEntity}
		))
		FileOutputStream(file).use {
			val s = gson.toJson(srle).toByteArray()
			it.write(s)
		}
		
		FileInputStream(file).use {
			val b = it.readAllBytes()
			val sb = StringBuilder()
			for(i in 0 until b.size) {
				sb.append(b[i].toInt().toChar())
			}
			val s = sb.toString()
			val fsrle = gson.fromJson(s, SearchResultListEntity::class.java)
			println(fsrle)
		}
	}
	
	fun createHistory() {
		val file = File(String.format(jsonPath, "TestSearchHistory"));
		if(!file.exists()) file.createNewFile()
		else {
			file.apply {
				delete()
				createNewFile()
			}
		}
		val searchHistory = arrayListOf<String>(
			"Air conditioner", "Body lotion", "Chess board", "Dr Strange movie", "Electric machine",
			"Fan", "Gold chains", "Hair Straightner", "Ice cream machine", "Jojo bizarre adventure",
			"Killer bee action figure", "Lotus flowers", "Manchester united jersey", "Nerd glasses",
			"Ovaltine", "Pet food", "Queen rose fragrance", "Rat terminator", "Sakura", "Turn tables",
			"USB cables", "Vitalis roll-on", "Xray chart", "Yoyo toy", "Zebra costume"
		)
		FileOutputStream(file).use {
			val s = gson.toJson(searchHistory).toByteArray()
			it.write(s)
		}
		FileInputStream(file).use {
			val b = it.readAllBytes()
			val sb = StringBuilder()
			for(i in 0 until b.size) {
				sb.append(b[i].toInt().toChar())
			}
			val s = sb.toString()
			val list = gson.fromJson(s, ArrayList::class.java)
			list.forEach {
				println(it)
			}
		}		
	}
	
	fun createBuyerEntity() {
		val file = File(String.format(jsonPath, "TestBaseUserEntity"));
		if(!file.exists()) file.createNewFile()
		else {
			file.apply {
				delete()
				createNewFile()
			}
		}
		val buyer = BuyerEntity("IO", "DevBlue")
		buyer.apply {
			totalSpending = 5000
			totalPurchases = 35
			id = "2023iode11vb1u3e"
			nickName = "Blue"
			email = "iodevblue@gmail.com"
			gender = BaseUserEntity.Gender.MALE
			telephoneLine = 8123456789
			telephoneLine2 = 8098765432
			country = countryRepo.retrieve("Nigeria")
			biography = "Native Android Developer || Kotlin programmer || Open Source Enthusiast."
			homeAddress = AddressEntity(2023, "Programmers Lane", "Kotlin City").apply{
				state = "Lagos State"
				country = "Nigeria"
				postalCode = "12345098"
				zip = 99999
			}
			profileImage = "https://avatars.githubusercontent.com/u/95544678?v=4"
			rating = 8.5
			languages.add(langRepo.retrieve("English")!!)
			balance = 10000
			lastSeen = System.currentTimeMillis()
			lastDelivery = System.currentTimeMillis()
			activeOrders = 3
			cancelledOrders = 1
			completedOrders = 15
		}
		
		FileOutputStream(file).use {
			val s = gson.toJson(buyer).toByteArray()
			it.write(s)
		}
		
		FileInputStream(file).use {
			val b = it.readAllBytes()
			val sb = StringBuilder()
			for(i in 0 until b.size) {
				sb.append(b[i].toInt().toChar())
			}
			val s = sb.toString()
			val buyer = gson.fromJson(s, BuyerEntity::class.java)
			println(buyer)
		}		
		
	}
}
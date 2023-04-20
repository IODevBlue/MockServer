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
import com.blueiobase.app.android.shopper.ui.activity.main.dynamic.DynamicLeftDrawerItem

class ShopperExec {
	
	private val gson = Gson()
	private val countryRepo = CountryRepository()
	private val langRepo = LanguageRepository()
	private val path = "C:\\Github_Projects\\MockServer\\app\\android\\shopper\\test"
	
	private var jsonPath = "$path\\%s.json"
	private var dynamicPath = "$path\\dynamic\\%s.json"
	
	private var repo = "https://github.com/IODevBlue/MockServer/raw/main/app/android/shopper/test"
    
       
	fun createDynamicMainItems() {
		val file = File(String.format(dynamicPath, "DynamicMainActivityDrawerItems"))
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
			SearchResultEntity("Air conditioner").apply{subtitle="State of the art 21st century product"},
			SearchResultEntity("Body lotion").apply{subtitle="Deeply moisturizes and hydrates the skin."},
			SearchResultEntity("Chess board").apply{subtitle="Play the game of Chess!"},
			SearchResultEntity("Dr Strange movie").apply{subtitle="Watch Dr. Strange and the Avengers do battle."},
			SearchResultEntity("Electric machine").apply{subtitle="Machine for Electric fun stuff."},
			SearchResultEntity("Fan").apply{subtitle="Fan yourself with this tool!."},
			SearchResultEntity("Gold chains").apply{subtitle="Chains on your wrist."},
			SearchResultEntity("Hair Straightner").apply{subtitle="Electric hair styler for you."},
			SearchResultEntity("Ice cream machine").apply{subtitle="Ice cream, Vanilla. Make them all!!!"},
			SearchResultEntity("Jojo bizarre adventure").apply{subtitle="Yare Yare Daze."},
			SearchResultEntity("Killer bee action figure").apply{subtitle="WHHEEEEEEEEEE!!!!"},
			SearchResultEntity("Lotus flowers").apply{subtitle="Flowers to change your mood."},
			SearchResultEntity("Manchester united jersey").apply{subtitle="The Red Devils"},
			SearchResultEntity("Nerd glasses").apply{subtitle="Wanna look like you know scientific stuff?"},
			SearchResultEntity("Ovaltine").apply{subtitle="Healthy. Milky. Tea. For you."},
			SearchResultEntity("Pet food").apply{subtitle="For Healthy pets to make them strong"},
			SearchResultEntity("Queen rose fragrance").apply{subtitle="Eau De Parfum"},
			SearchResultEntity("Rat terminator").apply{subtitle="Rodent stopper. Pump action."},
			SearchResultEntity("Sakura").apply{subtitle="Chaaaaaaannaaaaarroooo"},
			SearchResultEntity("Turn tables").apply{subtitle="Spin the wheel. Get the feel."},
			SearchResultEntity("USB cables").apply{subtitle="Trustworthy for your devices."},
			SearchResultEntity("Vitalis roll-on").apply{subtitle="Fragranced Deodorant."},
			SearchResultEntity("Xray chart").apply{subtitle="Study the human anatomy."},
			SearchResultEntity("Yoyo toy").apply{subtitle="Bounce. Bounce. Bounce."},
			SearchResultEntity("Zebra costume").apply{subtitle="Unlock your inner Zebra chi with this costume."}
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
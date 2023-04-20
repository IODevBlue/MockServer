package com.blueiobase.app.android.shopper.data.repository

import com.blueiobase.app.android.shopper.data.entity.LanguageEntity
import com.google.gson.annotations.SerializedName
import java.io.File
import java.io.FileInputStream
import com.google.gson.Gson
import com.blueiobase.app.android.shopper.data.map.base.JsonMapper

/**
 * This class is the implementation of the [ILanguageRepository].
 *
 * Its primary usage is to retrieve [LanguageEntity] data from the static JSON file in the res/raw/.
 *
 * **NOTE:** This repository can only perform retrieval operations. All persist operations are **NOT** supported
 * as client side is not required to save language data.
 * @author IO DevBlue
 * @since 1.0.0
 */
class LanguageRepository {

    @SerializedName("language_options")
    var listOfLanguages = arrayListOf<LanguageEntity>()

    init {
    	val file = File("C:\\Users\\Eugene\\Eclipse-JavaSE-Workspace\\MyKotlinSandBox\\languages_list.json");

       FileInputStream(file).use {
           val b = it.readAllBytes()
           val sb = StringBuilder()
           for(i in 0 until b.size) {
          	 sb.append(b[i].toInt().toChar())
           }
		   val s = sb.toString()
       val x = Gson().fromJson(s, Languages::class.java)
//		   		 val x = JsonMapper<LanguageRepository>().map(sb.toString())
		   			 listOfLanguages = x.options
       }
    }
	
    fun retrieve(name: String): LanguageEntity? { //Working
        var lang: LanguageEntity? = null
    		listOfLanguages.forEach {
            if(it.name == name || it.countryCodeISO == name) {
            	lang = it
				      return@forEach
            }
        }
        return lang
    }
	
	private class Languages {
		@SerializedName("language_options")
		val options = arrayListOf<LanguageEntity>()
		
	}
}
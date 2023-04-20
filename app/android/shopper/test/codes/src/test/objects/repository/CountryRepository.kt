package com.blueiobase.app.android.shopper.data.repository

import com.blueiobase.app.android.shopper.data.entity.CountryEntity
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import com.google.gson.internal.LinkedTreeMap

/**
 * This class is the implementation of the [ICountryRepository].
 *
 * Its primary usage is to retrieve [CountryEntity] data from the static JSON file in the res/raw/.
 *
 * **NOTE:** This repository can only perform retrieval operations. All persist operations are **NOT** supported
 * as client side is not required to save country data.
 * @author IO DevBlue
 * @since 1.0.0
 */
class CountryRepository {
	
    private var countryList = arrayListOf<CountryEntity>()

    init {
    		val file = File("C:\\Users\\Eugene\\Eclipse-JavaSE-Workspace\\MyKotlinSandBox\\CountryCodes.json")
    		FileInputStream(file).use {
		        val b = it.readAllBytes()
            val sb = StringBuilder()
            for(element in b) {
                sb.append(element.toInt().toChar())
            }
            val s = sb.toString()
            val list = Gson().fromJson(s, ArrayList::class.java)
            list.forEach {it1->
                val ltm = (it1 as LinkedTreeMap<*, *>)
                val ce = CountryEntity(ltm["name"] as String)
                ce.apply {
                    phoneCode = ltm["dial_code"] as String
                    countryCodeISO = ltm["code"] as String
                }
                countryList.add(ce)
            }
        }
    }

    fun retrieve(name: String): CountryEntity? {
        var country: CountryEntity? = null
    		countryList.forEach {
            if(it.name == name || it.countryCodeISO == name || it.phoneCode == name) {
              country = it  
            	return@forEach
            }
        }
        return country
    }
}
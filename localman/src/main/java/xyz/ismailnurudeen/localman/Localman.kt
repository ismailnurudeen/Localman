package xyz.ismailnurudeen.localman

import android.content.Context
import android.util.Log
import org.json.JSONArray
import java.io.IOException
import java.nio.charset.Charset

/**
 * @author  Ismail Nurudeen
 * @link https://github.com/ElNuru247
 */
class Localman(private val context: Context) {
    private val stateDetailsJsonArray: JSONArray

    init {
        stateDetailsJsonArray = readJSONArrayFromAsset("states_details")!!
    }

    /**
     * Returns an ArrayList of all the Local Government Areas in Nigeria
     */
    fun getAllLGAs(): ArrayList<String> {
        val lgasArrayList = ArrayList<String>()
        for (i in 0 until stateDetailsJsonArray.length()) {
            val lgasJsonArray = stateDetailsJsonArray.getJSONObject(i).getJSONArray("lgas")
            for (j in 0 until lgasJsonArray!!.length()) {
                lgasArrayList.add(lgasJsonArray[j].toString())
            }
        }
        return lgasArrayList
    }

    /**
     * Returns an ArrayList of all the States in Nigeria
     */
    fun getAllStates(): ArrayList<String> {
        val statesArrayList = ArrayList<String>()
        for (i in 0 until stateDetailsJsonArray.length()) {
            statesArrayList.add(stateDetailsJsonArray.getJSONObject(i)["name"].toString())
        }
        return statesArrayList
    }

    /**
     * Returns an ArrayList of all Local Government Areas (LGAs) in a state.
     * @param state  The State to get the LGAs from.
     */
    fun getLGAs(state: String): ArrayList<String> {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        val lgasArrayList = ArrayList<String>()
        var stateFound = false

        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true
                val lgasJsonArray = statesJsonObj.getJSONArray("lgas")
                for (j in 0 until lgasJsonArray!!.length()) {
                    lgasArrayList.add(lgasJsonArray[j].toString())
                }
            }
        }
        if (!stateFound) throw NoSuchStateException(st)
        return lgasArrayList
    }

    /**
     * Returns an ArrayList of all cities in a state.
     * returns an empty array if none is found.
     * @param state  The State to get the cities from.
     */
    fun getCities(state: String): ArrayList<String> {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        val citiesArrayList = ArrayList<String>()
        var stateFound = false

        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true

                val cities = statesJsonObj["cities"]
                if (cities is JSONArray) {
                    for (j in 0 until cities.length()) {
                        citiesArrayList.add(cities[j].toString())
                    }
                } else {
                    Log.d(this.javaClass.simpleName, "no cities found for $st st")
                    // throw NoCitiesFoundException(st)
                    break
                }
            }
        }
        if (!stateFound) throw NoSuchStateException(st)
        return citiesArrayList
    }

    /**
     * Returns the capital city of a state.
     * @param state  The State to get capital from.
     */
    fun getCapital(state: String): String {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        var stateFound = false
        var capital = ""
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true
                capital = statesJsonObj.getString("capital")
            }
        }

        if (!stateFound) throw NoSuchStateException(st)
        return capital
    }

    /**
     * Returns the state a local government area is found in.
     * returns @Null if local government area does not exist
     * @param lga  Local Government Area.
     */
    fun getLGAState(lga: String): String? {
        var state: String? = null
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            val lgasJsonArray = statesJsonObj.getJSONArray("lgas")
            for (j in 0 until lgasJsonArray!!.length()) {
                if (lgasJsonArray[j].toString().equals(lga, true)) {
                    state = statesJsonObj.getString("name")
                    break
                }
            }
        }
        return state
    }

    /**
     * Returns the state a city is found in.
     * returns @Null if city is not found in any state
     * @param city  City to get state from.
     */
    fun getCityState(city: String): String? {
        var state: String? = null
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            val cities = statesJsonObj["cities"]
            if (cities is JSONArray) {
                for (j in 0 until cities.length()) {
                    if (cities[j].toString().equals(city, true)) {
                        state = statesJsonObj.getString("name")
                        break
                    }
                }
            }
        }
        return state
    }

    /**
     * Returns the latitude of a state.
     * @param state  The State to get latitude from.
     */
    fun getLatitude(state: String): Double? {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        var stateFound = false
        var latitude: Double? = null
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true
                latitude = statesJsonObj.getDouble("latitude")
            }
        }

        if (!stateFound) throw NoSuchStateException(st)
        return latitude
    }

    /**
     * Returns the longitude of a state.
     * @param state  The state to get longitude from.
     */
    fun getLongitude(state: String): Double? {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        var stateFound = false
        var longitude: Double? = null
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true
                longitude = statesJsonObj.getDouble("longitude")
            }
        }

        if (!stateFound) throw NoSuchStateException(st)
        return longitude
    }

    /**
     * Returns the maximum latitude of a state.
     * @param state  The state to get maximum latitude from.
     */
    fun getMaxLatitude(state: String): Double? {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        var stateFound = false
        var latitude: Double? = null
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true
                latitude = statesJsonObj.getDouble("maxLat")
            }
        }

        if (!stateFound) throw NoSuchStateException(st)
        return latitude
    }

    /**
     * Returns the minimum latitude of a state.
     * @param state  The state to get minimum latitude from.
     */
    fun getMinLatitude(state: String): Double? {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        var stateFound = false
        var latitude: Double? = null
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true
                latitude = statesJsonObj.getDouble("minLat")
            }
        }

        if (!stateFound) throw NoSuchStateException(st)
        return latitude
    }

    /**
     * Returns the maximum longitude of a state.
     * @param state  The state to get longitude from.
     */
    fun getMaxLongitude(state: String): Double? {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        var stateFound = false
        var longitude: Double? = null
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true
                longitude = statesJsonObj.getDouble("maxLong")
            }
        }

        if (!stateFound) throw NoSuchStateException(st)
        return longitude
    }

    /**
     * Returns the minimum longitude of a state.
     * @param state  The state to get minimum longitude from.
     */
    fun getMinLongitude(state: String): Double? {
        var st = state
        if (st.endsWith("state", true)) st = st.substring(0, st.lastIndexOf(" "))

        var stateFound = false
        var longitude: Double? = null
        for (i in 0 until stateDetailsJsonArray.length()) {
            val statesJsonObj = stateDetailsJsonArray.getJSONObject(i)
            if (statesJsonObj.getString("name").equals(st, true)) {
                stateFound = true
                longitude = statesJsonObj.getDouble("minLong")
            }
        }

        if (!stateFound) throw NoSuchStateException(st)
        return longitude
    }

    /**
     * Returns Geo Political Zone of a State
     * @param state  The State to get Geo Political Zone from.
     */
    fun getGeoPoliticalZone(state: String) {

    }

    @Suppress("NAME_SHADOWING")
    private fun readJSONArrayFromAsset(filename: String): JSONArray? {
        var filename = filename
        var json: String? = null
        if (!filename.endsWith(".json")) filename = "$filename.json"
        try {
            val inputStream = context.getAssets().open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.defaultCharset())
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return JSONArray(json)
    }

    companion object {
        object States {
            const val ABIA = "Abia"
            const val ADAMAWA = "Adamawa"
            const val AKWA_IBOM = "Akwa Ibom"
            const val ANAMBRA = "Anambra"
            const val BAUCHI = "Bauchi"
            const val BENUE = "Benue"
            const val BORNU = "Borno"
            const val BAYELSA = "Bayelsa"
            const val CROSS_RIVER = "Cross River"
            const val DELTA = "Delta"
            const val EBONYI = "Ebonyi"
            const val EDO = "Edo"
            const val EKITI = "Ekiti"
            const val ENUGU = "Enugu"
            const val FCT = "Federal Capital Territory"
            const val GOMBE = "Gombe"
            const val JIGAWA = "Jigawa"
            const val IMO = "Imo"
            const val KADUNA = "Kaduna"
            const val KEBBI = "Kebbi"
            const val KANO = "Kano"
            const val KOGI = "Kogi"
            const val LAGOS = "Lagos"
            const val KATSINA = "Katsina"
            const val KWARA = "Kwara"
            const val NASARAWA = "Nasarawa"
            const val NIGER = "Niger"
            const val OGUN = "Ogun"
            const val ONDO = "Ondo"
            const val RIVERS = "Rivers"
            const val OYO = "Oyo"
            const val OSUN = "Osun"
            const val SOKOTO = "Sokoto"
            const val PLATEAU = "Plateau"
            const val TARABA = "Taraba"
            const val YOBE = "Yobe"
            const val ZAMFARA = "Zamfara"
        }

        object GeoPoliticalZone {
            const val NORTH_CENTRAL = "North Central"
            const val NORTH_EAST = "North East"
            const val NORTH_WEST = "North West"
            const val SOUTH_SOUTH = "South South"
            const val SOUTH_EAST = "South East"
            const val SOUTH_WEST = "South West"
        }
    }

    class NoCitiesFoundException(private val state: String) : Exception() {
        override fun getLocalizedMessage(): String {
            return "no cities found for $state state"
        }
    }

    class NoSuchStateException(private val state: String) : Exception() {
        override fun getLocalizedMessage(): String {
            return "$state is not a state in Nigeria or it's spelt incorrectly"
        }
    }
}
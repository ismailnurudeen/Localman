package xyz.ismailnurudeen.origin.utils

import android.content.Context
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

@Suppress("NAME_SHADOWING")
private class JSONReader(var context: Context) {

    fun readJSONFromAsset(filename: String): JSONObject? {
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
        return JSONObject(json)
    }
}
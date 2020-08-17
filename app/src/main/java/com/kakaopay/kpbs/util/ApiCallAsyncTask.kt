package com.kakaopay.kpbs.util

//
/**
 * 20200817 dydeoddl
 * REST API 호출을 위한 AsyncTask Class
 */

import android.os.AsyncTask
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class ApiCallAsyncTask : AsyncTask<Void, Void, String>() {

    private var m_strRestAPIHost: String? = "dapi.kakao.com"
    private var m_strRestAPIKey: String? = "1088928e49d79eee1c1b03354bf4decf"
    private var m_strDefaultURL: String? = "https://dapi.kakao.com/v3/search/book?"
    private var m_URL: String? = null

    fun setQuery(sQuery: String?) {
        m_URL = m_strDefaultURL + sQuery
    }

    override fun doInBackground(vararg params: Void?): String? {
        // ...

        var sendURL = URL(m_URL)

        with(sendURL.openConnection() as HttpURLConnection) {
            requestMethod = "GET"

            setRequestProperty("Host", m_strRestAPIHost)
            setRequestProperty("Authorization", "KakaoAK " + m_strRestAPIKey)
//
            connect()

            println("URL : $url")
            println("Response Code : $responseCode")
            println("Response Message : $responseMessage")

            var strResult = ""
            try {
                if ( responseCode == HttpURLConnection.HTTP_OK ) {
                    strResult = inputStream.use { it.reader().use { reader -> reader.readText() } }
                }

            } finally {
                disconnect()
            }
            return strResult
        }

        return ""
    }

    override fun onPreExecute() {
        super.onPreExecute()
        // ...
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        // ...
    }
}
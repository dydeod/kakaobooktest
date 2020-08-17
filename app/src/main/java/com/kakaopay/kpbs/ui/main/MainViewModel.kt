package com.kakaopay.kpbs.ui.main

import androidx.lifecycle.ViewModel
import com.kakaopay.kpbs.util.ApiCallAsyncTask
import org.json.JSONArray
import org.json.JSONObject

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    fun CallAPIQueryData(sQuery: String?) {
        //var m_ApiCallAsyncTask: ApiCallAsyncTask? = null

        var apiCallAsyncTask = ApiCallAsyncTask()
        apiCallAsyncTask.setQuery(sQuery)


        var strResult:String = apiCallAsyncTask!!.execute().get();

        if ( strResult != "" ) {
            try {
                val jsonObject = JSONObject(strResult)

                val metaData: JSONObject = jsonObject.getJSONObject("meta")
                val bookArray: JSONArray = jsonObject.getJSONArray("documents")

                var d: String
                d = "123"
            } catch (e:Exception) {
                var s = e.toString()
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
    }
}

package com.kakaopay.kpbs.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.kakaopay.kpbs.R
import java.net.URLEncoder

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        //return inflater.inflate(R.layout.main_fragment, container, false)

        var root = inflater.inflate(R.layout.main_fragment, container, false)

        var btnMF1 = root.findViewById<View>(R.id.btnMF1) as Button

        btnMF1.setOnClickListener {

            var strQuery: String
            strQuery = "sort=accuracy&query=" + URLEncoder.encode("카카오", "utf-8")
            viewModel.CallAPIQueryData(strQuery)
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }
}

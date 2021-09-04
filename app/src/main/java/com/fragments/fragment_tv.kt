package com.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.Pojo.Users_Model
import com.example.fragment_to_fragment.R
import java.lang.Exception


class fragment_tv : Fragment() {

    var name:String? = null
    var prnm:String? = null
    var age:String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ar = arguments

        name = ar?.getString("name")
        prnm = ar?.getString("prnm")
        age = ar?.getInt("age").toString()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_tv, container, false)

        val tv_name = v.findViewById<TextView>(R.id.f_tv_name)
        val tv_prnm = v.findViewById<TextView>(R.id.f_tv_prnm)
        val tv_age = v.findViewById<TextView>(R.id.f_tv_age)

        if (name == null)
        {
          name = ""
        }
        if (prnm == null)
        {
            prnm = ""
        }
        if (age.toString() == "null")
        {
            age = ""
        }

        tv_name.text = name
        tv_prnm.text = prnm
        tv_age.text = age.toString()

        return v
    }


}
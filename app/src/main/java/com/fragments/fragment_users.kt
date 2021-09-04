package com.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Users_Model
import com.example.fragment_to_fragment.R


class fragment_users : Fragment() {

    var listenner:listerner_form_fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onAttach(context: Context) {
        listenner = context as listerner_form_fragment
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_users, container, false)

        val rv = v.findViewById<RecyclerView>(R.id.rv_users)

        val lm = LinearLayoutManager(activity)

        val adapter = Adapter_Users()

        val list_users = arrayListOf<Users_Model>()

        list_users.add(Users_Model("Mohamed" ,"Mezenner",19))
        list_users.add(Users_Model("Monir" ,"Mezdasa",20))
        list_users.add(Users_Model("Jmal" ,"Hmadoch",21))
        list_users.add(Users_Model("Milod" ,"Zendara",22))
        list_users.add(Users_Model("Kodiro" ,"Ahdochin",34))

        rv.layoutManager = lm

        rv.adapter = adapter

        adapter.setList(list_users)

        adapter.listenner(object :Rvsetonclicklistenner
        {
            override fun onItemSelect(user: Users_Model) {
                listenner!!.onitemClik(user)
            }

        })
        return v
    }

    override fun onDetach() {
        listenner = null
        super.onDetach()
    }

    interface listerner_form_fragment{

        fun onitemClik(user: Users_Model)

    }
}
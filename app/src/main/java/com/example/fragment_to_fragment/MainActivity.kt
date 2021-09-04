package com.example.fragment_to_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Pojo.Users_Model
import com.fragments.fragment_tv
import com.fragments.fragment_users

class MainActivity : AppCompatActivity(),fragment_users.listerner_form_fragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onitemClik(user: Users_Model) {

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        val fragment = fragment_tv()

        val bundle = Bundle()
        bundle.putString("name",user.name)
        bundle.putString("prnm",user.prnm)
        bundle.putInt("age",user.age)

        fragment.arguments = bundle
        ft.replace(R.id.fragment_tv,fragment)
        ft.commit()
    }
}
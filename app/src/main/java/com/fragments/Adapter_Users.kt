package com.fragments
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Users_Model
import com.example.fragment_to_fragment.R

class Adapter_Users: RecyclerView.Adapter<Adapter_Users.viewHolderUsers>() {

    private var arraylist = arrayListOf<Users_Model>()
    private var listenner:Rvsetonclicklistenner? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderUsers {

        return viewHolderUsers(LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false))

    }

    override fun onBindViewHolder(holder: viewHolderUsers, position: Int) {

        holder.tv_age.text = arraylist[position].age.toString()
        holder.tv_name.text = arraylist[position].name
        holder.tv_prnm.text = arraylist[position].prnm
        holder.itemView.setOnClickListener {
            listenner?.onItemSelect(arraylist[position])
        }

    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class viewHolderUsers(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
        val tv_prnm = itemView.findViewById<TextView>(R.id.tv_prnm)
        val tv_age = itemView.findViewById<TextView>(R.id.tv_age)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(ArrayList:ArrayList<Users_Model>)
    {
        this.arraylist = ArrayList
        notifyDataSetChanged()
    }

    fun listenner(listenner:Rvsetonclicklistenner)
    {
        this.listenner = listenner
    }
}
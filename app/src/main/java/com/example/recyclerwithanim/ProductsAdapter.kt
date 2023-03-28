package com.example.recyclerwithanim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwithanim.util.ItemAdapter
import java.util.Collections

class ProductsAdapter(var context: Context, var list:MutableList<Products>,
                      callback: ItemTouchHelper.Callback
): RecyclerView.Adapter<ProductsAdapter.MyHolder>(), ItemAdapter {
    class MyHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        var img = itemview.findViewById<ImageView>(R.id.imagemain)
        var t1 = itemview.findViewById<TextView>(R.id.text1)
        var t2 = itemview.findViewById<TextView>(R.id.text2)
        val main = itemview.findViewById<CardView>(R.id.card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val myHolder =MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
        return myHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val a = list.get(position)
        holder.img.setImageResource(a.rasm)
        holder.t1.text = a.textfirst
        holder.t2.text = a.textsecond
        val anim = AnimationUtils.loadAnimation(context, R.anim.fromleft)
        holder.main.startAnimation(anim)
    }


    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition){
                Collections.swap(list, i, i + 1)
        }
    } else {
            for (i in fromPosition downTo toPosition){
                Collections.swap(list, i, i - 1)
        }
    }
notifyItemMoved(fromPosition,toPosition)
    }

    override fun onItemDismiss(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }
}
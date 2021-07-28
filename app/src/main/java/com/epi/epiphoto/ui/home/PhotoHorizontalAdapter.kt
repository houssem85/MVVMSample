package com.epi.epiphoto.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.epi.epiphoto.R
import com.epi.epiphoto.data.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_photo_horizontal.view.*

class PhotoHorizontalAdapter(private val context: Context,private val onClick : (Int) -> Unit) : RecyclerView.Adapter<PhotoHorizontalAdapter.ViewHolder>(){

    val items = ArrayList<Photo>()

    fun setData(list:List<Photo>)
    {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun getItem(position: Int) = items[position]

    fun vue(position:Int)
    {
        items[position].vue = true
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_photo_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val model = items[position]
       holder.bindData(model)
       holder.bindEvents(position,onClick)
    }

    override fun getItemCount() = items.size

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

        private val view = view
        private val lblUserName = view.lbl_user_name
        private val imgProfile = view.img_profile
        private val cadre = view.cadre

        fun bindData(photo: Photo){
            lblUserName.text = photo.user.username
            Glide.with(view.context)
                .load(photo.user.profileImage.large)
                .centerCrop()
                .into(imgProfile)
            if(photo.vue) {
                cadre.visibility = INVISIBLE
            }else{
                cadre.visibility = VISIBLE
            }
        }

        fun bindEvents(position : Int,onClick : (Int) -> Unit)
        {
            imgProfile.setOnClickListener {
                onClick.invoke(position)
            }
        }
    }
}
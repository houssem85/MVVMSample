package com.epi.epiphoto.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.epi.epiphoto.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(R.layout.fragment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val photo = args.photo
        Glide.with(view.context).load(photo.user.profileImage.large).centerCrop().into(img_profile)
        lbl_user_name.text = photo.user.username
        lbl_small_description.text = photo.description.toString()
        lbl_description.text = photo.altDescription.toString()
        lbl_creation_date.text = "Created At : ${photo.createdAt?.take(10)}"
        lbl_updated_date.text = "Updated At : ${photo.updatedAt?.take(10)}"
    }



}
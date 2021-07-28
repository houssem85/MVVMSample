package com.epi.epiphoto.ui.detail_photo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.epi.epiphoto.R
import kotlinx.android.synthetic.main.fragment_detail_photo.*

class DetailPhotoFragment : Fragment(R.layout.fragment_detail_photo) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = DetailPhotoFragmentArgs.fromBundle(requireArguments())
        val url = args.imgProfile
        Glide.with(view.context).load(url).centerCrop().into(img_profile)
    }
}
package com.epi.epiphoto.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.epi.epiphoto.R
import com.epi.epiphoto.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var adapterHorizontal : PhotoHorizontalAdapter
    lateinit var adapterVertical : PhotoVerticalAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHorizontalRecycleView()
        setupVerticalRecycleView()
        observePhotos()
    }

    private fun setupHorizontalRecycleView()
    {
        adapterHorizontal = PhotoHorizontalAdapter(requireContext()) { position ->
            val photo = adapterHorizontal.getItem(position)
            val action = HomeFragmentDirections.actionHomeFragmentToDetailPhotoFragment(photo.user.profileImage.large)
            findNavController().navigate(action)
        }
        horizontal_recycler_view.layoutManager  = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        horizontal_recycler_view.adapter = adapterHorizontal
    }

    private fun setupVerticalRecycleView()
    {
        adapterVertical = PhotoVerticalAdapter(requireContext()){ position ->
            val photo = adapterHorizontal.getItem(position)
            adapterHorizontal.vue(position)
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(photo)
            findNavController().navigate(action)
        }
        vertical_recycler_view.layoutManager  = GridLayoutManager(requireContext(), 2)
        vertical_recycler_view.adapter = adapterVertical
    }

    private fun observePhotos(){
        viewModel.photos.observe(viewLifecycleOwner,{
            when(it.status){
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    Toast.makeText(context , it.message , Toast.LENGTH_LONG).show()
                }
                Status.SUCCESS -> {
                    adapterHorizontal.setData(it.data!!)
                    adapterVertical.setData(it.data)
                }
                else -> {

                }
            }
        })
    }
}
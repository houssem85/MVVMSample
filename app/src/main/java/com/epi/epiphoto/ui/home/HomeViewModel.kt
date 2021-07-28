package com.epi.epiphoto.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epi.epiphoto.data.model.Photo
import com.epi.epiphoto.data.repository.Repository
import com.epi.epiphoto.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _photos = MutableLiveData<Resource<List<Photo>>>()
    val photos : LiveData<Resource<List<Photo>>> = _photos

    init {
        getPhoto()
    }

    fun getPhoto()
    {
       viewModelScope.launch(Dispatchers.IO) {
           _photos.postValue(Resource.loading(null))
           val data = repository.getRandomPhotos()
           _photos.postValue(data)
       }
    }
}
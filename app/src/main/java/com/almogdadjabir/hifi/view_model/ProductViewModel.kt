package com.almogdadjabir.hifi.view_model

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almogdadjabir.hifi.model.products.Data
import com.almogdadjabir.hifi.model.products.ProductAPIDATA
import com.almogdadjabir.hifi.other.Constants
import com.almogdadjabir.hifi.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.M)
@SuppressLint("StaticFieldLeak")

@HiltViewModel
class ProductViewModel
@Inject constructor(
    private val repository: Repository,
    private val context: Context
) :
    ViewModel() {

    private var _allProducts = MutableLiveData<List<Data>>(null)
    val allProducts: LiveData<List<Data>> =  _allProducts


    init {
        getAllChapter()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getAllChapter() {
        if (Constants.isOnline(context)) {
            Constants.createToast("Online Mode !!", context)
            getRemoteChapter()
        } else {
            Constants.createToast("Offline Mode !!", context)
//            getLocalChapter()
        }
    }

    private fun getRemoteChapter() {
        Log.d("getRemoteChapter","shqala")
        viewModelScope.launch {
            kotlin.runCatching {
                repository.getAllProducts()
            }.onSuccess {
                val _data = it.data
                _allProducts.value = _data
//                insertChapterToDB()
                Log.d("getRemoteChapter","onSuccess")

            }.onFailure {
                _allProducts.value = null
                Log.d("getRemoteChapter","onFailure")

            }
        }
    }


}
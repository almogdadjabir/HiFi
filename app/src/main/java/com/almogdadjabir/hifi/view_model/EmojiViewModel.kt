package com.example.fortest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class EmojiViewModel : ViewModel() {

    private var _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    init {
        getData()
    }
     fun getData() {
        viewModelScope.launch {
            for (i in 0..200){
                val string = getEmojis()
                _data.postValue(string)
                delay(1000)

            }
        }
    }

    private fun getEmojis(): String {
        val emoji = arrayOf(
            "be a part of our family " + String(Character.toChars(0x1F680)),
            "be a part of our family " + String(Character.toChars(0x1F60D)),
            "be a part of our family " + String(Character.toChars(0x1F63A)),
            "be a part of our family " + String(Character.toChars(0x270A)),
            "be a part of our family " + String(Character.toChars(0x1F60F)),
            "be a part of our family " + String(Character.toChars(0x1F6A7)),
            "be a part of our family " + String(Character.toChars(0x2665)),
            "be a part of our family " + String(Character.toChars(0x1F631)),
            "be a part of our family " + String(Character.toChars(0x1F33A)),
            "be a part of our family " + String(Character.toChars(0x1F344)),
            "be a part of our family " + String(Character.toChars(0x1F36A)),
        )
        //Log.d("lol", "getEmojis: ${emoji[Random.nextInt(0, emoji.size)]}")
        return emoji[Random.nextInt(0, emoji.size)]
    }
}
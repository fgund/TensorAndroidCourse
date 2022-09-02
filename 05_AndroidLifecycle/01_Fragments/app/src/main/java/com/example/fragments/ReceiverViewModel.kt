package com.example.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverViewModel : ViewModel() {

    private val messageMutableLiveData = MutableLiveData("")

    val messageLiveData: LiveData<String>
        get() = messageMutableLiveData

    fun setMessage(message: String) {
        messageMutableLiveData.value = message
    }

    fun setIsRead(){
        setMessage("All messages are read")
    }
}
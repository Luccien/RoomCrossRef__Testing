package eu.de.servicetestfragment.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val testS by lazy { MutableLiveData<String>() }

    fun refresh(){
        //testS.value += "Hallo Mutable"
        testS.value +="A"
        println(testS.value.toString())
        println("REFRESH OK 2 ")

    }
}

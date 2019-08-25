package com.illuminator.kotlintest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.illuminator.kotlintest.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class KotlinTestActivity : AppCompatActivity() {

    private val foodList = arrayListOf("Chinese", "Hamburger", "Pizza", "MacDonalds", "Taco")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideButton.setOnClickListener {
//            Toast.makeText(this, "You clicked me!", LENGTH_SHORT).show()
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodText.text = foodList[randomFood]
        }

        addFoodButton.setOnClickListener {
//            clickableFun()
            hasPrefix()
        }

    }

    private fun clickableFun(){
        val newFood = addFoodText.text.toString()
        if(newFood.isNotEmpty()){
            foodList.add(newFood)
            addFoodText.text.clear()
            println(foodList)
        }
    }

    fun hasPrefix(){
        val items = setOf("orange", "apple", "banana", "kiwi")
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }
    }
}

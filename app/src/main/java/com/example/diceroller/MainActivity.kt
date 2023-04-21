package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Displaying a button that execute roll dice when clicked
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Dice pre rolled when user execute the app
        rollDice()
    }
    // Function that roll dice
    private fun rollDice() {
        // Creating an object dice from Dice class
        val dice = Dice(6)

        // Saving the value of roll method
        val diceRoll = dice.roll()

        // Saving the imageView id to diceImage object
        val diceImage: ImageView =  findViewById(R.id.imageView)

        // Saving the right dice picture based on the dice roll number
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Setting the image view with the right saved image on drawableResource object
        diceImage.setImageResource(drawableResource)

        // Setting the image description to number that been rolled
        diceImage.contentDescription = diceRoll.toString()
    }
}

// Class that simulate a dice where taking parameters as sides of the dice
class Dice(private val numSides: Int) {

    // Method that pick random sides, simulating a roll of a dice
    fun roll(): Int {
        return (1..numSides).random()
    }
}
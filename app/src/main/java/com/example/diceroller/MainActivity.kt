package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * This Activity show button that would show random
 * dice number when button pressed*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {        //onCreate > main > later learned on project
        super.onCreate(savedInstanceState)                      //onCreate > main > later learned on project
        setContentView(R.layout.activity_main)                  //onCreate > main > later learned on project

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * This rollDice func. taking Dice class and apply roll
     * method and express it in text view*/
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val diceTwo = Dice(6)
        val diceRollTwo = diceTwo.roll()
        val resultTextViewTwo: TextView = findViewById(R.id.textViewTwo)
        resultTextViewTwo.text = diceRollTwo.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rollbtn : Button = findViewById(R.id.roll_btn)
        rollbtn.setOnClickListener{
            diceRoller()
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
        }

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Main Menu Appeared", Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu01, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val emptydice : ImageView = findViewById(R.id.dice_image)
        var itemview = item.itemId
        when(itemview){
            R.id.reset -> emptydice.setImageResource(R.drawable.empty_dice),Toast.makeText(applicationContext,"Dice Reseted", Toast.LENGTH_LONG).show()
            R.id.user -> Toast.makeText(applicationContext,"User Details", Toast.LENGTH_LONG).show()
            R.id.settings -> Toast.makeText(applicationContext,"Settings", Toast.LENGTH_LONG).show()
            R.id.more -> Toast.makeText(applicationContext,"More Options", Toast.LENGTH_LONG).show()
        }

        return false
    }

    private fun diceRoller() {

        val randomInt = java.util.Random().nextInt(6)+1

        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceImage : ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
    }
}
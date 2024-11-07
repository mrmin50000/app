package com.example.myapplication

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.MyButton)
        val linearLayout = findViewById<LinearLayout>(R.id.LL)

        var stateColor = "yellow"

        button.setOnClickListener {
            if (stateColor.equals("yellow")) {
                stateColor = "purple"
                linearLayout.background = AppCompatResources.getDrawable(this, R.color.purple)
            } else {
                stateColor = "yellow"
                linearLayout.background = AppCompatResources.getDrawable(this, R.color.yellow)
            }
        }

        val buttonTV = findViewById<TextView>(R.id.ButTV)
        val linearLayoutTV = findViewById<LinearLayout>(R.id.TV)
        val ET = findViewById<EditText>(R.id.ED)


        var stateColorTV = "yellow"

        ET.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                /*Toast.makeText(this@MainA ctivity,"onTextChanged $s",Toast.LENGTH_SHORT).show()*/
                buttonTV.text = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        buttonTV.setOnLongClickListener{
            Toast.makeText(this, "Long click detected", Toast.LENGTH_SHORT).show()
            if (stateColorTV.equals("yellow")) {
                stateColorTV = "purple"
                linearLayoutTV.background = AppCompatResources.getDrawable(this, R.color.purple)
            } else {
                stateColorTV = "yellow"
                linearLayoutTV.background = AppCompatResources.getDrawable(this, R.color.yellow)
            }
            return@setOnLongClickListener true
        }
        val buttonIM = findViewById<ImageView>(R.id.IMG)
        val back = buttonIM.background
        val linearLayoutIM = findViewById<LinearLayout>(R.id.IV)

        var doubleClick: Boolean = false
        buttonIM.setOnClickListener {
            if (doubleClick) {
                Toast.makeText(this, "double click detected", Toast.LENGTH_SHORT).show()
                if (buttonIM.background != linearLayoutIM.background)
                    buttonIM.background = linearLayoutIM.background
                else {
                    buttonIM.background = back
                }
                doubleClick = false
            }
            else
                doubleClick = true
            android.os.Handler().postDelayed({ doubleClick = false }, 500)
        }


    }

}
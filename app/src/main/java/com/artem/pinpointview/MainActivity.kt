package com.artem.pinpointview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textV = findViewById<TextView>(R.id.textV)
        val pinPoint = findViewById<PinPointView>(R.id.pinPointView)

        val btn_none=findViewById<Button>(R.id.btn_none)
        val btn_one=findViewById<Button>(R.id.btn_one)
        val btn_two=findViewById<Button>(R.id.btn_two)
        val btn_three=findViewById<Button>(R.id.btn_three)
        val btn_four=findViewById<Button>(R.id.btn_four)
        val btn_error=findViewById<Button>(R.id.btn_error)
        // get device dimensions
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels


        btn_none.setOnClickListener {
            pinPoint.state=PinPointView.PinState.NONE
        }
        btn_one.setOnClickListener {
            pinPoint.state=PinPointView.PinState.ONE
        }
        btn_two.setOnClickListener {
            pinPoint.state=PinPointView.PinState.TWO
        }
        btn_three.setOnClickListener {
            pinPoint.state=PinPointView.PinState.THREE
        }
        btn_four.setOnClickListener {
            pinPoint.state=PinPointView.PinState.FOUR
        }
        btn_error.setOnClickListener {
            pinPoint.state=PinPointView.PinState.ERROR
        }

        textV.text = width.toString() + " x " + height.toString()
    }


}
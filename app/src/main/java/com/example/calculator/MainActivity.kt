package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.button16)
        buttonClick.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }

    }

    fun limpiarpantalla(view: View) {
        clearCache()
        updateDisplay("");
    }

    val numberCache: MutableList<String> = arrayListOf()

    fun clearCache() {
        numberCache.clear()
    }

    fun updateDisplay(mainDisplayString: String){
        val mainTextView = findViewById(R.id.textView) as TextView
        mainTextView.text = mainDisplayString
    }

    fun makeString(list: List<String>,joiner: String = "") : String {

        if (list.isEmpty()) return ""
        return list.reduce { r, s -> r + joiner + s }
    }

    fun numberClick(view: View) {
        val button = view as Button
        val numberString = button.text;

        numberCache.add(numberString.toString())
        val text = makeString(numberCache);
        updateDisplay(text)
    }
}
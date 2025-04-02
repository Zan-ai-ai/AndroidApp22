package vcmsa.ci.genapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {


    private var yearInput: EditText? = null
    private var genText: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        yearInput = findViewById(R.id.yearInput)
        genText = findViewById(R.id.genText)

        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val clearbtn = findViewById<Button>(R.id.clearbtn)
        val exitbtn = findViewById<Button>(R.id.exitbtn)

        btnCheck.setOnClickListener {
            checkGeneration()
        }
       clearbtn.setOnClickListener {
           yearInput?.text?.clear()
           genText?.text = ""
       }
        exitbtn.setOnClickListener {
            finishAffinity()
            exitProcess(status = 0)
        }
    }

    private fun isNotEmpty(): Boolean {
        var a = true
        if (yearInput?.text.toString().trim().isEmpty()) {
            yearInput?.error = "Input Required"
            a = false
        }
        return a
    }

    private fun checkGeneration() {

        if (isNotEmpty()) {


            when (yearInput?.text.toString().trim().toInt()) {

                in 1901..1924 -> genText?.text = "The Greatest Generation"
                in 1925..1945 -> genText?.text = "The Silent Generation"
                in 1946..1964 -> genText?.text = "The Baby Boomer Generation"
                in 1965..1980 -> genText?.text = "Generation X"
                in 1981..1996 -> genText?.text = "The Millennial"
                in 1997..2012 -> genText?.text = "Generation Z"
                in 2013..2025 -> genText?.text = "Generation Alpha"

                else -> {
                    genText?.text = "Alien!!! Your birth year is INVALID!!!"


                }


            }


        }


    }
}


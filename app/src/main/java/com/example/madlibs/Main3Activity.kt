package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class Main3Activity : AppCompatActivity() {
    val generate: String = "madlib0_simple"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val inputs = intent.getStringArrayListExtra("dato")
       /** val ran= intent.getIntExtra("rand",1)
        var escoger=""
        when(ran){
            1-> escoger="madlib0_simple"
            2-> escoger="madlib1_tarzan"
            3-> escoger="madlib2_university"
            4-> escoger="madlib3_clothes"
            5-> escoger="madlib4_dance"
        }
        val generate: String = escoger*/

        storyfin(inputs, resources.getIdentifier(generate, "raw", packageName))

        val gou= findViewById<Button>(R.id.b1)

        gou.setOnClickListener {

            val intent = Intent( this@Main3Activity, MainActivity::class.java)

            startActivity(intent)    }

    }

    fun storyfin(inputs: ArrayList<String>, idir: Int){
        val builder = StringBuilder()
        val scan = Scanner(resources.openRawResource(idir))
        val L = scan.nextLine()
        builder.append(L)

        while(scan.hasNextLine()){
            val line = scan.nextLine()
            builder.append(" ")
            builder.append(line)
        }

        var `val` = builder.toString()
        val reg = Regex("<.*?>")
        val blanco = reg.findAll(`val`).map { it.value }
        var i: Int = 0
        for(blanco in blanco){
            `val` = `val`.replaceFirst(blanco, inputs.get(i))
            i++
        }
        sto.text = "$`val`"
    }

}




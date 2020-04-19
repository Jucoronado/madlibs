package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       leer()

        val gou= findViewById<Button>(R.id.b1)

        gou.setOnClickListener {

            val intent = Intent( this@MainActivity, Main2Activity::class.java)

            startActivity(intent)    }



    }
        fun leer(){
            val scanner = Scanner(resources.openRawResource(R.raw.desc))
            var descripcion = " "
            while (scanner.hasNextLine()) {
                val linea = scanner.nextLine()
                descripcion += linea
            }
            scanner.close()

            text1a1.setText(descripcion)
        }

}

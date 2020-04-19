package com.example.madlibs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*
import kotlin.random.Random

class Main2Activity : AppCompatActivity() {

     var dir = 0
     val posicion = 123
     var total1 = 0
     var total2 = 0
     val lista = ArrayList<String>()
     val palabras = ArrayList<String>()
   //var rnum= ran()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


      /** var escoger=""
        when(rnum){
            1-> escoger="madlib0_simple"
            2-> escoger="madlib1_tarzan"
            3-> escoger="madlib2_university"
            4-> escoger="madlib3_clothes"
            5-> escoger="madlib4_dance"
        }*/



        modificar("madlib0_simple")


          }
    fun modificar(leer: String){
        val buscar = StringBuilder()
        this.dir = resources.getIdentifier(leer, "raw", packageName)
        val scan = Scanner(resources.openRawResource(dir))
        while(scan.hasNextLine()){
            val line = scan.nextLine()
            buscar.append(line)
        }
        var alltext = buscar.toString()
        val reg = Regex("<.*?>")
        val found = reg.findAll(alltext)
        found.forEach{ x ->
            val y = x.value
            palabras.add(y)
            total2++
        }
        total1 = total2
        val valor = palabras.get(0)
        edicion.hint = "$valor"
    }

    fun Conteo(vista: View){
        if(edicion.text.toString().isEmpty() || edicion.text.toString().trim().isEmpty()){
            Toast.makeText(applicationContext, "Digite palabra", Toast.LENGTH_SHORT).show()
        }
        else{
            val word = edicion.text.toString().trim()
            lista.add(word)
            total2--
            edicion.setText("")
            if(total2 >= 1){
                val total = palabras.get(palabras.size - total2)
                edicion.hint = " $total "
            }else if(total2 == 0){
                val intent = Intent(this, Main3Activity::class.java)
              //val rand= rnum
              // intent.putExtra("rand",rand)
                intent.putExtra("dato", lista)
                startActivityForResult(intent, posicion)
            }
        }
    }
    fun ran(): Int{
        val numero : Int = Random.nextInt(1,1000)
        Toast.makeText(applicationContext, numero.toString(), Toast.LENGTH_LONG).show()
        return numero
    }

  }
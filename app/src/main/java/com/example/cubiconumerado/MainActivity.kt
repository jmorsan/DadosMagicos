package com.example.cubiconumerado

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonLanzar: Button = findViewById(R.id.botonLanzar)
        botonLanzar.setOnClickListener(){
            val toast = Toast.makeText(this,"Has lanzado el dado",Toast.LENGTH_SHORT)
            toast.show()

            val dado1=Dado(6)
            val dado2=Dado(6)
            val resultLanzamiento = dado1.lanzar()
            val resultLanzamiento2 = dado2.lanzar()
            //val vistaResultado : TextView = findViewById(R.id.textView)
            //val vistaResultado2 : TextView = findViewById(R.id.textView2)

            //vistaResultado.text = resultLanzamiento.toString()
            //vistaResultado2.text = resultLanzamiento2.toString()


            val imagenDado: ImageView = findViewById(R.id.imageView2)
            val imagenDado2: ImageView = findViewById(R.id.imageView3)
            /*
            when(resultLanzamiento){
                1->imagenDado.setImageResource(R.drawable.dice_1)
                2->imagenDado.setImageResource(R.drawable.dice_2)
                3->imagenDado.setImageResource(R.drawable.dice_3)
                4->imagenDado.setImageResource(R.drawable.dice_4)
                5->imagenDado.setImageResource(R.drawable.dice_5)
                6->imagenDado.setImageResource(R.drawable.dice_6)
            }
            */


            imagenDado.setImageResource(caraDado(resultLanzamiento))
            imagenDado2.setImageResource(caraDado(resultLanzamiento2))


        }
    }
    fun caraDado(resultLanzamiento : Int): Int {
        val dibujoDado = when(resultLanzamiento){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        return dibujoDado
    }
}

class Dado (val caras : Int){
    fun lanzar():Int{
        return(1..caras).random()
    }
}
package com.wikilift.frasesanimo

import android.content.ContentValues
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

class MainScreen : Fragment(R.layout.fragment_main_screen) {

    private lateinit var btn: Button
    private lateinit var txt: TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val admin = AdminSQLiteOpenHelper(requireContext(), "frasesanimo", null, 1)
        var bd = admin.writableDatabase

        btn = view.findViewById(R.id.btn_Regen)
        txt = view.findViewById(R.id.txt_Show)


        val list = admin.getAllFrases(bd)
        bd.close()

        txt.text = list[getRandom()]
        btn.setOnClickListener{


            txt.text = list[getRandom()]

            txt.setTextColor(Color.parseColor(getRandomColor()))
        }
     }

    private fun getRandom(): Int = ThreadLocalRandom.current().nextInt(0,8)



    private fun getRandomColor():String{
        return when((0..4).random()){
            0->{"#305ce1"}
            1->{"#b745f5"}
            2->{"#13466e"}
            3->{"#c25091"}
            4->{"#e30027"}
            else->{"#e30027"}

        }
    }
}
package com.wikilift.frasesanimo

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class AdminSQLiteOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table frasesanimo(id int primary key , frase text)")
        db.execSQL("INSERT INTO frasesanimo (frase) VALUES('A veces se necesita una ruptura abrumadora para tener un avance innegable.')")
        db.execSQL("INSERT INTO frasesanimo (frase) VALUES('Se te ha asignado esta montaña para mostrarles a otros que se puede mover.')")
        db.execSQL("INSERT INTO frasesanimo (frase) VALUES('Nunca debes tener miedo de lo que estás haciendo cuando es correcto.')")
        db.execSQL("INSERT INTO frasesanimo (frase) VALUES('Cree en ti mismo y serás imparable.')")
        db.execSQL("INSERT INTO frasesanimo (frase) VALUES('Solo fallas cuando dejas de intentarlo.')")
        db.execSQL("INSERT INTO frasesanimo (frase) VALUES('Nunca he conocido a una persona fuerte con un pasado fácil.')")
        db.execSQL("INSERT INTO frasesanimo (frase) VALUES('Las dificultades a menudo preparan a la gente común para un destino extraordinario.')")
        db.execSQL("INSERT INTO frasesanimo (frase) VALUES('La mejor revancha es el éxito masivo. ')")




    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
           onCreate(db)
    }
    fun getAllFrases(db: SQLiteDatabase):MutableList<String>{
        val list= arrayListOf<String>()
       val c:Cursor= db.rawQuery("select frase from frasesanimo ", null)
        while (c.moveToNext()){
            val s:String=c.getString(c.getColumnIndex("frase"))
            list.add(s)


        }
        c.close()
        return list
    }
}
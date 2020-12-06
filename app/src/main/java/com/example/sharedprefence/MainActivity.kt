package com.example.sharedprefence

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        btn_save.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val insertedText1 = et_nama.text.toString()
        val insertedText2 = et_umur.text.toString()
        val insertedText3 = et_tgl.text.toString()

        tv_text.text = ("$insertedText1 $insertedText2 $insertedText3")

        val sharedPrefences = getSharedPreferences("sharePrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefences.edit()
        editor.apply {
            putString("STRING_KEY1", insertedText1)
            putString("STRING_KEY2", insertedText2)
            putString("STRING_KEY3", insertedText3)
        }.apply()

        Toast.makeText(this, "Data Saved.", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        val sharedPrefences = getSharedPreferences("sharePrefs", Context.MODE_PRIVATE)
        val savedString1 = sharedPrefences.getString("STRING_KEY1",  null)
        val savedString2 = sharedPrefences.getString("STRING_KEY2",  null)
        val savedString3 = sharedPrefences.getString("STRING_KEY3",  null)

        tv_text.text = ("$savedString1 $savedString2 $savedString3")
    }
}
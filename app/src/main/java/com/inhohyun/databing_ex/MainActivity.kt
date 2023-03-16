package com.inhohyun.databing_ex

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inhohyun.databing_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val array = ArrayList<String>()

        array.add("a")
        array.add("b")
        array.add("a")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("a")
        array.add("b")

        val customAdapter = CustomAdapter(array)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = customAdapter
        rv.layoutManager = LinearLayoutManager(this)


        val btn = findViewById<Button>(R.id.testBtnId)

        // 1번 방식 - findViewById
        btn.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }

        // 2번 방식 - Databinding
        binding.testBtnId.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }
        //데이터 결합
        val person = Person("인호현", 25)
        binding.user = person
    }

    fun myClick(view : View){

    }
}
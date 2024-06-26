package com.o7services.kotlin5_6_online

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.kotlin5_6_online.databinding.ActivityInteractionBinding

class ActivityInteraction : AppCompatActivity() {
    lateinit var binding: ActivityInteractionBinding
    var myInterface:MyInterface?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityInteractionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnChangeColor.setOnClickListener {
            myInterface?.changecolor()
        }
    }

    fun changetext(){
        binding.btnChangeColor.setText("Changed through fragment")
    }
}
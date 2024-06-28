package com.o7services.kotlin5_6_online.jetpacck_naigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.o7services.kotlin5_6_online.R
import com.o7services.kotlin5_6_online.databinding.ActivityJetpackBinding

class JetpackActivity : AppCompatActivity() {
    lateinit var binding: ActivityJetpackBinding
    var navController:NavController?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityJetpackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController=findNavController(R.id.navController)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
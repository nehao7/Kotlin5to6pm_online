package com.o7services.kotlin5_6_online

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.kotlin5_6_online.activity_fragmnent_interaction.ActivityInteraction
import com.o7services.kotlin5_6_online.databinding.ActivityMainBinding
import com.o7services.kotlin5_6_online.jetpacck_naigation.JetpackActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnConstraint.setOnClickListener {
            startActivity(Intent(this,ConstraintActivity::class.java))
        }

        binding.btnAlertDialog.setOnClickListener {
            startActivity(Intent(this,AlertDialog::class.java))
        }
        binding.btnActivityLifecyle.setOnClickListener {
            startActivity(Intent(this,ActivityLifecycle::class.java))
        }
        binding.btnInterfaceInteraction.setOnClickListener {
            startActivity(Intent(this,ActivityInteraction::class.java))
        }
        binding.btnJetPack.setOnClickListener {
            startActivity(Intent(this,JetpackActivity::class.java))
        }
    }
}
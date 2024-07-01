package com.o7services.kotlin5_6_online.jetpacck_naigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.o7services.kotlin5_6_online.R
import com.o7services.kotlin5_6_online.activity_fragmnent_interaction.ActivityInteraction
import com.o7services.kotlin5_6_online.databinding.ActivityJetpackBinding

class JetpackActivity : AppCompatActivity() {
    lateinit var binding: ActivityJetpackBinding
    var navController:NavController?=null
    lateinit var jetpackActivity: JetpackActivity
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_layout,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.item_toast->{
                Toast.makeText(this, "this is menu toast", Toast.LENGTH_SHORT).show()
            }
            R.id.item_snackbar->binding.root.let{
                Snackbar.make(it,"this is menu snackbar", Snackbar.LENGTH_SHORT).show()
            }

        }
        return super.onOptionsItemSelected(item)

    }
}
package com.o7services.kotlin5_6_online

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.o7services.kotlin5_6_online.databinding.ActivityAlertDialogBinding

class AlertDialog : AppCompatActivity() {
    lateinit var binding:ActivityAlertDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener {
            Snackbar.make(it,"This is a simple Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Undo",{
                    Toast.makeText(this, "Toast is invoked from snackbar",
                        Toast.LENGTH_SHORT).show()
                })
                .show()
        }
        binding.btnDialog.setOnClickListener {

            AlertDialog.Builder(this).apply {
                setTitle("This is Alert Dialog")
                setNegativeButton("No") { _, _ ->

                }
                setPositiveButton("yes") { _, _ -> }
                setCancelable(false)
                show()
            }
        }

    }
}
package com.o7services.kotlin5_6_online

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.o7services.kotlin5_6_online.databinding.ActivityAlertDialogBinding

class AlertDialog : AppCompatActivity() {
    lateinit var binding:ActivityAlertDialogBinding
    val animals = arrayOf("Horse", "Cow", "Camel", "Sheep", "Goat")
    val checkedItems = booleanArrayOf(true, false, false, true, false,true)

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

        binding.button.setOnClickListener {  }
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

        binding.btnSingleChoice.setOnClickListener {
            AlertDialog.Builder(this)
                .apply {
                    setTitle("")
                    setItems(animals) { _,which ->
                        Toast.makeText(this@AlertDialog, animals[which].toString(), Toast.LENGTH_LONG).show()
                    }
                    setPositiveButton("Yes") { _, _ ->
                        Toast.makeText(this@AlertDialog, "PositiveButton", Toast.LENGTH_LONG).show()
                    }
                    setNegativeButton("No") { _, _ ->
                        Toast.makeText(this@AlertDialog, "NegativeButton", Toast.LENGTH_LONG).show()
                    }
                    setNeutralButton("Cancel") { _, _ ->
                        Toast.makeText(this@AlertDialog, "NeutralButton", Toast.LENGTH_LONG).show()
                    }
                    setCancelable(false)
                    show()
                }
        }

        binding.btnMultipleChoice.setOnClickListener {
            AlertDialog.Builder(this)
                .apply {
                    setTitle("Multiple Choice")
                    setMultiChoiceItems(animals,checkedItems) { _,which,isChecked ->
                        checkedItems.set(which, isChecked)
                        Toast.makeText(this@AlertDialog, animals[which].toString(), Toast.LENGTH_LONG).show()
                    }
                    setPositiveButton("Yes") { _, _ ->
                        Toast.makeText(this@AlertDialog, "PositiveButton", Toast.LENGTH_LONG).show()
                    }
                    setNegativeButton("No") { _, _ ->
                        Toast.makeText(this@AlertDialog, "NegativeButton", Toast.LENGTH_LONG).show()
                    }
                    setNeutralButton("Cancel") { _, _ ->
                        Toast.makeText(this@AlertDialog,"NeutralButton", Toast.LENGTH_LONG).show()
                    }
                    setCancelable(false)
                    show()
                }
        }

        binding.btnCustomDialog.setOnClickListener {
            var dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog_layout, null)
            var dialog = Dialog(this)
            dialog.setContentView(dialogView)
            var btnCancel = dialogView.findViewById<Button>(R.id.btnCancel)
            var btnOk = dialogView.findViewById<Button>(R.id.btnOk)
            var etText = dialogView.findViewById<EditText>(R.id.etText)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            dialog.setCancelable(false)
            btnCancel.setOnClickListener {
                dialog.dismiss()
            }
            btnOk.setOnClickListener {
                if (etText.text.isNullOrEmpty()) {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.enter_value),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(this, etText.text.toString(), Toast.LENGTH_LONG)
                        .show()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }

    }
}
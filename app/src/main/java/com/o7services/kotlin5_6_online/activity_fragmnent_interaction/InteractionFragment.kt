package com.o7services.kotlin5_6_online.activity_fragmnent_interaction

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.o7services.kotlin5_6_online.R
import com.o7services.kotlin5_6_online.databinding.FragmentInteractionBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * A simple [Fragment] subclass.
 * Use the [InteractionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InteractionFragment : Fragment(), MyInterface {
    lateinit var binding: FragmentInteractionBinding
    lateinit var activityInteraction: ActivityInteraction
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var dateFormat=SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

        activityInteraction= activity as ActivityInteraction
        activityInteraction.myInterface=this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentInteractionBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnchgText.setOnClickListener {
            activityInteraction.changetext()
        }
        binding.btnDatePicker.setOnClickListener {
            DatePickerDialog(requireContext(),{_,year,month,dateofMonth->
                val calendar=Calendar.getInstance()
                calendar.set(year,month,dateofMonth)
                Log.e("Date", "onViewCreated:$year $month $dateofMonth ")
                var date=dateFormat.format(calendar.time)
                binding.btnDatePicker.setText(date)
            },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }



    override fun changecolor() {
      binding.llfragment.setBackgroundColor(
          ContextCompat.getColor(requireContext(), R.color.green)
      )
    }
}
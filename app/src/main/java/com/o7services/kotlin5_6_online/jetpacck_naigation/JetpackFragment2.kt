package com.o7services.kotlin5_6_online.jetpacck_naigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.o7services.kotlin5_6_online.R
import com.o7services.kotlin5_6_online.databinding.FragmentJetpack2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JetpackFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class JetpackFragment2 : Fragment() {
    lateinit var binding:FragmentJetpack2Binding
    // TODO: Rename and change types of parameters
    var value=""
    var name=""
    private val TAG = "JetpackFragment2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           value=it.getString("value","")
            name=it.getString("name","")
        }

        Log.e(TAG, "onCreate: $value $name" )

        Toast.makeText(requireContext(), "$value $name", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentJetpack2Binding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnmove.setOnClickListener {
            findNavController().navigate(R.id.action_jetpackFragment2_to_jetpackFragment33)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment JetpackFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JetpackFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
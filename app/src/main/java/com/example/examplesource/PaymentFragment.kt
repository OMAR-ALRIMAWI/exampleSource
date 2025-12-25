package com.example.examplesource

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examplesource.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {
    private lateinit var binding: FragmentPaymentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initListener()
    }

    private fun initListener() {
        binding.btnAddCard.setOnClickListener {
            if (isValidation())
                findNavController().navigate(R.id.infoFragment)
        }
    }

    private fun isValidation(): Boolean {
        var isVal = false
        if (binding.edtCard.length() != 16) {
            binding.tilCard.error = "Invalid card number"
            isVal = false
        } else {
            binding.tilCard.error = null
            isVal = true
        }
        if (binding.cvcEdittext.length() != 3) {
            binding.cvcLayout.error = "Invalid CVC"
            isVal = false
        } else {
            binding.cvcLayout.error = "Invalid CVC"
            isVal = true
        }
        return isVal
    }
}


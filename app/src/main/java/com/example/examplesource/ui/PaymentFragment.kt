package com.example.examplesource.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examplesource.R
import com.example.examplesource.databinding.FragmentPaymentBinding
import com.example.examplesource.domin.UserInfo

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
            if (isValidation()) {
                val cardNumber = binding.edtCard.text
                val cvc = binding.cvcEdittext.text
                val date = binding.dateText.text
                val userInfo = UserInfo(cardNumber.toString(), cvc.toString(),date.toString())
              val bundle= bundleOf().apply {
                  putParcelable("UserInfo",userInfo)
              }
                findNavController().navigate(R.id.infoFragment,bundle)
            }
        }
    }

    private fun isValidation(): Boolean {
        // prepare regex for date
        val data=binding.dateText.text
        val regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$".toRegex()
        var isVal = true
        if (binding.edtCard.length() != 16) {
            binding.tilCard.error = "Invalid card number"
            isVal = false
        } else {
            binding.tilCard.error = null
        }
        if (binding.cvcEdittext.length() != 3) {
            binding.cvcLayout.error = "Invalid CVC"
            isVal = false
        } else {
            binding.cvcLayout.error = null
        }
        if (!regex.matches(data.toString())){
            binding.tilExpiry.error="invalid date!"
            isVal = false
        }else{
            binding.tilCard.error=null
        }
        return isVal
    }
}
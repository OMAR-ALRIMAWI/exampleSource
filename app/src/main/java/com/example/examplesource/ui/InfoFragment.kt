package com.example.examplesource.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examplesource.databinding.FragmentInfoBinding
import com.example.examplesource.domin.UserInfo

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getData()
    }

    private fun getData() {
        val userInfo=arguments?.getParcelable<UserInfo>("UserInfo")
        binding.info= userInfo
    }
}
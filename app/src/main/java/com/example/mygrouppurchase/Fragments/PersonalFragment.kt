package com.example.mygrouppurchase.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.FragmentPersonalBinding

class PersonalFragment : Fragment() { //'개인 설정' 프래그먼트

private lateinit var binding: FragmentPersonalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal, container, false)

        binding.homeTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_personalFragment_to_homeFragment)
        }
        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_personalFragment_to_postingFragment)
        }
        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_personalFragment_to_talkFragment)
        }
        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_personalFragment_to_promiseFragment)
        }

        return binding.root

    }


}
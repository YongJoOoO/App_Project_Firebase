package com.example.mygrouppurchase.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.FragmentPromiseBinding

class PromiseFragment : Fragment() { //'약속잡기' 프래그먼트

    private lateinit var binding: FragmentPromiseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView( //자동 호출 함수
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_promise, container, false)

        binding.homeTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_promiseFragment_to_homeFragment)
        }
        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_promiseFragment_to_postingFragment)
        }
        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_promiseFragment_to_talkFragment)
        }
        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_promiseFragment_to_personalFragment)
        }

        return binding.root
    }

}
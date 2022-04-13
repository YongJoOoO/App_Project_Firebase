package com.example.mygrouppurchase.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.FragmentPostingBinding


class PostingFragment : Fragment() {

    private lateinit var  binding: FragmentPostingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_posting, container, false)

        binding.homeTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_postingFragment_to_homeFragment)
        }
        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_postingFragment_to_talkFragment)
        }
        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_postingFragment_to_promiseFragment)
        }
        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_postingFragment_to_personalFragment)
        }

        return binding.root
    }


}
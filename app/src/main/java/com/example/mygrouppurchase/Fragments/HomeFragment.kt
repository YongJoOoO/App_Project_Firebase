package com.example.mygrouppurchase.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.FragmentHomeBinding

class HomeFragment : Fragment() { // '홈' 프래그먼트

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView( //프래그먼트 자동 호출 함수
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.category1.setOnClickListener {
            //ALL 버튼 클릭 시 home -> 게시글로 바로 전환되도록 이벤트 처리
            it.findNavController().navigate(R.id.action_homeFragment_to_postingFragment)
        }
        binding.category2.setOnClickListener {
            //배달 버튼 클릭 시 home -> 게시글 바로 전환 이벤트 처리
            it.findNavController().navigate(R.id.action_homeFragment_to_postingFragment)
        }
        binding.category3.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_postingFragment)
        }

        binding.tipTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_postingFragment)
        }
        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_talkFragment)
        }
        binding.bookmarkTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_promiseFragment)
        }
        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_personalFragment)
        }

        return binding.root
    }



}
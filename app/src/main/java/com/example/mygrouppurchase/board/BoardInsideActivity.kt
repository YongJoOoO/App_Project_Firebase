package com.example.mygrouppurchase.board

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mygrouppurchase.MainActivity
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.ActivityBoardInsideBinding

class BoardInsideActivity : AppCompatActivity() { //글 목록 리스트 클릭 시 -> 내용물 액티비티

    private val TAG = BoardInsideActivity::class.java.simpleName

    private lateinit var binding :ActivityBoardInsideBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_board_inside)

        //레이아웃 xml 파일 속 데이터와 바인딩 처리
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_inside)

        //'뒤로가기' 버튼 클릭 시 이벤트 처리
       binding.backBtn.setOnClickListener {
           //프래그먼트로 이동처리 해주기
           val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)
       }

        //PostingFragment 에서 리스트 목록 전달해준 것 여기서 받기
        val title = intent.getStringExtra("title").toString()
        val content = intent.getStringExtra("content").toString()
        val time = intent.getStringExtra("time").toString()

        //xml 파일 속에 데이터 바인딩 처리하기
        binding.titleArea.text = title
        binding.textArea.text = content
        binding.timeArea.text = time

        Log.d(TAG, title)
        Log.d(TAG, content)
        Log.d(TAG, time)

    }
}
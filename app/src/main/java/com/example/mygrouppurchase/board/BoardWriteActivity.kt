package com.example.mygrouppurchase.board

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mygrouppurchase.MainActivity
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.ActivityBoardWriteBinding

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardWriteBinding

    private val TAG = BoardWriteActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)

        //뒤로가기 버튼 클릭 시 이벤트 처리
        findViewById<ImageView>(R.id.backBtn).setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //writeBtn 버튼 클릭 시 값을 string으로 얻어오기
        binding.writeBtn.setOnClickListener {
            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()

            Log.d(TAG, title)
            Log.d(TAG, content)
        }

    }
}
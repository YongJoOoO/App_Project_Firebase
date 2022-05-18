package com.example.mygrouppurchase.board

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mygrouppurchase.MainActivity
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.ActivityBoardWriteBinding
import com.example.mygrouppurchase.utils.FBAuth
import com.example.mygrouppurchase.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardWriteBinding

    private val TAG = BoardWriteActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)

        //뒤로가기 버튼 클릭 시 이벤트 처리
        findViewById<ImageView>(R.id.backBtn).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //writeBtn 버튼 클릭 시, 사용자 입력값 얻어오기
        binding.writeBtn.setOnClickListener {

            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()

            Log.d(TAG, title)
            Log.d(TAG, content)

            //-> RealTime DB에 게시글 속 내용 push()
            val key = FBRef.boardRef.push().key.toString()

            FBRef.boardRef
                .child(key)
                .setValue(BoardModel(title, content, uid, time))

            Toast.makeText(this, "게시글 입력 완료", Toast.LENGTH_LONG).show()

            finish()

        }
    }

}
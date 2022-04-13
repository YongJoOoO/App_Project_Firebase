package com.example.mygrouppurchase.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mygrouppurchase.MainActivity
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.ActivityIntroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class IntroActivity : AppCompatActivity() { //'인트로' Activity
    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) { //실행()
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this,R.layout.activity_intro )

        binding.loginBtn.setOnClickListener { //로그인 버튼 이벤트 처리
            var intent = Intent(this, LoginActivity::class.java) //로그인 Acrivity 전환
            startActivity(intent)
        }

        binding.joinBtn.setOnClickListener { //회원가입 버튼 이벤트 처리
            var intent = Intent(this, JoinActivity::class.java) //회원가입 Activity 전환
            startActivity(intent)
        }
        binding.noAccountBtn.setOnClickListener {  //비회원 입장 버튼 이벤트 처리

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) { //성공 시
                        Toast.makeText(this, "비회원 입장 성공", Toast.LENGTH_LONG).show()

                        //메인 액티비티로 전환
                        val intent = Intent(this, MainActivity::class.java) // 메인 액티비티 연결
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP //뒤로가기 하면 이전 화면 날리기
                        startActivity(intent)

                    } else { //실패 시
                        Toast.makeText(this, "비회원 입장 실패", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
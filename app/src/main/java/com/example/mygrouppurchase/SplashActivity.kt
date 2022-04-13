package com.example.mygrouppurchase

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mygrouppurchase.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SplashActivity : AppCompatActivity() {  // '로고' 화면

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        // -> 기존 로그인 후 로그아웃 X 사용자에 한해서 로그인 유지 시켜줌
        if(auth.currentUser?.uid == null) { // 만약 현 사용자 uid 값 null이면
            Log.d("SpashActivity", "null")
            Handler().postDelayed({
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            }, 3000) //3초 후 'intro' 액티비티 화면으로 전환

        }else { //만약 현 사용자 uid 값 존재해서 not null이면
            Log.d("SplashAcitivity", "not null")

            Handler().postDelayed({
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            }, 3000) //3초 후 바로 '메인' 액티비티 화면으로 전환
        }

    }
}
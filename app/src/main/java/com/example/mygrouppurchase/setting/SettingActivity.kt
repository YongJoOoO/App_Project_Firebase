package com.example.mygrouppurchase.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mygrouppurchase.MainActivity
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SettingActivity : AppCompatActivity() { //'설정' Activity

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        auth = Firebase.auth

        //로그아웃 버튼 클릭 시 이벤트 처리
        val logoutBtn : Button = findViewById(R.id.logoutBtn)
        logoutBtn.setOnClickListener {

            auth.signOut()   //로그아웃 처리

            Toast.makeText(this, "로그아웃", Toast.LENGTH_LONG).show()  //Toast 메시지 띄우기

            //화면 전환 시키기(->안트로)
            val intent = Intent(this, IntroActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }
        //뒤로가기 버튼 클릭 시 이벤트 처리
        findViewById<ImageView>(R.id.backBtn).setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
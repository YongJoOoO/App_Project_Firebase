package com.example.mygrouppurchase.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mygrouppurchase.MainActivity
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {  //'회원가입' Acrivity
    private lateinit var auth: FirebaseAuth //파이어베이스 Auth 선언

    private lateinit var binding : ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {  //실행()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join) // 이 액티비티에 대한 레이아웃 xml 연결

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

        //'회원가입' 버튼 클릭 이벤트 처리
        binding.joinBtn.setOnClickListener {
            var isGoToJoin = true

            //사용자 입력 text 문자열값 얻어오기
            var email = binding.emailArea.text.toString()
            var password1 = binding.passwordArea1.text.toString()
            var password2 = binding.passwordArea2.text.toString()

            //얻어온 사용자 입력칸 비어있을 경우 -> isGoToJoin = false 처리
            if(email.isEmpty()) { //만약 이메일 칸 비어져있다면
                //해당 토스트 메시지 띄우기
                Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(password1.isEmpty()) {
                Toast.makeText(this, "password1을 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(password2.isEmpty()){
                Toast.makeText(this, "password2을 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            //회원가입 시 확인용 비번 2개 서로 다른지 확인
            if(!password1.equals(password2)) { //회원가입 시 비번1 != 비번 2
                Toast.makeText(this, "입력한 비밀번호 값이 서로 다릅니다.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            //위의 제한 조건 모두 만족하여 '회원 가입' = true 값일 경우에 한해서
            if(isGoToJoin) {
                auth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) { //회원가입 성공 시

                            Toast.makeText(this, "가입 성공!", Toast.LENGTH_LONG).show()

                            val intent = Intent(this, MainActivity::class.java) // 메인 액티비티 연결
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP //뒤로가기 하면 이전 화면 날리기
                            startActivity(intent)

                        } else { //회원가입 실패 시

                            Toast.makeText(this, "가입 실패", Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }



    }
}
package kr.ac.hallym.phonebook_card

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phoneBtn = findViewById<Button>(R.id.phone_btn)
//        버튼이 눌렸을때
        phoneBtn.setOnClickListener {
//            ManualActivity와 연결
            val phoneintent = Intent(this, PhoneActivity::class.java)
            startActivity(phoneintent)
        }
    }
}
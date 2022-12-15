package kr.ac.hallym.random

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bnt1 = findViewById<Button>(R.id.button1)
        val bnt2 = findViewById<Button>(R.id.button2)
        val bnt3 = findViewById<Button>(R.id.button3)
        val bnt4 = findViewById<Button>(R.id.button4)
        val bnt5 = findViewById<Button>(R.id.button5)
        val bnt6 = findViewById<Button>(R.id.button6)
        val array = arrayOf(bnt1, bnt2, bnt3, bnt4, bnt5, bnt6)

        findViewById<FloatingActionButton>(R.id.runButton).setOnClickListener {
            val random = Random()
            val list = mutableListOf<Int>()
            while (list.size<6){
                val num = random.nextInt(45)+1 // 1부터 시작
                if (list.contains(num)){ // 같은 번호가 있다면 넘어가기
                    continue
                }
                list.add(num)
            }

            for (i in 0..5){
                array[i].text = list[i].toString();

                val red = random.nextInt(256);
                val green = random.nextInt(256);
                val blue = random.nextInt(256);
                array[i].backgroundTintList = ColorStateList.valueOf(Color.rgb(red, green, blue))
            }
        }
    }
}
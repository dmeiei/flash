package kr.ac.hallym.flash

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    var isFlash = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val torch = Torch(this)

        val flashBtn = findViewById<Button>(R.id.flash_btn)
        flashBtn.setOnClickListener {
            if(!isFlash){
                torch.flashOn()
                isFlash = true
            }else{
                torch.flashoff()
                isFlash = false
            }
        }
    }
}
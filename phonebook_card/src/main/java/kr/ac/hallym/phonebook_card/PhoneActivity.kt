package kr.ac.hallym.phonebook_card

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhoneActivity: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //activity_manual과 연결
        setContentView(R.layout.activity_phonebook)

        viewManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
        viewAdapter = Adapter()

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview_main).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }
}
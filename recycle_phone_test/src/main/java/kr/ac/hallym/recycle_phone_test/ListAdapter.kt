package kr.ac.hallym.recycle_phone_test

import android.database.Cursor
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.recycle_phone_test.databinding.ActivityItemListBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyView>() {
    val data = {

    }

    inner class MyView(private val binding: ActivityItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.layout01.setOnClickListener {
                if (binding.layoutDetail01.visibility == View.VISIBLE) {
                    binding.layoutDetail01.visibility = View.GONE
                    binding.layoutBtn01.animate().apply {
                        duration = 200
                        rotation(0f)
                    }
                } else {
                    binding.layoutDetail01.visibility = View.VISIBLE
                    binding.layoutBtn01.animate().apply {
                        duration = 200
                        rotation(180f)
                    }
                }
            }
        }

        fun bind(pos: Int) {
            binding.textView01.text = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            data.values.elementAt(pos).forEach {
                val view = TextView(binding.root.context).apply {
                    text = "· $it"
                    textSize = 20f
                    setPadding(10, 10, 5, 10)
                }
                binding.layoutDetail01.addView(view)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view =
            ActivityItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
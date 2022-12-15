package kr.ac.hallym.phonebook_card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(): RecyclerView.Adapter<Adapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var itemimage: ImageView = itemView.findViewById(R.id.item_image)
        public var itemtitle: TextView = itemView.findViewById(R.id.item_title)
        public var itemdetail: TextView = itemView.findViewById(R.id.item_detail)
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): Adapter.MyViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_card, parent, false)

        return MyViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
        holder.itemimage.setImageResource(R.drawable.ic_launcher_background)
        holder.itemtitle.setText("타이틀입니다")
        holder.itemdetail.setText("세부사항 입니다")
    }
    override fun getItemCount(): Int {
        return 5
    }
}
package picshare.guillaume.picshare.Adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.quevisiter.quevisiter.R
import com.quevisiter.quevisiter.common.models.SearchedPlace

class MainRecyclerView(private val myPlaces: List<SearchedPlace>) :
    RecyclerView.Adapter<MainRecyclerView.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardView = itemView.findViewById(R.id.card_view) as CardView
        val item_title = cardView.findViewById(R.id.item_main_title) as TextView
        val item_description = cardView.findViewById(R.id.item_main_description) as TextView

    }


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return ViewHolder(viewItem)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item_title.text= myPlaces[0].places[position].title
        holder.item_description.text = myPlaces[0].places[position].description
    }

    override fun getItemCount() = myPlaces.size
}
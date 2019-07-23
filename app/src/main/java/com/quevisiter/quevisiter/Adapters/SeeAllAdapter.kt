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
import com.quevisiter.quevisiter.common.models.Place
import com.quevisiter.quevisiter.common.models.SearchedPlace

class SeeAllAdapter(private val myPlaces: ArrayList<SearchedPlace>, val clickListener: (Place, Int) -> Unit) :
        RecyclerView.Adapter<SeeAllAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardView = itemView.findViewById(R.id.card_view_see_all) as CardView
        val itemTitle = cardView.findViewById(R.id.item_see_all_place_title) as TextView
        val itemDescription = cardView.findViewById(R.id.item_see_all_place_description) as TextView
        val itemCateg = cardView.findViewById(R.id.item_see_all_place_categ) as TextView

    }


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_see_all, parent, false)
        return ViewHolder(viewItem)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text= myPlaces[0].places[position].title
        holder.itemCateg.text= myPlaces[0].places[position].category.name
        holder.itemDescription.text = myPlaces[0].places[position].description
    }

    override fun getItemCount() = myPlaces.size
}
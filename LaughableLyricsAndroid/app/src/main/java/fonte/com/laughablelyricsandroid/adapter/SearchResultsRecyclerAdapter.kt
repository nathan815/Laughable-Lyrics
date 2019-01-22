package fonte.com.laughablelyricsandroid.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import fonte.com.laughablelyricsandroid.R
import fonte.com.laughablelyricsandroid.util.SearchResult

class SearchResultsRecyclerAdapter(private val searchResults: ArrayList<SearchResult>, private val context: Context, private val numBounces: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<SearchResultsRecyclerAdapter.ViewHolder>() {
    class ViewHolder(v: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(v) {
        val title: TextView = v.findViewById(R.id.search_result_text)
        val id: TextView = v.findViewById(R.id.search_result_id)
        val rowContainer: ConstraintLayout = v.findViewById(R.id.search_results_container)
        val artistImage: ImageView = v.findViewById(R.id.song_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsRecyclerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_search_results, parent, false))
    }

    override fun getItemCount(): Int = searchResults.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tempString =  "${searchResults[position].Title} by ${searchResults[position].Artist} "
        holder.title.text = tempString
        holder.id.text = searchResults[position].Id
        Glide.with(context).load(searchResults[position].ImageUrl).into(holder.artistImage)
        holder.rowContainer.setOnClickListener{
            val id: String = it.findViewById<TextView>(R.id.search_result_id).text.toString()
            val bundle: Bundle = bundleOf("songId" to id, "numBounces" to numBounces)
            Navigation.findNavController(it).navigate(R.id.lyricsFragment, bundle)
        }
    }
}
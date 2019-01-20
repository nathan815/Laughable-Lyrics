package fonte.com.laughablelyricsandroid.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import fonte.com.laughablelyricsandroid.R
import fonte.com.laughablelyricsandroid.util.SearchResult

class SearchResultsRecyclerAdapter(private val searchResults: ArrayList<SearchResult>) : androidx.recyclerview.widget.RecyclerView.Adapter<SearchResultsRecyclerAdapter.ViewHolder>() {
    class ViewHolder(v: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(v) {
        val title: TextView = v.findViewById(R.id.search_result_text)
        val id: TextView = v.findViewById(R.id.search_result_id)
        val rowContainer: ConstraintLayout = v.findViewById(R.id.search_results_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsRecyclerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_search_results, parent, false))
    }

    override fun getItemCount(): Int = searchResults.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tempString =  "${searchResults[position].Title} by ${searchResults[position].Artist} "
        holder.title.text = tempString
        holder.id.text = searchResults[position].Id
        holder.rowContainer.setOnClickListener{
            val id: String = it.findViewById<TextView>(R.id.search_result_id).text.toString()
            val bundle: Bundle = bundleOf("id" to id)
            Navigation.findNavController(it).navigate(R.id.lyricsFragment, bundle)
        }
    }
}
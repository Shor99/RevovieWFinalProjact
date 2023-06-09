package or.shani.revoviewfinalprojact.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import or.shani.revoviewfinalprojact.R
import or.shani.revoviewfinalprojact.data.models.TVShows
import or.shani.revoviewfinalprojact.databinding.TvshowItemBinding

class TVShowAdapter(private val tvShows: List<TVShows>) : RecyclerView.Adapter<TVShowAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            TvshowItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount() = tvShows.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val tvshow = tvShows[position]
        //asset to pass data between fragments
        val bundle = bundleOf(
            "title" to tvshow.originalName,
            "poster" to tvshow.posterUrl,
            "description" to tvshow.overview,
            "first_aired" to tvshow.firstAirDate,
            "language" to tvshow.originalLanguage

        )
        //set the image of the movie
        with(holder.binding) {
            Picasso.get()
                .load(tvshow.posterUrl)
                .into(imagePoster)
        }
        //navigate to another fragment and pass a bundle with data on click
        holder.itemView.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_nav_tv_shows_to_overViewFragment,bundle)
        }

    }

    class VH(val binding: TvshowItemBinding) : RecyclerView.ViewHolder(binding.root)
}
package or.shani.revoviewfinalprojact.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.squareup.picasso.Picasso
import or.shani.revoviewfinalprojact.R
import or.shani.revoviewfinalprojact.data.models.Movie
import or.shani.revoviewfinalprojact.databinding.MovieItemBinding


class MovieAdapter(private val movies: List<Movie>) : Adapter<MovieAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val movie = movies[position]
        //asset to pass data between fragments
        val bundle = bundleOf(
            "title" to movie.originalTitle,
            "poster" to movie.posterUrl,
            "description" to movie.overview,
            "first_aired" to movie.releaseDate,
            "language" to movie.originalLanguage
        )
        //set the image of the movie
        with(holder.binding) {
            Picasso.get()
                .load(movie.posterUrl)
                .into(imagePoster)
        }
        //navigate to another fragment and pass a bundle with data
        holder.itemView.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_moviesFragment_to_nav_over_view,bundle)
        }

    }

    class VH(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)
}
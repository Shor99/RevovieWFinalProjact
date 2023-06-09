package or.shani.revoviewfinalprojact.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import or.shani.revoviewfinalprojact.databinding.FragmentMoviesBinding
import or.shani.revoviewfinalprojact.ui.adapters.MovieAdapter

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(MoviesViewModel::class.java)


        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //set the popular movies recycler view
        homeViewModel.movies.observe(viewLifecycleOwner) {
            binding.recyclerPopularMovies.adapter = MovieAdapter(it.map { pm -> pm.movie })
        }
        //set the top rated movies recycler view
        homeViewModel.trMovies.observe(viewLifecycleOwner) {
            binding.recyclerTopRatedMovies.adapter = MovieAdapter(it.map { trm -> trm.movie })
        }
        //set the new movies recycler view
        homeViewModel.nMovies.observe(viewLifecycleOwner) {
            binding.recyclerNewMovies.adapter = MovieAdapter(it.map { nm -> nm.movie })
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
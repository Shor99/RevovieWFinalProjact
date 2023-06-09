package or.shani.revoviewfinalprojact.ui.soon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import or.shani.revoviewfinalprojact.databinding.FragmentSoonOutBinding
import or.shani.revoviewfinalprojact.ui.adapters.UpcomingMoviesAdapter
import or.shani.revoviewfinalprojact.ui.adapters.UpcomingTVShowAdapter

@AndroidEntryPoint
class SoonOutFragment : Fragment() {

    private var _binding: FragmentSoonOutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val soonOutViewModel =
            ViewModelProvider(this).get(SoonOutViewModel::class.java)

        _binding = FragmentSoonOutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        soonOutViewModel.upcomingMovies.observe(viewLifecycleOwner) {
            binding.recyclerSoonMovies.adapter = UpcomingMoviesAdapter(it.map { um -> um.movie })
        }
        soonOutViewModel.upcomingTVShows.observe(viewLifecycleOwner) {
            binding.recyclerSoonShows.adapter = UpcomingTVShowAdapter(it.map { utv -> utv.tvShows })
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
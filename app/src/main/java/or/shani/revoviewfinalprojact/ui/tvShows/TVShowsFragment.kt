package or.shani.revoviewfinalprojact.ui.tvShows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import or.shani.revoviewfinalprojact.databinding.FragmentTVShowsBinding
import or.shani.revoviewfinalprojact.ui.adapters.TVShowAdapter

@AndroidEntryPoint
class TVShowsFragment : Fragment() {

    private var _binding: FragmentTVShowsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val TVShowViewModel =
            ViewModelProvider(this).get(TVShowsViewModel::class.java)

        _binding = FragmentTVShowsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //set the popular tv shows recycler view
        TVShowViewModel.tvShows.observe(viewLifecycleOwner) {
            binding.recyclerTvShows.adapter = TVShowAdapter(it.map { tv -> tv.tvShow })
        }
        //set the top rated tv shows recycler view
        TVShowViewModel.trTVShows.observe(viewLifecycleOwner) {
            binding.recyclerTopRatedShows.adapter = TVShowAdapter(it.map { trTV -> trTV.tvShow })
        }
        //set the new tv shows recycler view
        TVShowViewModel.nTVShows.observe(viewLifecycleOwner) {
            binding.recyclerNewTvShows.adapter = TVShowAdapter(it.map { nTV -> nTV.tvShow })
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
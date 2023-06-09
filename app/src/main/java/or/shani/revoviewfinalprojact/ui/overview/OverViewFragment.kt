package or.shani.revoviewfinalprojact.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import or.shani.revoviewfinalprojact.databinding.FragmentOverViewBinding

@AndroidEntryPoint
class OverViewFragment : Fragment() {
    private var _binding: FragmentOverViewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverViewBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var title = arguments?.getString("title")
        var poster = arguments?.getString("poster")
        var des = arguments?.getString("description")
        var firstAired = arguments?.getString("first_aired")
        var language = arguments?.getString("language")

        //show the over view on screen
        binding.movieTitle.text = title
        binding.description.text = des ?: "No overview yet"
        binding.rating.text = "Released date:\n$firstAired"
        binding.language.text = "Original language:\n$language"

        Picasso.get()
            .load(poster)
            .into(binding.poster)

        return root
    }
}
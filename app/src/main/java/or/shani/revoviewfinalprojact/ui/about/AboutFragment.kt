package or.shani.revoviewfinalprojact.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import or.shani.revoviewfinalprojact.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //about page title
        binding.aboutTitle.text = "Welcome to RevovieW"
        //about page content
        binding.aboutContent.text = "Here you can find overview about all the new and popular movies " +
                "and tv shows from all around the world"
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package kr.khs.studyfarm.mainpage.make_study

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentMakeStudyBinding

class MakeStudyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentMakeStudyBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_make_study, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = MakeStudyViewModelFactory(requireContext())

        val viewModel = ViewModelProvider(this, viewModelFactory).get(MakeStudyViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

}
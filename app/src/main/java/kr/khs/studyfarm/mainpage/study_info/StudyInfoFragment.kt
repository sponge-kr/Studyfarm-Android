package kr.khs.studyfarm.mainpage.study_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentStudyInfoBinding

class StudyInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentStudyInfoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_study_info, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = StudyInfoViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(StudyInfoViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }
}
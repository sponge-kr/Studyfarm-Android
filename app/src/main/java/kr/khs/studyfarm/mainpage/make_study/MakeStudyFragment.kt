package kr.khs.studyfarm.mainpage.make_study

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.khs.studyfarm.R
import kr.khs.studyfarm.createAlertDialog
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

        val viewModelFactory = MakeStudyViewModelFactory(
            requireContext(),
            MakeStudyFragmentArgs.fromBundle(requireArguments()).topics,
            MakeStudyFragmentArgs.fromBundle(requireArguments()).areas
        )

        val viewModel = ViewModelProvider(this, viewModelFactory).get(MakeStudyViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if(it != "") {
//                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                createAlertDialog(requireContext(), it, "알겠어요.")
                viewModel.doneToast()
            }
        })

        viewModel.isMakeStudySuccess.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(MakeStudyFragmentDirections.actionMakeStudyFragmentToMainPage())
                viewModel.doneMakeStudy()
            }
        })

        return binding.root
    }

}
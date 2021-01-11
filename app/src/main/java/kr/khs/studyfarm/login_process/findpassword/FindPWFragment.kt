package kr.khs.studyfarm.login_process.findpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentFindPwBinding

class FindPWFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentFindPwBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_find_pw, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = FindPWViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(FindPWViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }
}
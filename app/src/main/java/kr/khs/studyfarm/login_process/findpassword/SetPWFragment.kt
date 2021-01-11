package kr.khs.studyfarm.login_process.findpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentSetPwBinding

class SetPWFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSetPwBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_set_pw, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SetPWViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SetPWViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

}
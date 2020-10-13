package kr.khs.studyfarm.sign_up

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentSignupBinding
import kr.khs.studyfarm.network.ApiStatus

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignupBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signup, container, false
        )
        
        binding.lifecycleOwner = this
        
        val viewModelFactory = SignupViewModelFactory()
        
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SignupViewModel::class.java)
        
        binding.viewModel = viewModel

        viewModel.apiStatus.observe(viewLifecycleOwner, Observer {
            Log.d("SIGN_UP", when(it) {
                ApiStatus.LOADING -> "LOADING"
                ApiStatus.DONE -> "DONE"
                ApiStatus.ERROR -> "ERROR"
            }
            )
        })

        return binding.root
    }
}
package kr.khs.studyfarm.sign_email

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentSignEmailBinding
import kr.khs.studyfarm.getBackStackData

class SignEmailFragment : Fragment() {

    lateinit var viewModel : SignEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignEmailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sign_email, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SignEmailViewModelFactory()

        viewModel = ViewModelProvider(this, viewModelFactory).get(SignEmailViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.status.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(SignEmailFragmentDirections.actionSignEmailFragmentToSignPasswordFragment(it, viewModel.email.get()!!))
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            it.let {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        getBackStackData<String>("email") {
//            viewModel.email.set(it)
//        }
//    }
}
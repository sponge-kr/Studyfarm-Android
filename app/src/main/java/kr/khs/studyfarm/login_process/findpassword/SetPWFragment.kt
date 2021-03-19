package kr.khs.studyfarm.login_process.findpassword

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
import kr.khs.studyfarm.createAlertDialog
import kr.khs.studyfarm.databinding.FragmentSetPwBinding
import kr.khs.studyfarm.dialog
import kr.khs.studyfarm.network.ApiStatus

class SetPWFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSetPwBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_set_pw, container, false
        )

        binding.lifecycleOwner = this

        val email = SetPWFragmentArgs.fromBundle(requireArguments()).email

        val viewModelFactory = SetPWViewModelFactory(email)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SetPWViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if(it != "") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
//                createAlertDialog(requireContext(), it, "알겠어요.")
                viewModel.doneToast()
            }
        })

        viewModel.apiStatus.observe(viewLifecycleOwner, Observer {
            if(it == ApiStatus.LOADING) {
                dialog.onLoadingDialog(requireActivity())
            }
            else if(dialog.loadingDialog != null && dialog.loadingDialog!!.isShowing) {
                    dialog.offLoadingDialog()
            }
        })

        viewModel.successSetPW.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(SetPWFragmentDirections.actionSetPWFragmentToLoginFragment())
                viewModel.doneSuccessSetPW()
            }
        })

        return binding.root
    }

}
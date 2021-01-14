package kr.khs.studyfarm.login_process.findpassword

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
import kr.khs.studyfarm.databinding.FragmentFindPwBinding
import kr.khs.studyfarm.dialog
import kr.khs.studyfarm.login_process.login.LoginFragmentDirections
import kr.khs.studyfarm.network.ApiStatus

// TODO: 1/11/21 DEVELOP FIND PW PROCESS
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

        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if(it != "") {
//                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                createAlertDialog(requireContext(), it, "알겠어요.")
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

        viewModel.setPW.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(FindPWFragmentDirections.actionFindPWFragmentToSetPWFragment())
                viewModel.doneSetPW()
            }
        })

        return binding.root
    }
}
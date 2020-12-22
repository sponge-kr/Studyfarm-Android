package kr.khs.studyfarm.login_process.agreement_bottomsheet

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.BottomsheetAgreementBinding

class AgreementFragment : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : BottomsheetAgreementBinding = DataBindingUtil.inflate(
            inflater, R.layout.bottomsheet_agreement, container, false
        )

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.lifecycleOwner = this

        val viewModelFactory = AgreementViewModelFactory(
            requireContext(),
            AgreementFragmentArgs.fromBundle(requireArguments()).email,
            AgreementFragmentArgs.fromBundle(requireArguments()).password,
            AgreementFragmentArgs.fromBundle(requireArguments()).nickname
        )

        val viewModel = ViewModelProvider(this, viewModelFactory).get(AgreementViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if(it != "") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                viewModel.doneToast()
            }
        })

        viewModel.nextBtnClicked.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(AgreementFragmentDirections.actionAgreementFragmentToSignupAuthFragment(
                    AgreementFragmentArgs.fromBundle(requireArguments()).email,
                    viewModel.seq
                ))
                viewModel.doneNextBtnClicked()
            }
        })

        return binding.root
    }

}
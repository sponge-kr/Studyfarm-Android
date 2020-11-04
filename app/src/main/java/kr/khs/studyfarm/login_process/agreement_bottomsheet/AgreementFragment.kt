package kr.khs.studyfarm.login_process.agreement_bottomsheet

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
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

        val viewModelFactory = AgreementViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(AgreementViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

}
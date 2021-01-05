package kr.khs.studyfarm.mainpage.vp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentVpInterestingBinding
import kr.khs.studyfarm.login_process.sign_up_info.InfoData

// constructor 코드에 따라서 조회해서 recyclerview에 뿌리기, 0.0이면 전체
class InterestingVPFragment(private val studyCode : Double = 0.0) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentVpInterestingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_vp_interesting, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = InterestingVPViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(InterestingVPViewModel::class.java)

        binding.viewModel = viewModel

        val adapter = InterestingRVAdapter(StudyClickListener {  })

        binding.vpRv.apply {
            val layoutManager = LinearLayoutManager(requireContext())
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            this.layoutManager = layoutManager

            this.adapter = adapter
        }

        adapter.submitList(mutableListOf(
            InfoData(1, "1"),
            InfoData(2, "2"),
            InfoData(3, "3"),
        ))

        return binding.root
    }

}
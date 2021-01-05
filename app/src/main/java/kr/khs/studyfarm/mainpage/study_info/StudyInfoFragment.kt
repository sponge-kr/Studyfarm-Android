package kr.khs.studyfarm.mainpage.study_info

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentStudyInfoBinding
import kr.khs.studyfarm.mainpage.MainFragmentDirections

class StudyInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentStudyInfoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_study_info, container, false
        )

        setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        val viewModelFactory = StudyInfoViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(StudyInfoViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.study, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_share -> Toast.makeText(context, "공유하기", Toast.LENGTH_SHORT).show()
            R.id.action_study_notify -> Toast.makeText(context, "이 스터디 알림 설정", Toast.LENGTH_SHORT).show()
            R.id.action_study_withdraw -> Toast.makeText(context, "스터디 탈퇴", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
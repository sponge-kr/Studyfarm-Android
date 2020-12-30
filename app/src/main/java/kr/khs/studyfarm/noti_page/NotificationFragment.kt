package kr.khs.studyfarm.noti_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentNotificationBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_notification, container, false
        )

        binding.lifecycleOwner = this

        val viewmodelFactory = NotificationViewModelFactory()

        val viewModel = ViewModelProvider(this, viewmodelFactory).get(NotificationViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }
}
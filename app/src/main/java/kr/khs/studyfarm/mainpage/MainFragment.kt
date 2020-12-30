package kr.khs.studyfarm.mainpage

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentMainBinding
import kr.khs.studyfarm.view.MainActivity
import kr.khs.studyfarm.vp.VPAdapter

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )

        binding.lifecycleOwner = this

        (activity as MainActivity).supportActionBar?.apply {
            setLogo(R.drawable.sample_logo_black)
        }

        setHasOptionsMenu(true)

        val viewModelFactory = MainViewModelFactory(requireContext())

        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.viewModel = viewModel

        // viewpager 연결
        binding.mainVpInterested.adapter = VPAdapter(childFragmentManager)

        // viewpager - tab layout 연결
        binding.mainTab.setupWithViewPager(binding.mainVpInterested)

        binding.mainVpStudynoti.adapter = VPAdapter(childFragmentManager)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_user -> Toast.makeText(context, "유저 프로필", Toast.LENGTH_SHORT).show()
            R.id.action_notification -> findNavController().navigate(MainFragmentDirections.actionBottomHomeToNotificationFragment())
        }
        return super.onOptionsItemSelected(item)
    }
}
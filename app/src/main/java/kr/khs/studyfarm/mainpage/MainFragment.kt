package kr.khs.studyfarm.mainpage

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentMainBinding
import kr.khs.studyfarm.dialog
import kr.khs.studyfarm.mainpage.vp.InterestingVPAdapter
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.view.MainActivity

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

        val viewModelFactory = MainViewModelFactory(childFragmentManager, requireContext())

        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.viewModel = viewModel

        // viewpager 연결
//        binding.mainVpStudynoti.adapter = VPAdapter(childFragmentManager)

        // viewpager - tab layout 연결
//        val interestingAdapter = InterestingVPAdapter(childFragmentManager, listOf())
//        binding.mainVpInterested.adapter = interestingAdapter
//        binding.mainTab.setupWithViewPager(binding.mainVpInterested)
//
//        viewModel.interestings.observe(viewLifecycleOwner, {
//            if(it.isNotEmpty()) {
//                interestingAdapter.updateLists(it)
//            }
//        })

        viewModel.apiStatus.observe(viewLifecycleOwner, Observer {
            if(it == ApiStatus.LOADING) {
                dialog.onLoadingDialog(requireActivity())
            }
            else if(dialog.loadingDialog != null && dialog.loadingDialog!!.isShowing) {
                dialog.offLoadingDialog()
            }
        })

        viewModel.makeStudy.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(MainFragmentDirections.actionMainPageToMakeStudyFragment(
                    viewModel.user.interesting.toTypedArray(),
                    viewModel.user.userCityInfo.toTypedArray()
                ))
                viewModel.doneMakeStudy()
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_user -> findNavController().navigate(MainFragmentDirections.actionBottomHomeToProfileFragment())
            R.id.action_notification -> findNavController().navigate(MainFragmentDirections.actionBottomHomeToNotificationFragment())
        }
        return super.onOptionsItemSelected(item)
    }
}
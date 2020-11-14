package kr.khs.studyfarm.login_process.select

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
import kr.khs.studyfarm.databinding.FragmentSelectBinding

class SelectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSelectBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_select, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SelectViewModelFactory(SelectFragmentArgs.fromBundle(requireArguments()).cities)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SelectViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.returnSignup.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(SelectFragmentDirections.actionSelectFragmentToSignupInfoFragment(
                    SelectFragmentArgs.fromBundle(requireArguments()).email,
                    SelectFragmentArgs.fromBundle(requireArguments()).password,
                    SelectFragmentArgs.fromBundle(requireArguments()).nickname,
                    viewModel.selectCity,
                    null
                ))
                viewModel.doneSignup()
            }
        })

        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if(it != "") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                viewModel.doneToast()
            }
        })

        val stateAdapter = SelectAdapter(StateClickListener {
            viewModel.onStateSelect(it)
        })
        val cityAdapter = SelectAdapter(StateClickListener {
            viewModel.onCitySelect(it)
        })

        binding.selectRvFirst.adapter = stateAdapter
        binding.selectRvSecond.adapter = cityAdapter

        viewModel.stateList.observe(viewLifecycleOwner, Observer {
            stateAdapter.submitList(it)
        })

        viewModel.cityList.observe(viewLifecycleOwner, Observer {
            cityAdapter.submitList(it)
        })

        return binding.root
    }
}
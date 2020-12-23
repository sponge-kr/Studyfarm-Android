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

        //false : city, true : interested
        val cityOrInterested = SelectFragmentArgs.fromBundle(requireArguments()).cityOrInterested

        binding.lifecycleOwner = this

        val viewModelFactory = SelectViewModelFactory(
            requireContext(),
            cityOrInterested,
            if(cityOrInterested)
                SelectFragmentArgs.fromBundle(requireArguments()).interested
            else
                SelectFragmentArgs.fromBundle(requireArguments()).cities
        )

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SelectViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.returnSignup.observe(viewLifecycleOwner, Observer {
            if(it) {
                println(viewModel.selectData)
                findNavController().navigate(SelectFragmentDirections.actionSelectFragmentToSignupInfoFragment(
                    SelectFragmentArgs.fromBundle(requireArguments()).seq,
                    if(!cityOrInterested) viewModel.selectData else SelectFragmentArgs.fromBundle(requireArguments()).cities,
                    if(cityOrInterested) viewModel.selectData else SelectFragmentArgs.fromBundle(requireArguments()).interested
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
            viewModel.onParentSelect(it)
        })
        val cityAdapter = SelectAdapter(StateClickListener {
            viewModel.onChildrenSelect(it)
        })

        binding.selectRvFirst.adapter = stateAdapter
        binding.selectRvSecond.adapter = cityAdapter

        viewModel.parentList.observe(viewLifecycleOwner, Observer {
            stateAdapter.submitList(it)
        })

        viewModel.childrenList.observe(viewLifecycleOwner, Observer {
            cityAdapter.submitList(it)
        })

        return binding.root
    }
}
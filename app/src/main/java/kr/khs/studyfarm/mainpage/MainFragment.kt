package kr.khs.studyfarm.mainpage

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.toolbar.view.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentMainBinding
import kr.khs.studyfarm.view.MainActivity

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )

        (activity as MainActivity).supportActionBar?.apply {
            setLogo(R.drawable.sample_logo_black)
        }

        setHasOptionsMenu(true)

        val viewModelFactory = MainViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_user -> Toast.makeText(context, "유저 프로필", Toast.LENGTH_SHORT).show()
            R.id.action_notification -> Toast.makeText(context, "알림", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
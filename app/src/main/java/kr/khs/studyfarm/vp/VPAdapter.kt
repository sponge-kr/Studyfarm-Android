package kr.khs.studyfarm.vp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class VPAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val items : ArrayList<Fragment> = ArrayList()
    private val titles : ArrayList<String> = ArrayList()

    init {
        items.add(VP1Fragment())
        items.add(VP1Fragment())
        items.add(VP1Fragment())

        titles.add("타이틀1")
        titles.add("타이틀2")
        titles.add("타이틀3")
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

}
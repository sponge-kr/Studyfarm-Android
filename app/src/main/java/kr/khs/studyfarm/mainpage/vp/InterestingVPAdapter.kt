package kr.khs.studyfarm.mainpage.vp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kr.khs.studyfarm.network.response.UserInterestingInfo

class InterestingVPAdapter(fm : FragmentManager, _interestings : List<UserInterestingInfo>) : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val items : ArrayList<Fragment> = ArrayList()
    private val interesting = ArrayList<UserInterestingInfo>()

    init {
        items.add(InterestingVPFragment())

        interesting.add(UserInterestingInfo(name = "전체"))
    }

    fun updateLists(list : List<UserInterestingInfo>) {
        for(item in list) {
            if(!interesting.contains(item)) {
                interesting.add(item)
                items.add(InterestingVPFragment())
            }
        }
        this.notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if(interesting.size == 0) "" else interesting[position].name
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

}
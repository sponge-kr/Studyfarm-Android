package kr.khs.studyfarm.mainpage.vp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.khs.studyfarm.databinding.ListItemInterestingstudyBinding
import kr.khs.studyfarm.databinding.ListItemSelectBinding
import kr.khs.studyfarm.login_process.sign_up_info.InfoData

class InterestingRVAdapter(val clickListener : StudyClickListener) : ListAdapter<InfoData, RecyclerView.ViewHolder>(StudyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ViewHolder -> holder.bind(getItem(position) as InfoData, clickListener)
        }
    }

    class ViewHolder private constructor(val binding : ListItemInterestingstudyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InfoData, clickListener : StudyClickListener) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemInterestingstudyBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class StudyDiffCallback : DiffUtil.ItemCallback<InfoData>() {
    override fun areItemsTheSame(oldItem: InfoData, newItem: InfoData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: InfoData, newItem: InfoData): Boolean {
        return oldItem == newItem
    }
}

class StudyClickListener(val clickListener : (data : InfoData) -> Unit) {
    fun onClick(data : InfoData) = clickListener(data)
}
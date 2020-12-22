package kr.khs.studyfarm.login_process.select

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kr.khs.studyfarm.databinding.ListItemSelectBinding
import kr.khs.studyfarm.login_process.sign_up_info.StateData

class SelectAdapter(val clickListener : StateClickListener) : ListAdapter<StateData, RecyclerView.ViewHolder>(SelectDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ViewHolder -> holder.bind(getItem(position) as StateData, clickListener)
        }
    }

    class ViewHolder private constructor(val binding : ListItemSelectBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StateData, clickListener : StateClickListener) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSelectBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class SelectDiffCallback : DiffUtil.ItemCallback<StateData>() {
    override fun areItemsTheSame(oldItem: StateData, newItem: StateData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: StateData, newItem: StateData): Boolean {
        return oldItem == newItem
    }
}

class StateClickListener(val clickListener : (data : StateData) -> Unit) {
    fun onClick(data : StateData) = clickListener(data)
}
package kr.khs.studyfarm.login_process.agreement_bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kr.khs.studyfarm.databinding.ListItemAgreementBinding

class AgreementAdapter(private val agreementViewModel : AgreementViewModel) : ListAdapter<TermsData, AgreementAdapter.AgreementHolder>(TermsDataDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgreementHolder {
        return AgreementHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AgreementHolder, position: Int) {
        val item = getItem(position)

        holder.onBind(agreementViewModel,item)
    }

    class AgreementHolder(private val binding: ListItemAgreementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(viewModel: AgreementViewModel, item: TermsData) {
            binding.viewModel = viewModel
            binding.termsData = item
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): AgreementHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemAgreementBinding.inflate(layoutInflater, parent, false)
                return AgreementHolder(
                    binding
                )
            }
        }
    }
}

class TermsDataDiffCallback : DiffUtil.ItemCallback<TermsData>() {
    override fun areItemsTheSame(oldItem: TermsData, newItem: TermsData): Boolean {
        return oldItem.termsSequence == newItem.termsSequence
    }

    override fun areContentsTheSame(oldItem: TermsData, newItem: TermsData): Boolean {
        return oldItem == newItem
    }
}
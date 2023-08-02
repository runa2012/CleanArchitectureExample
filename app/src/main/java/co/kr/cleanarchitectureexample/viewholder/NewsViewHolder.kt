package co.kr.cleanarchitectureexample.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.kr.cleanarchitectureexample.databinding.ItemNewslistBinding
import co.kr.ex.domain.model.NewsDataEntity


class NewsViewHolder(private val binding : ItemNewslistBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind( item : NewsDataEntity   ){
        binding.itemTitle.text = item.title
        binding.itemDescription.text = item.description
    }

    companion object {

        fun creates( parent : ViewGroup) : NewsViewHolder {
            val binding = ItemNewslistBinding.inflate(LayoutInflater.from(parent.context) , parent , false )
            return NewsViewHolder(binding)
        }

    }


}
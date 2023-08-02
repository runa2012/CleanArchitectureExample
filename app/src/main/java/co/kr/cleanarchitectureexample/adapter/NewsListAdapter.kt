package co.kr.cleanarchitectureexample.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.kr.cleanarchitectureexample.viewholder.NewsViewHolder
import co.kr.ex.domain.model.NewsDataEntity
import kotlinx.coroutines.flow.StateFlow


class NewsListAdapter(
    private val array: StateFlow<List<NewsDataEntity>>,
    private val viewType: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when ( viewType ){
            1 -> {
                return NewsViewHolder.creates(parent )
            }
            else -> {
                throw Exception("")
            }
        }
    }

    override fun getItemCount() = array.value.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val data = array.value[position]

        when ( holder ){

            is NewsViewHolder -> {
                holder.bind( data )
            }
        }

    }

    override fun getItemViewType(position: Int): Int {

        when ( viewType ){

            1 -> {
                return 1
            }
            else -> {
                return 1
            }

        }
    }

}
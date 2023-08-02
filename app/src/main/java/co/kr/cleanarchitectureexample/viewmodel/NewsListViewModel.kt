package co.kr.cleanarchitectureexample.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import co.kr.cleanarchitectureexample.adapter.NewsListAdapter
import co.kr.cleanarchitectureexample.base.BaseViewModel
import co.kr.ex.domain.model.NewsDataEntity
import co.kr.ex.domain.model.NewsListDataEntity
import co.kr.ex.domain.usecase.NewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsListUseCase: NewsListUseCase
) : BaseViewModel() {

    private val _NewsList : MutableStateFlow<List<NewsDataEntity>> = MutableStateFlow(listOf())
    val newsList : StateFlow<List<NewsDataEntity>> = _NewsList

    val rankUserAdapter : NewsListAdapter by lazy { NewsListAdapter( newsList , 1  ) }

    fun getList( country : String ){

        val apiKey = "41b24f3f6d704cda81a7f9488a49f5da"
        viewModelScope.launch(IO) {
            newsListUseCase( country , apiKey ).onStart {
                Log.d(" Clean ex " , " Loding ")
            }.catch {
                Log.e(" Clean ex " , " error ")
            }.collect {
                if (it.status == "ok"){
                    _NewsList.emit(it.articles)
                }
            }
        }
    }

}
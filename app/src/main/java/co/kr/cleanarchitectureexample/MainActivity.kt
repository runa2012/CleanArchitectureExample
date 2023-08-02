package co.kr.cleanarchitectureexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import co.kr.cleanarchitectureexample.base.BaseActivity
import co.kr.cleanarchitectureexample.databinding.ActivityMainBinding
import co.kr.cleanarchitectureexample.viewmodel.NewsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, NewsListViewModel>(R.layout.activity_main) {

    override val viewModel: NewsListViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.newsList.adapter = viewModel.rankUserAdapter

        CoroutineScope(Main).launch {
            viewModel.newsList.collect{
                viewModel.rankUserAdapter.notifyDataSetChanged()
            }
        }

        viewModel.getList("kr")

    }
}
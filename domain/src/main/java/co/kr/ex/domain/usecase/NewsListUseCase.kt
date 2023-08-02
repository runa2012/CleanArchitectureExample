package co.kr.ex.domain.usecase

import co.kr.ex.domain.repository.NewsListRepository
import javax.inject.Inject

class NewsListUseCase @Inject constructor(
    private val newsListRepository : NewsListRepository
) {
    suspend operator fun invoke( country : String , apikey : String ) = newsListRepository.getList( country , apikey)
}
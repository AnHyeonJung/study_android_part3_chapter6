package fastcampus.part3.part3chapter6.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import fastcampus.part3.part3chapter6.model.ListItem
import fastcampus.part3.part3chapter6.remote.MainPagingSource
import fastcampus.part3.part3chapter6.remote.MainService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService //providesMainService MainServiceModule 로 감
) : MainRepository{
    override fun loadList() = Pager( //지금 빨간줄 뜨는 이유 => Flow를 사용 하기로했기때문  .flow 추가해야함
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            MainPagingSource(mainService)
        }
    ).flow
}
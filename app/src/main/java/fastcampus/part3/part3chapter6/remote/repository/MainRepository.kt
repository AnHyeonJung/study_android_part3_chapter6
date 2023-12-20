package fastcampus.part3.part3chapter6.remote.repository

import androidx.paging.PagingData
import fastcampus.part3.part3chapter6.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun loadList() : Flow<PagingData<ListItem>>
}
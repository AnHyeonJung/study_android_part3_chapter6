package fastcampus.part3.part3chapter6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import fastcampus.part3.part3chapter6.model.ListItem
import fastcampus.part3.part3chapter6.remote.repository.MainRepository
import fastcampus.part3.part3chapter6.remote.repository.MainRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _pagingData = MutableStateFlow<PagingData<ListItem>?>(null) //꼭 초기화를 해야함 flow는
    val pagingData: StateFlow<PagingData<ListItem>?> = _pagingData

    init {
        getList()
    }

    private fun getList(){
        viewModelScope.launch {
            mainRepository.loadList()
                .cachedIn(this)
                .collectLatest { list ->
                    _pagingData.value = list
                }
        }
    }
}
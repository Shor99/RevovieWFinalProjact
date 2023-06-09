package or.shani.revoviewfinalprojact.ui.tvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import or.shani.revoviewfinalprojact.data.dao.TVShowDao
import or.shani.revoviewfinalprojact.data.models.AllNewShowAndShow
import or.shani.revoviewfinalprojact.data.models.AllPopularShowAndShow
import or.shani.revoviewfinalprojact.data.models.TopRatedShowAndShow
import or.shani.revoviewfinalprojact.data.repository.TVShowsRepository
import javax.inject.Inject

@HiltViewModel
class TVShowsViewModel @Inject constructor(
    //injected props:
    tvShowDao: TVShowDao,
    tvShowRepository: TVShowsRepository

): ViewModel() {
    val tvShows: LiveData<List<AllPopularShowAndShow>> = tvShowDao.getAllPopularTvShows()
    val trTVShows: LiveData<List<TopRatedShowAndShow>> = tvShowDao.getTopRatedTvShows()
    val nTVShows: LiveData<List<AllNewShowAndShow>> = tvShowDao.getAllNewTvShows()

    init {
        viewModelScope.launch {
            tvShowRepository.refreshTVShows()
            tvShowRepository.refreshTopRatedTVShows()
            tvShowRepository.refreshNewTVShows()
        }
    }
}
package or.shani.revoviewfinalprojact.ui.soon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import or.shani.revoviewfinalprojact.data.dao.MovieDao
import or.shani.revoviewfinalprojact.data.dao.TVShowDao
import or.shani.revoviewfinalprojact.data.models.UpcomingMovieAndMovie
import or.shani.revoviewfinalprojact.data.models.UpcomingShowAndShow
import or.shani.revoviewfinalprojact.data.repository.MovieRepository
import or.shani.revoviewfinalprojact.data.repository.TVShowsRepository
import javax.inject.Inject


@HiltViewModel
class SoonOutViewModel @Inject constructor(
    //injected props:
    movieDao: MovieDao,
    tvShowDao: TVShowDao,
    movieRepository: MovieRepository,
    tvShowsRepository: TVShowsRepository
) : ViewModel() {
    val upcomingMovies: LiveData<List<UpcomingMovieAndMovie>> = movieDao.getAllUpcomingMovies()
    val upcomingTVShows: LiveData<List<UpcomingShowAndShow>> = tvShowDao.getAllUpcomingTvShows()
    init {
        viewModelScope.launch {
            movieRepository.refreshAllUpcomingMovies()
            tvShowsRepository.refreshAllUpcomingTVShows()
        }
    }
}
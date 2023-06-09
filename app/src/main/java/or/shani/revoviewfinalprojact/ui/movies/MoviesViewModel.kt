package or.shani.revoviewfinalprojact.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import or.shani.revoviewfinalprojact.data.dao.MovieDao
import or.shani.revoviewfinalprojact.data.models.AllNewMovieAndMovie
import or.shani.revoviewfinalprojact.data.models.AllPopularMovieAndMovie
import or.shani.revoviewfinalprojact.data.models.TopRatedMovieAndMovie
import or.shani.revoviewfinalprojact.data.repository.MovieRepository
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    //injected props:
    movieDao: MovieDao,
    movieRepository: MovieRepository

): ViewModel() {
    val movies: LiveData<List<AllPopularMovieAndMovie>> = movieDao.getAllPopularMovies()
    val trMovies: LiveData<List<TopRatedMovieAndMovie>> = movieDao.getAllTopRatedMovies()
    val nMovies: LiveData<List<AllNewMovieAndMovie>> = movieDao.getAllNewMovies()

    init {
        viewModelScope.launch {
            movieRepository.refreshAllMovies()
            movieRepository.refreshAllTopRatedMovies()
            movieRepository.refreshAllNewMovies()
        }
    }
}
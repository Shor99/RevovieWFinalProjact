package or.shani.revoviewfinalprojact.data.repository

import androidx.room.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import or.shani.revoviewfinalprojact.data.dao.MovieDao
import or.shani.revoviewfinalprojact.data.models.NewMovies
import or.shani.revoviewfinalprojact.data.models.PopularMovies
import or.shani.revoviewfinalprojact.data.models.TopRatedMovies
import or.shani.revoviewfinalprojact.data.models.UpcomingMovies
import or.shani.revoviewfinalprojact.data.service.MovieService
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDao: MovieDao,
    private val service: MovieService
) {
    @Transaction
    suspend fun refreshAllMovies() {
        withContext(Dispatchers.IO) {
            //fetch movies from API
            val movieRes = service.movies()
            val pop = movieRes.movies.map { m-> PopularMovies(m.movieId) }
            //save to local database
            movieDao.addMovies(movieRes.movies)
            movieDao.addAllPopularMovies(pop)
        }
    }
    @Transaction
    suspend fun refreshAllUpcomingMovies() {
        withContext(Dispatchers.IO) {
            //fetch movies from API
            val uMovieRes = service.upcomingMovies()
            val pop = uMovieRes.movies.map { um-> UpcomingMovies(um.movieId) }
            //save to local database
            movieDao.addMovies(uMovieRes.movies)
            movieDao.addAllUpcomingMovies(pop)
        }
    }
    @Transaction
    suspend fun refreshAllTopRatedMovies() {
        withContext(Dispatchers.IO) {
            //fetch movies from API
            val cMovieRes = service.topRatedMovies()
            val pop = cMovieRes.movies.map { cm-> TopRatedMovies(cm.movieId) }
            //save to local database
            movieDao.addMovies(cMovieRes.movies)
            movieDao.addAllTopRatedMovies(pop)
        }
    }

    @Transaction
    suspend fun refreshAllNewMovies() {
        withContext(Dispatchers.IO) {
            //fetch movies from API
            val nMovieRes = service.latestMovies()
            val pop = nMovieRes.movies.map { nm-> NewMovies(nm.movieId) }
            //save to local database
            movieDao.addMovies(nMovieRes.movies)
            movieDao.addAllNewMovies(pop)
        }
    }
}

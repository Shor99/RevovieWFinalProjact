package or.shani.revoviewfinalprojact.data.repository

import androidx.room.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import or.shani.revoviewfinalprojact.data.dao.TVShowDao
import or.shani.revoviewfinalprojact.data.models.NewTVShows
import or.shani.revoviewfinalprojact.data.models.PopularTVShows
import or.shani.revoviewfinalprojact.data.models.TopRatedTVShows
import or.shani.revoviewfinalprojact.data.models.UpcomingTVShows
import or.shani.revoviewfinalprojact.service.TVShowsService
import javax.inject.Inject

class TVShowsRepository  @Inject constructor(
    private val tvShowDao: TVShowDao,
    private val service: TVShowsService
) {
    @Transaction
    suspend fun refreshTVShows() {
        withContext(Dispatchers.IO) {
            //fetch TV shows from API
            val tvShowRes = service.tvShows()
            val pop = tvShowRes.tvshows.map { tv -> PopularTVShows(tv.showId ?: 0) }
            //save to local database
            tvShowDao.addTVShows(tvShowRes.tvshows)
            tvShowDao.addAllPopularTVShows(pop)
        }
    }
    @Transaction
    suspend fun refreshTopRatedTVShows() {
        withContext(Dispatchers.IO) {
            //fetch TV shows from API
            val trTVShowRes = service.topRatedTVShows()
            val pop = trTVShowRes.tvshows.map { trTV -> TopRatedTVShows(trTV.showId ?: 0) }
            //save to local database
            tvShowDao.addTVShows(trTVShowRes.tvshows)
            tvShowDao.addTopRatedTVShows(pop)
        }
    }
    @Transaction
    suspend fun refreshNewTVShows() {
        withContext(Dispatchers.IO) {
            //fetch TV shows from API
            val nTVShowRes = service.newTVShows()
            val pop = nTVShowRes.tvshows.map { nTV -> NewTVShows(nTV.showId ?: 0) }
            //save to local database
            tvShowDao.addTVShows(nTVShowRes.tvshows)
            tvShowDao.addAllNewTVShows(pop)
        }
    }

    @Transaction
    suspend fun refreshAllUpcomingTVShows() {
        withContext(Dispatchers.IO) {
            //fetch TV shows from API
            val uMovieRes = service.upcomingTVShows()
            val pop = uMovieRes.tvshows.map { utv-> UpcomingTVShows(utv.showId?:0) }
            //save to local database
            tvShowDao.addTVShows(uMovieRes.tvshows)
            tvShowDao.addAllUpcomingTVShows(pop)
        }
    }

}
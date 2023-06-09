package or.shani.revoviewfinalprojact.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import or.shani.revoviewfinalprojact.data.models.*

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(tvShows: TVShows)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTVShows(tvShow: List<TVShows>)

    //using live data
    @Query("SELECT * FROM TVShows")
    fun getTVShows(): LiveData<List<TVShows>>

    //popular TV Shows:
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllPopularTVShows(popularTVShows: List<PopularTVShows>)

    //using live data
    @Query("SELECT * FROM PopularTVShows")
    @Transaction
    fun getAllPopularTvShows(): LiveData<List<AllPopularShowAndShow>>

    //top rated TV Shows
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTopRatedTVShows(topRatedTVShows: List<TopRatedTVShows>)

    //using live data
    @Query("SELECT * FROM TopRatedTVShows")
    @Transaction
    fun getTopRatedTvShows(): LiveData<List<TopRatedShowAndShow>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllNewTVShows(newTVShows: List<NewTVShows>)

    //new TV shows
    @Query("SELECT * FROM NewTVShows")
    @Transaction
    fun getAllNewTvShows(): LiveData<List<AllNewShowAndShow>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllUpcomingTVShows(newTVShows: List<UpcomingTVShows>)

    //upcoming tv shows
    @Query("SELECT * FROM UpcomingTVShows")
    @Transaction
    fun getAllUpcomingTvShows(): LiveData<List<UpcomingShowAndShow>>

}
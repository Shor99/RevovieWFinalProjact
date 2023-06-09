package or.shani.revoviewfinalprojact.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import or.shani.revoviewfinalprojact.data.models.*

//working with the database
//room database technology
@Dao
interface MovieDao {

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun add(movie: Movie)

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun addMovies(movies: List<Movie>)

 //using live data
 @Query("SELECT * FROM Movie")
 fun getMovies(): LiveData<List<Movie>>

 //popular movies:
 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun addAllPopularMovies(popularMovies: List<PopularMovies>)

 //using live data
 @Query("SELECT * FROM PopularMovies")
 @Transaction
 fun getAllPopularMovies():LiveData<List<AllPopularMovieAndMovie>>

 //top rated movies:
 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun addAllTopRatedMovies(topRatedMovies: List<TopRatedMovies>)

 //using live data
 @Query("SELECT * FROM TopRatedMovies")
 @Transaction
 fun getAllTopRatedMovies():LiveData<List<TopRatedMovieAndMovie>>

 //new movies
 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun addAllNewMovies(newMovies: List<NewMovies>)

 //using live data
 @Query("SELECT * FROM NewMovies")
 @Transaction
 fun getAllNewMovies():LiveData<List<AllNewMovieAndMovie>>

 //upcoming movies
 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun addAllUpcomingMovies(upcomingMovies: List<UpcomingMovies>)

 //using live data
 @Query("SELECT * FROM UpcomingMovies")
 @Transaction
 fun getAllUpcomingMovies():LiveData<List<UpcomingMovieAndMovie>>

}
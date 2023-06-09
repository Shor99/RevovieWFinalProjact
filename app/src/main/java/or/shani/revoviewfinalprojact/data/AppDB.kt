package or.shani.revoviewfinalprojact.data

import androidx.room.Database
import androidx.room.RoomDatabase
import or.shani.revoviewfinalprojact.data.dao.MovieDao
import or.shani.revoviewfinalprojact.data.dao.TVShowDao
import or.shani.revoviewfinalprojact.data.models.Movie
import or.shani.revoviewfinalprojact.data.models.NewMovies
import or.shani.revoviewfinalprojact.data.models.NewTVShows
import or.shani.revoviewfinalprojact.data.models.PopularMovies
import or.shani.revoviewfinalprojact.data.models.PopularTVShows
import or.shani.revoviewfinalprojact.data.models.TVShows
import or.shani.revoviewfinalprojact.data.models.TopRatedMovies
import or.shani.revoviewfinalprojact.data.models.TopRatedTVShows
import or.shani.revoviewfinalprojact.data.models.UpcomingMovies
import or.shani.revoviewfinalprojact.data.models.UpcomingTVShows

//database version
private const val DB_VERSION = 2

//database
@Database(version = DB_VERSION, entities = [Movie::class, TVShows::class,PopularMovies::class,UpcomingMovies::class, TopRatedMovies::class ,NewMovies::class, PopularTVShows::class, TopRatedTVShows::class, NewTVShows::class, UpcomingTVShows::class])
abstract class AppDB: RoomDatabase() {
    //expose the dao
    abstract fun movieDao(): MovieDao
    abstract fun tvShowsDao(): TVShowDao
}
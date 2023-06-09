package or.shani.revoviewfinalprojact.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity
data class UpcomingMovies(@PrimaryKey val uMovieId: Int)

data class UpcomingMovieAndMovie(
    //SELECT * FROM Movie
    //JOIN UpcomingMovies ON Movie.movieId = UpcomingMovies.uMovieId
    @Embedded val upcomingMovies: UpcomingMovies,

    @Relation(
        parentColumn = "uMovieId",
        entityColumn = "movieId"
    )
    val movie:Movie,
)
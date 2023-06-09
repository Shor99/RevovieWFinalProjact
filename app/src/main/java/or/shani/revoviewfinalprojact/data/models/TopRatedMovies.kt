package or.shani.revoviewfinalprojact.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity
data class TopRatedMovies(@PrimaryKey val trMovieId: Int)

data class TopRatedMovieAndMovie(
    //SELECT * FROM Movie
    //JOIN TopRatedMovies ON Movie.movieId = TopRatedMovies.trMovieId
    @Embedded val topRatedMovies: TopRatedMovies,

    @Relation(
        parentColumn = "trMovieId",
        entityColumn = "movieId"
    )
    val movie:Movie,
)
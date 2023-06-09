package or.shani.revoviewfinalprojact.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class NewMovies(@PrimaryKey val nMovieId: Int)

data class AllNewMovieAndMovie(
    //SELECT * FROM Movie
    //JOIN NewMovies ON Movie.movieId = NewMovies.nMovieId
    @Embedded val newMovies: NewMovies,

    @Relation(
        parentColumn = "nMovieId",
        entityColumn = "movieId"
    )
    val movie:Movie,
)
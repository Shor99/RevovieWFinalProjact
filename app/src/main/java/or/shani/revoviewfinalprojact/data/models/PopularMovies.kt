package or.shani.revoviewfinalprojact.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class PopularMovies(@PrimaryKey val pMovieId: Int)

//SELECT * FROM Movie
//JOIN PopularMovies ON Movie.movieId = PopularMovies.pMovieId
data class AllPopularMovieAndMovie(

    @Embedded val popularMovies: PopularMovies,

    @Relation(
        parentColumn = "pMovieId",
        entityColumn = "movieId"
    )
    val movie:Movie,
)
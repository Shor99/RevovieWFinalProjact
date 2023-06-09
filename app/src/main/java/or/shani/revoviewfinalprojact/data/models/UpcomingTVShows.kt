package or.shani.revoviewfinalprojact.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class UpcomingTVShows(@PrimaryKey val uShowId: Int)

data class UpcomingShowAndShow(
    //SELECT * FROM TVShows
    //JOIN UpcomingTVShows ON TVShows.showId = UpcomingMovies.uShowId
    @Embedded val upcomingTVShows: UpcomingTVShows,

    @Relation(
        parentColumn = "uShowId",
        entityColumn = "showId"
    )
    val tvShows: TVShows,
)
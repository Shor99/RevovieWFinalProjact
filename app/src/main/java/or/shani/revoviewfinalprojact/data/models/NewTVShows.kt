package or.shani.revoviewfinalprojact.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class NewTVShows(@PrimaryKey val nShowId: Int)

data class AllNewShowAndShow(
    //SELECT * FROM TVShows
    //JOIN NewTVShows ON TVShows.showId = NewMovies.nShowId
    @Embedded val newTVShows: NewTVShows,

    @Relation(
        parentColumn = "nShowId",
        entityColumn = "showId"
    )
    val tvShow: TVShows,
)
package or.shani.revoviewfinalprojact.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class TopRatedTVShows(@PrimaryKey val trShowId: Int)

data class TopRatedShowAndShow(
    //SELECT * FROM TVShows
    //JOIN TopRatedTVShows ON TVShows.showId = TopRatedTvShows.trShowId
    @Embedded val topRatedTVShows: TopRatedTVShows,

    @Relation(
        parentColumn = "trShowId",
        entityColumn = "showId"
    )
    val tvShow: TVShows,
)
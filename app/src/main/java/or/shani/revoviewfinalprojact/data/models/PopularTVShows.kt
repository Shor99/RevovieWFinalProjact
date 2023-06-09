package or.shani.revoviewfinalprojact.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class PopularTVShows(@PrimaryKey val pShowId: Int)

data class AllPopularShowAndShow(

    //SELECT * FROM TV Shows
    //JOIN PopularTVShows ON TVShows.showId = PopularTVShows.pShowId
    @Embedded val popularTVShows: PopularTVShows,

    @Relation(
        parentColumn = "pShowId",
        entityColumn = "showId"
    )
    val tvShow: TVShows,
)
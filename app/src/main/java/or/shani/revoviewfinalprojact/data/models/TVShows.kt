package or.shani.revoviewfinalprojact.data.models


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//Represent a place to save to the database
@Entity
data class TVShows(
    @PrimaryKey
    @SerializedName("id")
    val showId: Int?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    val name: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) {

    val backdropUrl
        get() = if (backdropPath != null) "https://image.tmdb.org/t/p/w300${backdropPath}"
        else "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png"

    val posterUrl
        get() = if (posterPath != null) "https://image.tmdb.org/t/p/w342${posterPath}"
        else "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png"

    //Relationship:
    //removed from the constructor
    @Ignore //room should ignore this field
    @SerializedName("genre_ids")
    val genreIds: List<Int> = mutableListOf()
}
package or.shani.revoviewfinalprojact.data.models


import com.google.gson.annotations.SerializedName

data class TVShowResponse(
    val page: Int,
    @SerializedName("results")
    val tvshows: List<TVShows>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
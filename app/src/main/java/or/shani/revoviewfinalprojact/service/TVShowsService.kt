package or.shani.revoviewfinalprojact.service


import or.shani.revoviewfinalprojact.data.models.TVShowResponse
import retrofit2.http.GET
//save in local database
interface TVShowsService {
    @GET("3/tv/popular?language=en-US")
    suspend fun tvShows(): TVShowResponse

    @GET("3/tv/top_rated?language=en-US")
    suspend fun topRatedTVShows(): TVShowResponse

    @GET("3/tv/on_the_air?language=en-US")
    suspend fun newTVShows(): TVShowResponse

    @GET("3/tv/on_the_air?language=en-US")
    suspend fun upcomingTVShows(): TVShowResponse
}
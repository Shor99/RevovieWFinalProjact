package or.shani.revoviewfinalprojact.data.service

import or.shani.revoviewfinalprojact.data.models.MovieResponse
import retrofit2.http.GET

//save in local database
interface MovieService {
    @GET("3/movie/popular")
    suspend fun movies(): MovieResponse

    @GET("3/movie/top_rated")
    suspend fun topRatedMovies(): MovieResponse

    @GET("3/movie/now_playing")
    suspend fun latestMovies(): MovieResponse

    @GET("3/movie/upcoming")
    suspend fun upcomingMovies(): MovieResponse

}
package or.shani.revoviewfinalprojact.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import or.shani.revoviewfinalprojact.BuildConfig
import or.shani.revoviewfinalprojact.data.AppDB
import or.shani.revoviewfinalprojact.data.service.MovieService
import or.shani.revoviewfinalprojact.service.TVShowsService
import or.shani.revoviewfinalprojact.service.TokenInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
//use singleton
//Build all objects we need to provide to our application
//all components from the application will have access to this objects
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val tmdbApiKey = BuildConfig.TMDB_API_KEY
    private val tmdbBaseURL = BuildConfig.TMDB_BASE_URL
    private const val DB_NAME = "MovieDatabase"

    @Provides
    fun provideTokenInterceptor(): TokenInterceptor {
        return TokenInterceptor(queryValue = tmdbApiKey)
    }
    @Provides
    fun provideTmdbService(tokenInterceptor: TokenInterceptor): MovieService {
        //use the logger of the library: intercepts requests and prints them!
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY //print all to log

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .baseUrl(tmdbBaseURL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }
    @Provides
    fun provideTVShowsService(tokenInterceptor: TokenInterceptor): TVShowsService {
        //use the logger of the library: intercepts requests and prints them!
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY //print all to log

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .baseUrl(tmdbBaseURL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TVShowsService::class.java)
    }

    //one database instance for all the fragments:
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDB {
        return Room.databaseBuilder(
            context,
            AppDB::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMovieDao(db:AppDB) = db.movieDao()

    @Provides
    fun provideTVShowDao(db:AppDB) = db.tvShowsDao()
}
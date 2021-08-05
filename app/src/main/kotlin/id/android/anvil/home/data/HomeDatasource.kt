package id.android.anvil.home.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDatasource {

  @GET("/3/movie/now_playing")
  fun nowPlaying(
    @Query("api_key")
    apiKey: String
  ): Single<HomeResponse>
}
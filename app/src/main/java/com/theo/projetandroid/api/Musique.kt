package com.theo.projetandroid.api
import androidx.room.Query
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



// list musique
data class TrackSongData(
    @SerializedName("track")
    val content: List<TrackDataContent>,
)
data class TrackDataContent(
    val idTrack: String,
    val strTrack: String,
    val intTrackNumber: String,

    /*val strTrackThumb: String,
    val idTrack: String,
    val idArtist: String,
    val idAlbum: String,*/
)

interface APITrack {
    // get classement titres
    @GET("track.php") //2115888{albumID}
    fun getTrackByAlbumIdDataAsync(@Query("m")value:String): Deferred<TrackSongData>
}


object NetworkTrack {

    val api = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(APITrack::class.java)

}


package com.theo.projetandroid.api
import androidx.room.Query
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



// data Album
data class ArtistTopTrackData(
    @SerializedName("track")
    val content: List<ArtistTopTrackContent>,
)
//
//  Titres
//

data class ArtistTopTrackContent(
    val idTrack: String,
    val idAlbum:String,
    val idArtist: String,
    val strTrack: String,
    val strAlbum: String,
    val strArtist: String,


    /*val strTrackThumb: String,
    val idTrack: String,
    val idArtist: String,
    val idAlbum: String,*/
)

interface APIArtistToptrack {
    // get album par artiste
    @GET("track-top10.php") //coldplay({artistid}
    fun getArtistsTopByNameDataAsync(@Query("s")value:String): Deferred<ArtistTopTrackData> // albumId:String


}


object NetworkArtistToptrack {

    val api = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(APIArtistToptrack::class.java)

}
package com.theo.projetandroid.api
import androidx.room.Query
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET




// artistes
data class ArtistData(
    @SerializedName("artists")
    val content: List<ArtistDataContent>,
)
// classement Titres de l'artiste
data class ArtistDataContent(
    val idArtist: String,
    val strArtist:String,
    val strGenre: String,
    val strBiographyEN: String,
    val strCountry: String,
    val strArtistThumb: String,



)

interface APIArtists {
    // get album par artiste
    @GET("artist.php") //112024({artistid}
    fun getArtistsByIDDataAsync(@Query("i")value:String): Deferred<ArtistData> // albumId:String

    @GET("search.php") //coldplay({artistName}
    fun getArtistsDetailsByArtistNameDataAsync(@Query("s")value:String): Deferred<ArtistData> // artistName:String

}


object NetworkArtist {

    val api = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(APIArtists::class.java)

}
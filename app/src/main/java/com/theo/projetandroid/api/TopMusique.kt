package com.theo.projetandroid.api

import com.theo.projetandroid.api.SerializedName
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


data class TopTitleSongData(
    @SerializedName("trending")
    val content: List<TopTitleDataContent>,
)
// écran classement Titres
//
data class TopTitleDataContent(
    val idTrend: String,
    val intChartPlace: String,
    val strArtist: String,
    val strAlbum: String,
    val strTrackThumb: String,
    val strTrack: String,
)

interface APITitreClassement {
    // get classement
    @GET("trending.php?country=us&type=itunes&format=singles")
    fun getTopTitleDataAsync(): Deferred<TopTitleSongData>
}


object NetworkTopTitle {

    val api = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(APITitreClassement::class.java)

}
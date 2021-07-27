package com.theo.projetandroid.api



// Album
data class AlbumData(
    @SerializedName("album")
    val content: List<AlbumDataContent>,
)

annotation class SerializedName(val value: String)

data class AlbumDataNameYears(
    @SerializedName("album")
    val content: List<AlbumDataResume>,
)

// classement titres
data class AlbumDataContent(
    val idArtist: String,
    val strAlbum: String,
    val strGenre: String,
    val strArtist:String,
    val intYearReleased: String,
    val strAlbumThumb: String,
    val intScore: String,
    val intScoreVotes: String,
)

data class AlbumDataResume(
    val strAlbum: String,
    val intYearReleased: String,

)

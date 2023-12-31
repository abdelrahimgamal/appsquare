package myapp.appsquare.appsquare.data.models

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

data class DataPost(val body: String, val title: String,val boolean: Boolean)

fun Post.mapToDataPost(): DataPost {
    return DataPost(body,title,false)
}
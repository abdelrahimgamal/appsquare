package myapp.appsquare.appsquare.data.models

data class Product(
    var id: Int,
    var price: Int,
    var quantity: Int,
    var restaurant_id: Int,
    var name: String,
    var image: String,
)

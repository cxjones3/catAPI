package com.example.apitest.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breed(

    val weight : Weight,
    val id : String,
    val name : String,
    @field:Json(name = "cfa_url")
    val cfaUrl : String,
    @field:Json(name = "vetstreet_url")
    val vetStreetUrl : String,
    @field:Json(name = "vcahospitals_url")
    val vcaHospitalsUrl : String?,
    val temperament : String,
    val origin : String,
    @field:Json(name = "country_codes")
    val countryCodes : String,
    @field:Json(name = "country_code")
    val countryCode : String,
    val description : String,
    @field:Json(name = "life_span")
    val lifeSpan : String,
    val indoor : Int,
    val lap : Int,
    @field:Json(name = "alt_names")
    val altNames : String,
    val adaptability : Int,
    @field:Json(name = "affection_level")
    val affectionLevel : Int,
    @field:Json(name = "child_friendly")
    val childFriendly : Int,
    @field:Json(name = "dog_friendly")
    val dogFriendly : Int,
    @field:Json(name = "energy_level")
    val energyLevel : Int,
    val grooming : Int,
    @field:Json(name = "health_issues")
    val healthIssues : Int,
    val intelligence : Int,
    @field:Json(name = "shedding_level")
    val sheddingLevel : Int,
    @field:Json(name = "social_needs")
    val socialNeeds : Int,
    @field:Json(name = "stranger_friendly")
    val strangerFriendly : Int,
    val vocalisation : Int,
    val experimental : Int,
    val hairless : Int,
    val natural : Int,
    val rare : Int,
    val rex : Int,
    @field:Json(name = "suppressed_tail")
    val suppressedTail : Int,
    @field:Json(name = "short_legs")
    val shorLegs : Int,
    @field:Json(name = "wikipedia_url")
    val wikipediaUrl : String,
    val hypoallergenic : Int,
    @field:Json(name = "reference_image_id")
    val referenceImageId : String,
    val image: Image,
)

@JsonClass(generateAdapter = true)
data class Weight(
    val imperial : String,
    val metric : String,
)

@JsonClass(generateAdapter = true)
data class Image(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String,
)
    
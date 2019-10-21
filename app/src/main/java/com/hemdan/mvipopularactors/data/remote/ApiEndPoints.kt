package com.hemdan.mvipopularactors.data.remote

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
object ApiEndPoints {
    const val ACTORS_LIST = "person/popular"
    const val ACTOR_DETAILS = "person/{${ApiKeys.PERSON_ID}}"
    const val ACTOR_IMAGES = "person/{${ApiKeys.PERSON_ID}}/images"
    const val ACTOR_SEARCH = "search/person"
}
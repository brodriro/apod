package com.brodriro.apod.commons

import com.brodriro.apod.domain.entities.PostEntity
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class Utils @Inject constructor() {

    fun fakeList(): List<PostEntity> {
        val list = ArrayList<PostEntity>()
        val post = PostEntity(
            "Tom Glenn",
            "2022-01-28",
            "The Mare Orientale, Latin for Eastern Sea, is one of the most striking large scale lunar features. The youngest of the large lunar impact basins it's very difficult to see from an earthbound perspective. Still, taken during a period of favorable tilt, or libration of the lunar nearside, the Eastern Sea can be found near top center in this sharp telescopic view, extremely foreshortened along the Moon's western edge. Formed by the impact of an asteroid over 3 billion years ago and nearly 1000 kilometers across, the impact basin's concentric circular features are ripples in the lunar crust. But they are a little easier to spot in more direct images of the region taken from lunar orbit. So why is the Eastern Sea at the Moon's western edge? The Mare Orientale lunar feature was named before 1961. That's when the convention labeling east and west on lunar maps was reversed.",
            "https://apod.nasa.gov/apod/image/2201/Mare_Orientale_Nov_27_2021_TGlenn_1024.jpg",
            "Western Moon, Eastern Sea"
        )
        list.add(post)
        list.add(post)
        list.add(post)
        list.add(post)
        list.add(post)
        return list
    }

    fun getDateFromDays(days: Int): String {
        val cal = Calendar.getInstance();
        val s = SimpleDateFormat("yyyy-MM-dd")
        cal.add(Calendar.DAY_OF_YEAR, days);
        return s.format(Date(cal.timeInMillis))
    }
}
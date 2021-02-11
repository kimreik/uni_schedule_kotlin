package schedule.model

import java.time.LocalDate

data class Week(
    val startDate: LocalDate,
    val monday: Day,
    val tuesday: Day,
    val wednesday: Day,
    val thursday: Day,
    val friday: Day,
    val saturday: Day,
){
    val days = listOf(monday, tuesday, wednesday, thursday, friday, saturday)

    init {
        days.forEachIndexed { index, day ->  day.date = startDate.plusDays(index.toLong()) }
    }

}
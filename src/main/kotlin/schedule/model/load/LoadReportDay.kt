package schedule.model.load

import java.time.LocalDate

data class LoadReportDay(
    val date: LocalDate,
    val dayHours: Int
)

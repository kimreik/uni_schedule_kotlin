package schedule.model.load

import java.time.LocalDate

data class LoadReportWeek(
    val startDate: LocalDate,
    val days: List<LoadReportDay>,
    val weekHours: Int = days.sumBy { it.dayHours }
)
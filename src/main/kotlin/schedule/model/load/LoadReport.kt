package schedule.model.load

import schedule.model.Professor

data class LoadReport(
    val professor: Professor,
    val weeks: List<LoadReportWeek>
    )
package schedule

import schedule.model.*
import schedule.model.load.LoadReport
import schedule.model.load.LoadReportDay
import schedule.model.load.LoadReportWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class ScheduleService(private val schedule: Schedule) {

    fun weekScheduleForGroup(weekStart: LocalDate, group: Group): Week? =
        schedule.weeks
            .find { it.startDate == weekStart }
            ?.filterByGroup(group)

    fun dayScheduleForGroup(day: LocalDate, group: Group): Day? =
        schedule.weeks
            .find { ChronoUnit.DAYS.between(it.startDate, day) in 0..5 }
            ?.days?.find { it.date == day }
            ?.filterByGroup(group)

    fun nextLessonsOfSubject(
        date: LocalDate = LocalDate.now(),
        subject: Subject,
        count: Int
    ): List<Lesson> =
        schedule.weeks
            .flatMap { it.days }
            .filter { it.date.isAfter(date) }
            .flatMap { it.lessons }
            .filter { it.subject == subject }
            .take(count)

    fun professorLoadReport(professor: Professor) = LoadReport(
        professor = professor,
        weeks = schedule.weeks
            .map {
                LoadReportWeek(
                    startDate = it.startDate,
                    days = it.days.map { day ->
                        LoadReportDay(
                            date = day.date,
                            dayHours = day.lessons.count { lesson -> lesson.professor == professor }
                        )
                    }
                )
            }
    )
}

private fun Week.filterByGroup(group: Group) = Week(
    startDate = this.startDate,
    monday = this.monday.filterByGroup(group),
    tuesday = this.tuesday.filterByGroup(group),
    wednesday = this.wednesday.filterByGroup(group),
    thursday = this.thursday.filterByGroup(group),
    friday = this.friday.filterByGroup(group),
    saturday = this.saturday.filterByGroup(group),
)

private fun Day.filterByGroup(group: Group) = Day(
    first = this.first.filterByGroup(group),
    second = this.second.filterByGroup(group),
    third = this.third.filterByGroup(group),
    forth = this.forth.filterByGroup(group)
)

private fun List<Lesson>.filterByGroup(group: Group) = this.filter { it.group == group }.map { it.copy() }
package schedule

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import schedule.model.Day
import schedule.model.Lesson
import schedule.model.Week
import schedule.model.load.LoadReport
import schedule.model.load.LoadReportDay
import schedule.model.load.LoadReportWeek
import java.time.LocalDate
import java.time.LocalDateTime

class ScheduleServiceTest {

    private val scheduleService = ScheduleService(schedule)

    @Nested
    inner class WeekScheduleForGroup {

        private val expected = Week(
            startDate = LocalDate.of(2021, 2, 8),
            monday = Day(
                first = listOf(
                    Lesson(
                        subject = PT,
                        professor = yakut,
                        group = mf11
                    )
                )
            ),
            tuesday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    )
                )
            ),
            wednesday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    )
                )
            ),
            thursday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    )
                )
            ),
            friday = Day(
                first = listOf(
                    Lesson(
                        subject = PT,
                        professor = yakut,
                        group = mf11
                    )
                )
            ),
            saturday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    )
                )
            )
        )

        private val empty = Week(
            startDate = LocalDate.of(2021, 2, 8),
            monday = Day(emptyList()),
            tuesday = Day(emptyList()),
            wednesday = Day(emptyList()),
            thursday = Day(emptyList()),
            friday = Day(emptyList()),
            saturday = Day(emptyList())
        )

        @Test
        fun `finds a week schedule for a given date and group`() {
            val weekScheduleForGroup = scheduleService.weekScheduleForGroup(LocalDate.of(2021, 2, 8), mf11)

            weekScheduleForGroup shouldBe expected
        }

        @Test
        fun `returns null if there's no schedule for a given date`() {
            val weekScheduleForGroup = scheduleService.weekScheduleForGroup(LocalDate.of(2021, 2, 28), mf11)

            weekScheduleForGroup shouldBe null
        }

        @Test
        fun `returns an empty week schedule if there's no lessons for a given group`() {
            val weekScheduleForGroup = scheduleService.weekScheduleForGroup(LocalDate.of(2021, 2, 8), mf13)

            weekScheduleForGroup shouldBe empty
        }
    }

    @Nested
    inner class DayScheduleForGroup {

        private val expected = Day(
            first = listOf(
                Lesson(
                    subject = PT,
                    professor = yakut,
                    group = mf11
                )
            )
        ).apply {
            date = LocalDate.of(2021, 2, 8)
        }

        private val empty = Day(emptyList()).apply {
            date = LocalDate.of(2021, 2, 8)
        }

        @Test
        fun `finds a day schedule for a given date and group`() {
            val dayScheduleForGroup = scheduleService.dayScheduleForGroup(LocalDate.of(2021, 2, 8), mf11)

            dayScheduleForGroup shouldBe expected
        }

        @Test
        fun `returns null if there's no schedule for a given date`() {
            val dayScheduleForGroup = scheduleService.dayScheduleForGroup(LocalDate.of(2021, 2, 28), mf11)

            dayScheduleForGroup shouldBe null
        }

        @Test
        fun `returns an empty day schedule if there's no lessons for a given group`() {
            val dayScheduleForGroup = scheduleService.dayScheduleForGroup(LocalDate.of(2021, 2, 8), mf13)

            dayScheduleForGroup shouldBe empty
        }


    }

    @Nested
    inner class NextLessonsOfSubject {

        @Test
        fun `finds next N lessons for a given subject and date`() {
            val nextLessonsOfSubject =
                scheduleService.nextLessonsOfSubject(LocalDate.of(2021, 2, 1), PT, 3)

            nextLessonsOfSubject.size shouldBe 3

            nextLessonsOfSubject[0].time shouldBe LocalDateTime.of(2021, 2, 8, 8, 0)
            nextLessonsOfSubject[1].time shouldBe LocalDateTime.of(2021, 2, 12, 8, 0)
            nextLessonsOfSubject[2].time shouldBe LocalDateTime.of(2021, 2, 15, 8, 0)

        }

        @Test
        fun `returns all the lessons after the date if there's not enough lessons scheduled`() {
            val nextLessonsOfSubject =
                scheduleService.nextLessonsOfSubject(LocalDate.of(2021, 2, 1), PT, 100)

            nextLessonsOfSubject.size shouldBe 4
        }

        @Test
        fun `returns an empty list if there's no lessons after a given date`() {
            val nextLessonsOfSubject =
                scheduleService.nextLessonsOfSubject(LocalDate.of(2021, 2, 21), PT, 1)

            nextLessonsOfSubject.size shouldBe 0
        }
    }

    @Nested
    inner class ProfessorLoadReport {

        private val expectedLoadReport = LoadReport(
            professor = yakut,
            weeks = listOf(
                LoadReportWeek(
                    startDate = LocalDate.of(2021, 2, 8),
                    weekHours = 2,
                    days = listOf(
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 8),
                            dayHours = 1
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 9),
                            dayHours = 0
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 10),
                            dayHours = 0
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 11),
                            dayHours = 0
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 12),
                            dayHours = 1
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 13),
                            dayHours =0
                        )
                    )
                ),
                LoadReportWeek(
                    startDate = LocalDate.of(2021, 2, 15),
                    weekHours = 2,
                    days = listOf(
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 15),
                            dayHours = 1
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 16),
                            dayHours = 0
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 17),
                            dayHours = 0
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 18),
                            dayHours = 0
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 19),
                            dayHours = 1
                        ),
                        LoadReportDay(
                            date = LocalDate.of(2021, 2, 20),
                            dayHours = 0
                        )
                    )
                )
            )
        )

        @Test
        fun `builds a load report for a given professor`() {
            val loadReport = scheduleService.professorLoadReport(yakut)

            loadReport shouldBe expectedLoadReport
        }
    }

}
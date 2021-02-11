package schedule

import schedule.model.Day
import schedule.model.Lesson
import schedule.model.Schedule
import schedule.model.Week
import java.time.LocalDate

val schedule = Schedule(
    listOf(
        Week(
            startDate = LocalDate.of(2021, 2, 8),
            monday = Day(
                first = listOf(
                    Lesson(
                        subject = PT,
                        professor = yakut,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            tuesday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            wednesday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            thursday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            friday = Day(
                first = listOf(
                    Lesson(
                        subject = PT,
                        professor = yakut,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            saturday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            )
        ),
        Week(
            startDate = LocalDate.of(2021, 2, 15),
            monday = Day(
                first = listOf(
                    Lesson(
                        subject = PT,
                        professor = yakut,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            tuesday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            wednesday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            thursday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            friday = Day(
                first = listOf(
                    Lesson(
                        subject = PT,
                        professor = yakut,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            ),
            saturday = Day(
                first = listOf(
                    Lesson(
                        subject = math,
                        professor = ermochenko,
                        group = mf11
                    ),
                    Lesson(
                        subject = physics,
                        professor = noviy,
                        group = mf12
                    )
                )
            )
        )
    )

)

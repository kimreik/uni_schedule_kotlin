package schedule.model

import java.time.LocalDate


data class Day(
    val first: List<Lesson> = emptyList(),
    val second: List<Lesson> = emptyList(),
    val third: List<Lesson> = emptyList(),
    val forth: List<Lesson> = emptyList()
) {
    var date: LocalDate by initOnce {
        first.forEach { it.time = date.atTime(8, 0) }
        second.forEach { it.time = date.atTime(9, 0) }
        third.forEach { it.time = date.atTime(10, 0) }
        forth.forEach { it.time = date.atTime(11, 0) }
    }

    val lessons = listOf(first, second, third, forth).flatten()

    init {
        validate(first)
        validate(second)
        validate(third)
        validate(forth)
    }

    private fun validate(lessons: List<Lesson>){
        validateGroups(lessons)
        validateProfessors(lessons)
    }

    private fun validateGroups(lessons: List<Lesson>){
        lessons
            .groupBy { it.group }
            .entries
            .find { it.value.size > 1 }
            ?.let {
                throw IllegalStateException("group ${it.key?.name} already has a lesson at this time")
            }
    }

    private fun validateProfessors(lessons: List<Lesson>){
        lessons.groupBy { it.professor }
            .entries
            .find { it.value.size > 1 }
            ?.let {
                throw IllegalStateException("professor ${it.key?.name} already has a lesson at this time")
            }
    }
}

package schedule.model

data class Professor(
    val name: String,
    val subjects: List<Subject>
){
    init {
        subjects.forEach { it.professors.add(this) }
    }
}
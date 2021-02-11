package schedule.model

data class Group(
    val name: String,
    val students: List<Student>
){
    init {
        students.forEach { it.group = this }
    }
}

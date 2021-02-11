package schedule.model

data class Subject(val name: String) {
    val professors = mutableListOf<Professor>()
}
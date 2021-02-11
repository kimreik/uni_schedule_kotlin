package schedule.model

data class Student(
    val name: String
){
    var group: Group by initOnce()
}
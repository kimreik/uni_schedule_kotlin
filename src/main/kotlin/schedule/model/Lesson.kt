package schedule.model

import java.lang.IllegalStateException
import java.time.LocalDateTime

data class Lesson(
    val subject: Subject?,
    val professor: Professor?,
    val group: Group?
){
    var time:LocalDateTime by initOnce()

    init {
        if(professor != null && subject != null){
            if(!professor.subjects.contains(subject)){
                throw IllegalStateException("${professor.name} doesn't know ${subject.name}")
            }
        }
    }
}



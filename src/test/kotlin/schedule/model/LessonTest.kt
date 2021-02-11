package schedule.model

import org.junit.jupiter.api.Test
import schedule.math
import schedule.mf11
import schedule.yakut
import java.lang.IllegalStateException
import kotlin.test.assertFailsWith

class LessonTest{

    @Test
    fun `professor should know the subject`(){
        assertFailsWith<IllegalStateException> {
            Lesson(
                professor = yakut,
                subject = math,
                group = mf11
            )
        }
    }


}
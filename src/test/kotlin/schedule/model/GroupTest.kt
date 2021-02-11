package schedule.model

import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class GroupTest {

    @Test
    fun `student can be assigned to a single group`(){
        val student = Student("newbie")

        Group("group_1", listOf(student))

        assertFailsWith<IllegalStateException> {
            Group("group_2", listOf(student))
        }
    }
}
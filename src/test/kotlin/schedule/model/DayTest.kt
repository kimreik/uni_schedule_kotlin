package schedule.model

import schedule.*
import kotlin.test.Test
import kotlin.test.assertFailsWith

class DayTest {

    @Test
    fun `group should have one lesson at a time`() {

        assertFailsWith<IllegalStateException> {
            Day(
                first = listOf(
                    Lesson(
                        math,
                        ermochenko,
                        mf11
                    ),
                    Lesson(
                        physics,
                        noviy,
                        mf11
                    )
                )
            )
        }

    }

    @Test
    fun `professor should have one lesson at a time`() {

        assertFailsWith<IllegalStateException> {
            Day(
                first = listOf(
                    Lesson(
                        math,
                        ermochenko,
                        mf11
                    ),
                    Lesson(
                        physics,
                        ermochenko,
                        mf12
                    )
                )
            )
        }

    }
}
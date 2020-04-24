package search

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BinarySearch {

    fun binarySearch(numbers: List<Int>, target: Int): Int {
        var min = 0
        var max = numbers.size - 1
        while (min <= max) {
            /** We calculate the midrange this way, as [min + max / 2] would cause an overflow
             *  for sufficiently large arrays (i.e: size 2^30 or larger).*/
            val mid = min + (max - min / 2)
            when {
                numbers[mid] == target -> {
                    return mid
                }
                target > numbers[mid] -> {
                    min = mid + 1
                }
                else -> {
                    max = mid - 1
                }
            }
        }
        return -1
    }

    @Test
    fun `binary search finds correct index of a target when found or -1 otherwise`() {


        val numbersList = listOf(
            63, 65, 67, 69, 71, 73, 75,
            79, 81, 83, 85, 87, 89,
            91, 93, 95
        )

        // Existing targets
        val indexOf93 = binarySearch(numbersList, 93)
        assertThat(indexOf93, equalTo(14))

        val indexOf91 = binarySearch(numbersList, 91)
        assertThat(indexOf91, equalTo(13))

        val indexOf79 = binarySearch(numbersList, 79)
        assertThat(indexOf79, equalTo(7))

        val indexOf81 = binarySearch(numbersList, 81)
        assertThat(indexOf81, equalTo(8))

        // Non-existing targets
        val indexOf0 = binarySearch(numbersList, 0)
        assertThat(indexOf0, equalTo(-1))

        val indexOf120 = binarySearch(numbersList, 120)
        assertThat(indexOf120, equalTo(-1))
   }
}
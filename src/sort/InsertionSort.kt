package sort

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class InsertionSort {

    fun insertionSort(numbers: MutableList<Int>): MutableList<Int> {
        var j = 0
        for (i in 1 until numbers.size) {
            j = i
            while (j > 0 && (numbers[j - 1] > numbers[j])) {
                val temp: Int = numbers[j - 1]
                numbers[j - 1] = numbers[j]
                numbers[j] = temp
                j--
            }
        }
        return numbers

    }

    @Test
    fun `sorting works as expected when n = 10, 50, 100 and 1000`() {

        val sorted10 = List(10) { i -> i + 1 }
        val shuffled10 = listOf(3, 1, 5, 9, 10, 4, 6, 2, 8, 7)
        assertThat((insertionSort(shuffled10.toMutableList())), equalTo(sorted10))

        val sorted50 = List(50) { i -> i + 1 }
        val shuffled50 = sorted50.shuffled()
        assertThat((insertionSort(shuffled50.toMutableList())), equalTo(sorted50))

        val sorted100 = List(100) { i -> i + 1 }
        val shuffled100 = sorted100.shuffled()
        assertThat((insertionSort(shuffled100.toMutableList())), equalTo(sorted100))

        val sorted1000 = List(1000) { i -> i + 1 }
        val shuffled1000 = sorted1000.shuffled()
        assertThat((insertionSort(shuffled1000.toMutableList())), equalTo(sorted1000))

    }

}
package sort

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SelectionSort {
    fun selectionSort(numbers: MutableList<Int>): MutableList<Int> {
        for (i in 0 until numbers.size) {
            var min = numbers[i]
            for (j in i + 1 until numbers.size) {
                if (numbers[j] < min) {
                    min = numbers[j]
                    val temp = numbers[i]
                    numbers[i] = numbers[j]
                    numbers[j] = temp
                }
            }
        }
        return numbers
    }


    @Test
    fun `test output of different sizes against standard sort implementation`() {

        val unsortedList = mutableListOf(3, 8, 7, 9, 2, 6, 5)
        val standardSortedList: MutableList<Int> = unsortedList.sorted().toMutableList()
        val selectionSortedSort: MutableList<Int> = selectionSort(unsortedList)
        assertThat(selectionSortedSort, equalTo(standardSortedList))

        val unsortedList2 = List(1000) { i -> i + 1 }.shuffled().toMutableList()
        val standardSortedList2 = unsortedList2.sorted().toMutableList()
        val selectionSortedList2 = selectionSort(unsortedList2)
        assertThat(selectionSortedList2, equalTo(standardSortedList2))
    }

}
package backtracking

val result = mutableListOf<List<Int>>()

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    checking(0, 0, target, candidates, mutableListOf<Int>())
    return result
}

private fun checking(index: Int, currSum: Int, target: Int, candidates: IntArray, subList: MutableList<Int>) {
    if (index >= candidates.size) return

    val subListIndex = if (subList.size == 0) 0 else subList.size - 1
    if (currSum > target) {
        return
    }

    if (currSum == target) {
        result.add(subList.toList())
        return
    }
    val item = candidates[index]


    subList.add(subListIndex, item)
    checking(index, currSum + item, target, candidates, subList)

    subList.removeAt(subListIndex)
    checking(index + 1, currSum, target, candidates, subList)

}
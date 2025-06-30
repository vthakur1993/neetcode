package backtracking

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val subset = mutableListOf<Int>()
        fun dfs(i: Int) {
            if (i >= nums.size) {
                res.add(subset.toList())
                return
            }
            subset.add(nums[i])
            dfs(i + 1)
            subset.removeAt(subset.size - 1)
            dfs(i + 1)
        }

        dfs(0)
        return res
    }
}
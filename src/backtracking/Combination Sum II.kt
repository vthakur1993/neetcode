package backtracking

// https://leetcode.com/problems/combination-sum-ii/

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    candidates.sort()

    fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
        if (total == target) {
            res.add(ArrayList(cur))
            return
        }
        if (total > target || i == candidates.size) {
            return
        }

        cur.add(candidates[i])
        dfs(i + 1, cur, total + candidates[i])
        cur.removeAt(cur.size - 1)

        var next = i + 1
        while (next < candidates.size && candidates[next] == candidates[i]) {
            next++
        }
        dfs(next, cur, total)
    }

    dfs(0, mutableListOf(), 0)
    return res
}

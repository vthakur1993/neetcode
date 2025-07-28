package linkedLists

/*
    Leetcode: https://leetcode.com/problems/find-the-duplicate-number/description/
    Neetcode: https://neetcode.io/problems/find-duplicate-integer?list=neetcode150
 */
fun findDuplicate(nums: IntArray): Int {
    var slow = 0
    var fast = 0

    while (true) {
        slow = nums[slow]
        fast = nums[nums[fast]]
        if (slow == fast) break
    }

    var slow2 = 0
    while(true) {
        slow = nums[slow]
        slow2 = nums[slow2]

        if (slow == slow2) return slow
    }
    return -1
}

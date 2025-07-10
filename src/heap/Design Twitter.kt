package heap

import java.util.PriorityQueue

/*
    Leetcode: https://leetcode.com/problems/design-twitter/
    Neetcode: https://neetcode.io/problems/design-twitter-feed?list=neetcode150
 */

class Twitter() {
    val followersMap = mutableMapOf<Int, MutableSet<Int>>()
    val tweetsMap = mutableMapOf<Int, MutableList<Pair<Int,Int>>>()
    var count = 0

    fun postTweet(userId: Int, tweetId: Int) {
        val list = tweetsMap.computeIfAbsent(userId) { mutableListOf() }
        list.add(Pair(count, tweetId))
        tweetsMap[userId] = list
        count++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val queue = PriorityQueue<IntArray>(compareByDescending {
            it[0]
        })
        var result = mutableListOf<Int>()


        if (followersMap[userId] == null) {
            followersMap[userId] = mutableSetOf()
        }
        followersMap[userId]?.add(userId)

        followersMap[userId]?.forEach { followeeId ->
            tweetsMap[followeeId]?.let {
                if (it.isNotEmpty()) {
                    val index = it.size - 1
                    val pair = it[index]!!
                    queue.add(intArrayOf(pair.first, pair.second, followeeId, index - 1))
                }
            }
        }

        while (queue.isNotEmpty() && result.size < 10) {
            val (count, tweetId, followeeId, index) = queue.poll()
            result.add(tweetId)
            tweetsMap[followeeId]?.let { list ->
                if (index >= 0) {
                    val pair = list[index]!!
                    queue.add(intArrayOf(pair.first, pair.second, followeeId, index - 1))
                }
            }
        }

        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (followersMap[followerId] == null) {
            followersMap[followerId] = mutableSetOf<Int>()
        }
        followersMap[followerId]!!.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        if (followersMap[followerId] == null) {
            followersMap[followerId] = mutableSetOf<Int>()
        }
        followersMap[followerId]!!.remove(followeeId)
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */
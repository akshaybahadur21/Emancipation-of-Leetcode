/*

355. Design Twitter
Medium

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

    postTweet(userId, tweetId): Compose a new tweet.
    getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
    follow(followerId, followeeId): Follower follows a followee.
    unfollow(followerId, followeeId): Follower unfollows a followee.

Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);

*/

class Twitter {

    /** Initialize your data structure here. */
    //followingMap
    //PriorityQueue
    Map<Integer, List<Integer>> followingMap;
    Queue<Tweet> heap;
    int time=0;
    public Twitter() {
        followingMap = new HashMap<>();
        heap = new PriorityQueue<Tweet>((n1,n2)->n2.getTime() - n1.getTime());
    }
    public class Tweet{
        int userId;
        int tweetId;
        int time;
        Tweet(int userId, int tweetId, int time){
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = time;
        }
        public int getTweetId(){
            return tweetId;
        }
        public int getUserId(){
            return userId;
        }
        public int getTime(){
            return time;
        }
    }
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(userId, tweetId,time);
        time++;
        heap.add(t);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> resList = new ArrayList<>();
        Stack<Tweet> s = new Stack<>();
        List<Integer> followeeList = new ArrayList<>();
        if (followingMap.containsKey(userId))
            followeeList.addAll(followingMap.get(userId));
        followeeList.add(userId);
        while(!heap.isEmpty() && resList.size() != 10){
            Tweet t = heap.poll();
            if (followeeList.contains(t.getUserId()))
                resList.add(t.getTweetId());
            s.push(t);
        }
        while(!s.isEmpty())
            heap.add(s.pop());

        return resList;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId)){
            followingMap.get(followerId).add(followeeId);
            return;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(followeeId);
        followingMap.put(followerId, temp);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId)){
            List<Integer> temp = followingMap.get(followerId);
            temp.remove(new Integer(followeeId));
            followingMap.put(followerId, temp);
        }

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

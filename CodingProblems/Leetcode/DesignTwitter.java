/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able 
to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.

Example 1:

Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
 

Constraints:

1 <= userId, followerId, followeeId <= 500
0 <= tweetId <= 10^4
All the tweets have unique IDs.
At most 3 * 10^4 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
*/
class Twitter {
    
    class Tweet {
        int tweetId;
        int time;
        
        Tweet(int tweetId, int time) { //in real life, the constructor should have only one param and the time of the tweet should be set with the help of java.time.Instant
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    
    private Map<Integer, Set<Integer>> followees;
    private int time = 0; //dummy counter to mock time of the tweet, in real life you should use java.time.Instant
    private Map<Integer, List<Tweet>> tweets;

    /** Initialize your data structure here. */
    public Twitter() {
        this.followees = new HashMap();
        this.tweets = new HashMap();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) tweets.put(userId, new ArrayList());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
	//minHeap to store the latest 10, or less, tweets
        PriorityQueue<Tweet> newsFeed = new PriorityQueue<Tweet>(10, (t1, t2) -> (t1.time - t2.time));
        
        //the user's own tweets
		for(Tweet tweet : tweets.getOrDefault(userId, new ArrayList<Tweet>())) {
            addToNewsFeed(tweet, newsFeed);
        }
        
        //the followee tweets
		for(int followee : followees.getOrDefault(userId, new HashSet<Integer>())) {
            if(!tweets.containsKey(followee)) continue;
            for(Tweet tweet : tweets.get(followee)) {
                addToNewsFeed(tweet, newsFeed);
            }
        }
        
        if(newsFeed.isEmpty()) return new ArrayList(); //simple check
        
        int index = newsFeed.size() - 1; //fill the result array backwards as we need the tweets to be sorted newest to oldest
        Integer[] result = new Integer[index+1];
        
        while(!newsFeed.isEmpty()) {
            result[index--] = newsFeed.poll().tweetId;
        }
        
        return Arrays.asList(result);
    }
    
    private void addToNewsFeed(Tweet tweet, PriorityQueue<Tweet> newsFeed) {
        if(newsFeed.size() < 10) { //while we don't have 10 tweets, keep adding
            newsFeed.add(tweet);
        }else if(newsFeed.peek().time < tweet.time) { //if found a newer tweet, poll from the heap and add it
            newsFeed.poll();
            newsFeed.offer(tweet);
        }
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followees.containsKey(followerId)) followees.put(followerId, new HashSet());
        followees.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followees.containsKey(followerId)) followees.get(followerId).remove(followeeId);
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
class Twitter {
    private static final int CAPACITY = 10;

    private int time = 0;

    private final Map<Integer, Set<Integer>> followerMap = new HashMap<>();
    private final Map<Integer, LinkedList<Tweet>> userTweets = new HashMap<>();

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new LinkedList<>());
        LinkedList<Tweet> tweets = userTweets.get(userId);

        if (tweets.size() >= CAPACITY) {
            tweets.removeFirst();
        }

        tweets.addLast(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followees = new HashSet<>(followerMap.getOrDefault(userId, Collections.emptySet()));
        followees.add(userId); // include user's own tweets

        PriorityQueue<Tweet> heap = new PriorityQueue<>(Comparator.comparingInt(t -> t.time));

        for (int followee : followees) {
            LinkedList<Tweet> tweets = userTweets.getOrDefault(followee, new LinkedList<>());

            for (Tweet tweet : tweets) {
                if (heap.size() < CAPACITY) {
                    heap.offer(tweet);
                } else if (heap.peek().time < tweet.time) {
                    heap.poll();
                    heap.offer(tweet);
                }
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            result.addFirst(heap.poll().tweetId); // most recent first
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerMap.containsKey(followerId)) {
            followerMap.get(followerId).remove(followeeId);
        }
    }
}
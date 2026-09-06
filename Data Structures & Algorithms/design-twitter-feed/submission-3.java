class Twitter {
    private static class Tweet {
        int tweetId;
        int timestamp;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    private static class Node {
        int userId;
        Tweet tweet;
        int index;

        Node(Tweet tweet, int userId, int index) {
            this.userId = userId;
            this.tweet = tweet;
            this.index = index;
        }
    }

    HashMap<Integer, Set<Integer>> following;
    HashMap<Integer, List<Tweet>> tweets;

    private int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }

        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b.tweet.timestamp, a.tweet.timestamp));

        List<Integer> ans = new ArrayList<>();

        if (tweets.containsKey(userId)) {
            List<Tweet> list = tweets.get(userId);
            int last = list.size() - 1;

            pq.offer(new Node(list.get(last), userId, last));
        }

        if (following.containsKey(userId)) {
            for (int followee : following.get(userId)) {
                if (tweets.containsKey(followee)) {
                    List<Tweet> ls = tweets.get(followee);
                    int lst = ls.size() - 1;
                    pq.offer(new Node(ls.get(lst), followee, lst));
                }
            }
        }

        while (!pq.isEmpty() && ans.size() < 10) {
            Node curr = pq.poll();
            ans.add(curr.tweet.tweetId);

            int nextIndex = curr.index - 1;
            if (nextIndex >= 0) {
                List<Tweet> list = tweets.get(curr.userId);
                pq.offer(new Node(list.get(nextIndex), curr.userId, nextIndex));
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

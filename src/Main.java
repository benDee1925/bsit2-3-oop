public static void main(String[] args) {
        PostManager pm = new PostManager();

        System.out.println("═══ Social Media Post Manager ═══");

        
        String postTitle = "Java Programming Tips";
        int engagementScore = pm.calculateEngagement(150, 75, 25);
        String category = pm.getCategoryRating(engagementScore);

        pm.displayPostStats(postTitle, engagementScore, category);

      
        String[] hashtags = {"#java", "#coding", "#programming", "#java", "#tips"};
        ArrayList<String> uniqueHashtags = pm.manageHashtags(hashtags);

        
        ArrayList<String> posts = new ArrayList<>();
        posts.add("Java Programming Tips");
        posts.add("Spring Boot Guide");
        posts.add("Advanced Java Tutorial");

        HashMap<String, Integer> postEngagement = new HashMap<>();
        postEngagement.put("Java Programming Tips", engagementScore);
        postEngagement.put("Spring Boot Guide", 800);
        postEngagement.put("Advanced Java Tutorial", 1200);

        LinkedList<String> trendingPosts = pm.findTrendingPosts(posts, postEngagement);

        
        HashSet<String> uniqueAuthors = pm.getUniqueAuthors("Alice", "Bob", "Alice", "Charlie", "Bob");

        System.out.println();
        System.out.println("Unique Hashtags: " + uniqueHashtags);
        System.out.println("Trending Posts: " + trendingPosts);
        System.out.println("Unique Authors: " + uniqueAuthors);
    }
}

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = startUrl.split("/")[2];
        Queue<String> bfs = new LinkedList<>();
        bfs.add(startUrl);
        Set<String> visited = new HashSet<>();
        visited.add(startUrl);
        List<String> sameHostUrls = new ArrayList<>();
        while (!bfs.isEmpty()) {
            int len = bfs.size();
            for (int i = 0; i < len; i++) {
                String currUrl = bfs.poll();
                visited.add(currUrl);
                sameHostUrls.add(currUrl);
                List<String> currUrls = htmlParser.getUrls(currUrl);
                for (String tempUrl : currUrls) {
                    if (!visited.contains(tempUrl) && tempUrl.indexOf(hostname) != -1) {
                        visited.add(tempUrl);
                        bfs.add(tempUrl);
                    }
                }
            }
        }
        System.out.println("SIZE: " + sameHostUrls.size());
        return sameHostUrls;
    }
}
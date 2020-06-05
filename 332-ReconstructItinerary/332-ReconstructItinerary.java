/*

332. Reconstruct Itinerary
Medium

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.

Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.

*/

class Solution {
    Map<String, PriorityQueue<String>> flightMap;
    LinkedList<String> path;
    public List<String> findItinerary(List<List<String>> tickets) {
        flightMap = new HashMap<>();
        path = new LinkedList<>();
        for(List<String> t : tickets){
            flightMap.putIfAbsent(t.get(0), new PriorityQueue<>((n1, n2) -> n1.compareTo(n2)));
            flightMap.get(t.get(0)).add(t.get(1));
        }
        dfs("JFK");
        return path;
    }
    
    private void dfs(String departure){
        PriorityQueue<String> arrival = flightMap.get(departure);
        while(arrival != null && !arrival.isEmpty())
            dfs(arrival.poll());
        path.addFirst(departure);
    }
}

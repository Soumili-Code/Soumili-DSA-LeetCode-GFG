class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[numCourses];
        int c=0;
        List<List<Integer>> adjList= buildAdjList(numCourses, prerequisites);
        int[] indegree = findIndegree(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int temp = q.poll();
            ans[c++]=temp;
            for(Integer neighbor:adjList.get(temp)){
                indegree[neighbor]-=1;
                if(indegree[neighbor]==0){
                    q.offer(neighbor);
                }
            }
            
        }
        return c == numCourses ? ans : new int[0];
    }
    private int[] findIndegree(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]] += 1;
        }
        return indegree;
    }
    private List<List<Integer>> buildAdjList(int numCourses,int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            int u=pre[0];
            int v=pre[1];
            adjList.get(v).add(u);
        }
        return adjList;
    }
}

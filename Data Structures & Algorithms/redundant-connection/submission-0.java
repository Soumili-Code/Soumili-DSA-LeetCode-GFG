class DSU{
    List<Integer> parent;
    List<Integer>  bySize;
    DSU(int n){
        parent = new ArrayList<>();
        bySize = new ArrayList<>();
        for(int i=0;i<=n;i++){
            parent.add(i);
            bySize.add(1);
        }
       
    }
    public int findParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int p = findParent(parent.get(node));
        parent.set(node,p);
        return p;
    }
    public boolean unionBySize(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu==pv){
            return false;
        }
        else if(bySize.get(pu)<bySize.get(pv)){
            parent.set(pu,pv);
            bySize.set(pv,bySize.get(pu)+bySize.get(pv));
        }
        else{
            parent.set(pv,pu);
            bySize.set(pu,bySize.get(pu)+bySize.get(pv));
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] duplicate  = new int[2];
        int  uniqueNodes = edges.length;
        DSU dsu = new DSU(uniqueNodes);
        for (int[] edge : edges) {
           if(!dsu.unionBySize(edge[0],edge[1])){
                return edge;
           }
        }
        return new int[0];
    }
}

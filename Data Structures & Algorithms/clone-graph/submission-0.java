/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> x = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Set<Node> nSet = new HashSet<>();
        q.add(node);
        nSet.add(node);
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            Node newNode = new Node(tmp.val);
            x.put(tmp, newNode);
            List<Node> tmp1 = tmp.neighbors;
            for(int i = 0; i < tmp1.size(); i++) {
                if(!nSet.contains(tmp1.get(i))) {
                    nSet.add(tmp1.get(i));
                    q.add(tmp1.get(i));
                }
            }
        }

        q = new LinkedList<>();
        nSet = new HashSet<>();

        q.add(node);
        nSet.add(node);

            while(!q.isEmpty()) {
            Node tmp = q.poll();
            Node newNode = x.get(tmp);
            List<Node> tmp1 = tmp.neighbors;
            List<Node> neigh = new ArrayList<>();
            for(int i = 0; i < tmp1.size(); i++) {
                Node newNode1 = x.get(tmp1.get(i));
                neigh.add(newNode1);
            }
            newNode.neighbors = neigh;
            for(int i = 0; i < tmp1.size(); i++) {
                if(!nSet.contains(tmp1.get(i))) {
                    nSet.add(tmp1.get(i));
                    q.add(tmp1.get(i));
                }
            }
        }

        return x.get(node);
    }
}
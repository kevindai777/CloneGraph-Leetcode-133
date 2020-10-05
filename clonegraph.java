//Java Solution

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> graph = new HashMap<>();
        return dfs(graph, node);
    }
    
    public Node dfs(Map<Node, Node> graph, Node node) {
        if (node == null) {
            return null;
        }
        
        Node newNode = new Node(node.val);
        if (graph.containsKey(node)) {
            newNode = node;
        }
        
        graph.put(node, newNode);
        
        for (Node neighbor : node.neighbors) {
            if (graph.containsKey(neighbor)) {
                newNode.neighbors.add(graph.get(neighbor));    
            } else {
                newNode.neighbors.add(dfs(graph, neighbor));
            }
        }
        
        return newNode;
    }
}
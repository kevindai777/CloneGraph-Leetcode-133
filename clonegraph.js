//Objective is to make a deep copy of a graph.


let map = new Map()

function dfs(node) {
    if (!node) {
        return null
    }

    //If the node was already visited, return the clone from the visited map
    let newNode = new Node(node.val)
    if (map.has(node)) {
        newNode = node
    }

    //Set a key value pair of the original and the clone
    map.set(node, newNode)

    //Copy all the neighbors into the map, if the neighbor doesn't exist
    //yet in the map dfs through the neighbor to add all of its neighbors
    //and itself into the map
    for (let neighbor of node.neighbors) {
        newNode.neighbors.push(map.get(neighbor) || dfs(neighbor))
    }

    return newNode
}
return dfs(node)
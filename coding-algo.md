
# Commonly Used Algorithms

## Binary Search

### Greedy Algorithm

## Sliding Window

```python
def max_sum_subarray(arr, k):
    # Length of the array
    n = len(arr)
    
    # Edge case: if k is greater than the length of the array
    if k > n:
        return None

    # Compute the sum of the first window
    window_sum = sum(arr[:k])
    max_sum = window_sum

    # Slide the window from start to end of the array
    for i in range(n - k):
        # Update the window sum by sliding the window
        window_sum = window_sum - arr[i] + arr[i + k]
        # Update the maximum sum if needed
        max_sum = max(max_sum, window_sum)

    return max_sum
```

## Breadth-First Search

### Level Order Traversal

```python
def bfs(graph, start):
    # List to keep track of visited nodes
    visited = []
    # List to be used as a queue for BFS
    queue = [start]

    while queue:
        # Dequeue a vertex from the queue
        node = queue.pop(0)
        if node not in visited:
            # Mark the node as visited
            visited.append(node)
            print(node, end=" ")

            # Get all adjacent vertices of the dequeued vertex
            for neighbor in graph[node]:
                if neighbor not in visited and neighbor not in queue:
                    # If a neighbor has not been visited or is not already in the queue, enqueue it
                    queue.append(neighbor)
```

## Depth-First Search

### Pre Order Traversal

### Pos Order Traversal

### InOrder Traversal

```python
def dfs(graph, start):
    # List to keep track of visited nodes
    visited = []
    # List to be used as a stack for DFS
    stack = [start]

    while stack:
        # Pop a vertex from the stack
        node = stack.pop()
        if node not in visited:
            # Mark the node as visited
            visited.append(node)
            print(node, end=" ")

            # Get all adjacent vertices of the popped vertex
            for neighbor in graph[node]:
                if neighbor not in visited:
                    # If a neighbor has not been visited, push it onto the stack
                    stack.append(neighbor)
```

## BackTracking

```python
def permute(a, l, r): 
    if l == r: 
        print(toString(a)) 
    else: 
        for i in range(l, r): 
            a[l], a[i] = a[i], a[l] 
            permute(a, l+1, r) 
            a[l], a[i] = a[i], a[l]  # backtrack 
```

## Divide-And-Conquer


# java-dsa-practice

Classic data structures and algorithms in plain Java (no libraries), written while studying LAB211 / DSA.
Each file is self-contained and has a `main` that prints example results.

## Run

```bash
javac -d out src/*.java
java -cp out TwoSum
```

## Problems

| # | Problem | Idea |
|---|---------|------|
| 1 | [TwoSum](src/TwoSum.java) | Two Sum with a hash map - O(n) |
| 2 | [BinarySearch](src/BinarySearch.java) | Binary search and lower bound - O(log n) |
| 3 | [ValidParentheses](src/ValidParentheses.java) | Balanced brackets with a stack - O(n) |
| 4 | [ReverseLinkedList](src/ReverseLinkedList.java) | Reverse a singly linked list, iterative and recursive |
| 5 | [MinStack](src/MinStack.java) | Stack with O(1) minimum using a second stack |
| 6 | [GcdLcm](src/GcdLcm.java) | GCD with Euclid algorithm, LCM without overflow |
| 7 | [SieveOfEratosthenes](src/SieveOfEratosthenes.java) | All primes up to n - O(n log log n) |
| 8 | [PrefixSum](src/PrefixSum.java) | O(1) range-sum queries after O(n) preprocessing |
| 9 | [SlidingWindow](src/SlidingWindow.java) | Max sum of k elements, longest substring without repeats |
| 10 | [MergeSort](src/MergeSort.java) | Stable O(n log n) sort with one temp buffer |
| 11 | [QuickSort](src/QuickSort.java) | Random-pivot quick sort, in place, O(log n) stack |
| 12 | [BinarySearchTree](src/BinarySearchTree.java) | BST insert / contains / delete / in-order |
| 13 | [GridShortestPath](src/GridShortestPath.java) | BFS shortest path on a grid with walls |
| 14 | [Fibonacci](src/Fibonacci.java) | Memoization vs bottom-up DP |
| 15 | [Knapsack01](src/Knapsack01.java) | 0/1 knapsack DP - O(n*W) time, O(W) space |

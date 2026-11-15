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

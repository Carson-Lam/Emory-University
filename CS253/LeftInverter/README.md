# LeftInverter

Retrieved from CS253 on [Hackerrank](https://www.hackerrank.com/)

## Problem Description
We have an array A of N values to sort: A[0], A[1], ..., A[N-1].

Consider Insertion Sort. For each value A[i] (for i=0, 1, 2, ...), we "insert" it in its correct position among the previous values. The inserted A[i] moves L[i] steps to its left, where L[i] is the number of larger values to its left. Note those larger values were also to its left in the original array.

We could compute these L[i] values as a side-effect of insertion sort. However, insertion sort can take quadratic time, which is too slow. **Your goal is to compute them by a faster method.**

## Input format
The input is two lines. The first line has a single integer: N

The second line has N integers: A[0] A[1] ... A[N-1]

## Constraints
1 ≤ N ≤ 100,000

For each i, 0 ≤ A[i] < 10^9

## Output format
Output a single line with N integers separated by spaces:

L[0] L[1] ... L[N-1]

Each L[j] should equal the number of indices i such that 0≤iA[j].

## Sample Input 
```
4
5 2 6 0
```

## Sample Output
```
0 1 0 3
```
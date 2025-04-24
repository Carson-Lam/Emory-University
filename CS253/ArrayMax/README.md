# ArrayMax

Retrieved from CS253 on [Hackerrank](https://www.hackerrank.com/)

## Problem Description

A is an array of M integers, initially all zero: A[0], A[1], ..., A[M-1]. The input describes a sequence of N assignments operations, each of the form "A[i]=v". After each assignment, you report the index j such that A[j] is the current maximum array value. In case of a tie, report the smallest such j.

You should produce the k-th output before reading the (k+1)-th assignment.

Harder Version: implement this using O(M) space, rather than O(N).

**This is an implementation of the "Harder Version"**

## Input format
The first line has two integers:

M N

The next N lines each have two integers, describing an assignment "A[i]=v":

i v

## Constraints
1 ≤ M ≤ 50000

M ≤ N ≤ 500000

0 ≤ i < M

0 ≤ v < 10^9

## Output format
There are N lines of output, corresponding to the N assignments. The k-th output is an integer j, such that A[j] is the largest array value after the kth assignment. In case of a tie, report the smallest such j.

## Sample Input 
```
3 5
1 5
2 7
1 4
2 3
1 2
```

## Sample Output
```
1
2
2
1
2
```

## Trace
After A[1]=5, the array is [0,5,0], and the max 5 is at 1.

After A[2]=7, the array is [0,5,7], and the max 7 is at 2.

After A[1]=4, the array is [0,4,7], and the max 7 is at 2.

After a[2]=3, the array is [0,4,3], and the max 4 is at 1.

After A[1]=2, the array is [0,2,3], and the max 3 is at 2.
# Border Sum

## Problem Description
Generate a set of random values in the shape of a unicode box
```
x----------x----------x
|          |          |
x----------x----------x
|          |          |
x----------x----------x
```
where x represents a random value. Then, sum the values along each column and row, check for even numbers within the grid, and check for odd numbers in the middle row.

## Input Specifications
N/A

## Output Specifications
Output 
- The square
- The sum of the values at all rows and columns
- Whether any even values exist throughout the entire grid.
- Whether there are at least 2 odd numbers in the middle row


## Sample I/O

### Sample Input
```
```

### Sample Output
```
2----------4----------9
|          |          |
5----------8----------1
|          |          |
8----------0----------7

Sum of columns:
Column 1: 15
Column 2: 12
Column 3: 17

Sum of rows:
Row 1: 15
Row 2: 14
Row 3: 15

Sum of all numbers: 44

The sum of the second column is: 12, 12 is > 10

There is an even number among 9 numbers

There are at least 2 odd numbers in the middle row.
```


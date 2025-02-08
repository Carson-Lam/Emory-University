# Rational Values

## Problem Description
Rational values (i.e., "fractions") are quotients of integers. Given fractional user input, convert the fraction to decimal form while accounting for repeating decimals. When a rational value has an infinite number of (non-zero) decimal places, some subsequence of the digits that result must ultimately start repeating. Identify the longest pattern of decimals that repeat and output it indicated by an overline `‾`. 

## Input Specifications
The input will be a set of positive fractions seperated by spaces

## Output Specifications
The output will be a set of decimals that may or may not contain repeating patterns.
## Sample I/O

### Sample Input
```
8/2 3/2 1/8 1/7 101/3 1/6 1/12 970/23 1691/330 3179893/9906
```

### Sample Output
```
8/2 = 4
3/2 = 1.5
1/8 = 0.125
1/7 = 0.1̅4̅2̅8̅5̅7̅
101/3 = 33.6̅
1/6 = 0.16̅
1/12 = 0.083̅
970/23 = 42.1̅7̅3̅9̅1̅3̅0̅4̅3̅4̅7̅8̅2̅6̅0̅8̅6̅9̅5̅6̅5̅2̅
1691/330 = 5.12̅4̅
3179893/9906 = 321.00̅6̅7̅6̅3̅5̅7̅7̅6̅2̅9̅7̅1̅9̅3̅6̅2̅0̅0̅2̅8̅2̅6̅5̅6̅9̅7̅5̅5̅7̅0̅3̅6̅1̅3̅9̅7̅1̅3̅3̅0̅5̅
```


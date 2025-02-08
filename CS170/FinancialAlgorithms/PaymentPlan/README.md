# Payment Plan

## Problem Description
Generate a monthly payment plan based on input for a certain amount owed, accounting for interest and loan duration. 

## Input Specifications
The input will be three positive integers specifying the principal loan, yearly interest rate, and duration of loan

## Output Specifications
Based on user input, generate a chart that shows the required payment, payment interest, principal (total) payment, and remaining amount owed after each month.  

## Sample I/O

### Sample Input
```
5000
12
5
```


### Sample Output
```
Payment#    Payment     Payment-Interest    Payment-Principal      Amt Owed
1           111.22         50.00               61.22               4938.78
2           111.22         49.39               61.83               4876.94
3           111.22         48.77               62.45               4814.49
...
60          111.22         1.10                110.12              0.00
```


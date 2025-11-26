# data structures notes

******

<div style="font-size: 1rem; font-weight: bold; color: green;">1) How to remove last element of an array which mostly comes handy especially during recursion?</div>

```
int[] arr = new int[] { 1, 5, 3, 2};
int[] newArr = Arrays.copyOf(arr, arr.length - 1)
```



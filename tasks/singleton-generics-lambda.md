## TASK 4. SINGLETON, GENERICS, LAMBDA

**Task Requirements**
In the context of this task, it’s a necessity to create the Filter class to remove specific values from an array of any type. The solution must comply with the following requirements:
- The Filter class must be a singleton with lazy initialization;
- This class must have the ‘filter’ method;
- This method must use generics to get an input array and to return an output array;
- This method must contain a lambda parameter to get a condition to filter the input array.

Here is an example of code that creates an instance of an initial array and use the ArrayFilter singleton class to remove null values from it:
```
String[] initialArray = new String[]{"One", "Two", null, "Three", null, "Four", "Five"};
System.out.println("Initial Array = " + Arrays.toString(initialArray));
String[] newArray = ArrayFilter.getInstance().filter(initialArray, Objects::nonNull);
System.out.println("Result Array = " + Arrays.toString(newArray));
```

The resulting output should be the same as the following example:
```
Initial Array = [One, Two, null, Three, null, Four, Five]
Result Array = [One, Two, Three, Four, Five]
```

## TASK 2. MULTITHREADING

**Task Requirements**<br>
In the context of this task, it’s a necessity to create two classes: Producer and Consumer. These classes must implement the Runnable interface. Instances of both classes should be run in separate threads. The Producer class generates random integer values once per second and writes them to the shared queue. The constructor of this class gets a maximal size a buffer of the shared queue (20 by default), and a reference to the queue. The Consumer class reads the queue. If the numbers of values in the queue are less than 10, then Consumer simply displays the content of the queue. Otherwise, Consumer removes the first ten values from the shared queue.
The resulting output should be the same as the following example:
```
Shared Queue = [4]
Shared Queue = [4, 4]
Shared Queue = [4, 4, 3]
Shared Queue = [4, 4, 3, 7]
Shared Queue = [4, 4, 3, 7, 5]
Shared Queue = [4, 4, 3, 7, 5, 3]
Shared Queue = [4, 4, 3, 7, 5, 3, 4]
Shared Queue = [4, 4, 3, 7, 5, 3, 4, 3]
Shared Queue = [4, 4, 3, 7, 5, 3, 4, 3, 6]
Shared Queue = []
Shared Queue = [6]
Shared Queue = [6, 2]
Shared Queue = [6, 2, 2]
Shared Queue = [6, 2, 2, 0]
Shared Queue = [6, 2, 2, 0, 6]
Shared Queue = [6, 2, 2, 0, 6, 7]
Shared Queue = [6, 2, 2, 0, 6, 7, 6]
Shared Queue = [6, 2, 2, 0, 6, 7, 6, 4]
Shared Queue = [6, 2, 2, 0, 6, 7, 6, 4, 8]
Shared Queue = []
Shared Queue = [9]
Shared Queue = [9, 2]
Shared Queue = [9, 2, 8]
Shared Queue = [9, 2, 8, 2]
Shared Queue = [9, 2, 8, 2, 0]
Shared Queue = [9, 2, 8, 2, 0, 6]
Shared Queue = [9, 2, 8, 2, 0, 6, 3]
Shared Queue = [9, 2, 8, 2, 0, 6, 3, 6]
Shared Queue = [9, 2, 8, 2, 0, 6, 3, 6, 3] 
```

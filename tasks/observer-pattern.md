## TASK 3. OBSERVER PATTERN

**Task Requirements**
In the context of this task, it’s a necessity to create your own StringBuilder class that contains an observer pattern. Your class must include an option to notify other objects about its state changes. Everything methods that relate to the StringBuilder class must be delegated to standard StringBuilder.
Here is an example of code that creates an instance of the observable StringBuilder class and adds several strings there:
```
ObservableStringBuilder observableStringBuilder = new ObservableStringBuilder();
.
.
.
observableStringBuilder.append("Hello");
observableStringBuilder.append(", ");
observableStringBuilder.append("World!");
```

The resulting output should be the same as the following example:

```
The observable StringBuilder has been changed: 'Hello'
The observable StringBuilder has been changed: 'Hello, '
The observable StringBuilder has been changed: 'Hello, World!'
```
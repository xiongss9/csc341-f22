### Lab 3 : Extending the LIST Abstract Data Type
#### Due Thursday, September 22 end-of-day
#### Submit a single zipped file to Moodle

In this lab, you will continue to build your List class that is implemented with an array.
The List is replicating the functionality of the Java collections ArrayList class, except that it can only hold Face objects.

Learning Outcomes:

- Understand Object and use it appropriately.
- Understand the "this" object.
- Understand and implement the primary operations for a _List_ implemented with an array.
- Understand the practice of _Test-Driven Development_.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### General Requirements

- Implement equals for the Face class
- Complete the methods for the List class as described below.
- Document all code with Javadocs.
- Answer the discussion questions.

### Getting Started

Pull the repo to get this file. Copy your work from Lab02 into the Lab03 directory.

<hr>

### LISTS

The Abstract Data Type (ADT) **_List_** refers to a collection of elements, which is maintained with primary operators that add, remove, find, and sort elements. In your reading, they distinguish between a list, bag, and set. I make no such distinctions and refer to all of them as a List, but I will be specific in whether or not those elements are unique (i.e. a set) or in a sorted order. The operators applied to a list must be explicitly defined, unlike with queues in which elements are added and removed from specific locations.

It is important to have a shared understanding of the list qualities and how the operators modify the list. For this lab:
- The list may not have duplicate elements.
- The list is not sorted.
- If no positional information is provided, the `add()` operator will add to the END of the list.
- If positional information is provided, the `add()` operator will add at the INDEX indicated, shifting elements to make room.

#### Documentation

1. AS you are coding, add inline comments and javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.


#### Face equals

1. In the Face class, write the method `Boolean equals(Object obj)`, which is an Object method that is being
overridden. For an example, see https://www.geeksforgeeks.org/overriding-equals-method-in-java/. For 2 faces to be equal,
all member variables pertaining to the facial features (e.g. width, height, eyeLength, etc.) must be equal. The names
and ID do not have to match. If the "this" is equal in value to obj, return true, else false.

2. In Lab02, if you were comparing faces to check for equality, replace that with your new equals method.

#### List Feature Enhancements

> NOTE: Several of these methods can make use of other methods that you have or are about to write.
If you find yourself copying and pasting code from another method, ask yourself if instead you could just call the method!

3. `Boolean remove(Face face)`
    Removes the first occurence that is equal to face (use the equals method from above).
    Returns true if it was successfully removed, otherwise false.

4. `Face remove(int index)`
    Removes the face at that index (if the index is valid). Return the face that was removed or null if nothing was removed.

5. `Boolean addAll(Face[] faces)`
    Add all elements in the array passed in the method BUT only if they can ALL fit. Return true if they were added, else false.

6. `int toArray(Face[] array)`
    Copy as many elements in the "this" array that will fit into the passed array. Return the number of elements added.

7. `List(List toCopy)`
    This is a special constructor that creates a copy of the "this" object (sometimes referred to as a copy constructor).
    Notice there is no return type because it is a constructor. HINT: you can get an array of faces out of the toCopy array,
    then copy them into the "this" array.

#### Javadocs Inspection

8. When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the Lab02 folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:
  ```
  mkdir docs
  cd docs
  javadoc ../*.java
  ```
  You can view the results by opening the index.html file in your browser.


#### TESTS for Remove Methods

9. Test your remove tests and make sure they are working.


#### QUESTIONS

1. Why is it necessary to cast the `Object obj` that is passed in `equals` to a Face object?

2. What does it mean to make a shallow and a deep copy? If the requirements had stated that the copy constructor should
make a "deep" copy of array objects, how would that have changed your code?

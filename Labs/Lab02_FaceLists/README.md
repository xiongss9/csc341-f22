### Lab 2 : Building a LIST Abstract Data Type
#### Due Monday, September 19
#### Submit a single zipped file to Moodle

CHANGES:
- 09-15-22: Do not print any error message in peek or in add.
- 09-15-22: Requirements did not mention `set`, but it is in the code. Please implement `set`.

In this lab, you will again be working with a database of cartoon faces that can be used for facial recognition.
In Lab01, the _database_ was a basic array with a fixed size. After the initial filling of the array to construct
the database, there were no modifications to the array. This is not a reasonable assumption, and you need
to create a data structure that is easy to access and modify. 

In this initial work on data structures, you will create an abstract data type (ADT) *List*, similar to 
the `ArrayList<>` in the Java collections, but it will exclusively store *Face* objects. In subsequent labs, you
will enhance functionality of the *List* class, and eventually create a generic ADT class that is capable of storing any type of object.

Look for "TODO" in the code, which highlights what you need to implement.

Learning Outcomes:

- Understand and implement the primary operations that add and find elements in a _List_ implemented with an array.
- Understand the practice of _Test-Driven Development_.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

General Requirements:

1. Complete the methods that perform the primary operations of adding and finding elements in the List.
2. Write tests to verify code.
3. Document all code with Javadocs.

<hr>

### LISTS

The Abstract Data Type (ADT) **_List_** refers to a collection of elements, which is maintained with primary operators that add, remove, find, and sort elements. In your reading, they distinguish between a list, bag, and set. I make no such distinctions and refer to all of them as a List, but I will be specific in whether or not those elements are unique (i.e. a set) or in a sorted order. The operators applied to a list must be explicitly defined, unlike with queues in which elements are added and removed from specific locations.

It is important to have a shared understanding of the list qualities and how the operators modify the list. For this lab:
- The list may not have duplicate elements. 
- The list is not sorted.
- If no positional information is provided, the `add()` operator will add to the END of the list.
- If positional information is provided, the `add()` operator will add at the INDEX indicated, shifting elements to make room.

#### Javadocs Documentation

4. AS you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

5. When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the Lab02 folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:
  ```
  mkdir docs
  cd docs
  javadoc ../*.java
  ```
  You can view the results by opening the index.html file in your browser.

#### MISCELANEOUS

Implement the following ...

6. `Boolean isFull()` determines whether or not there is capacity for more faces.
7. `Boolean isEmpyt()` determines whether or not there are any faces in the List.
8. `Boolean isValid(int index)` determines if the given index corresponds to an element stored in the List.

#### PEEK Method

9. Implement the `peek(int index)` method.
    - If the index is valid, return the element at that index. It should not be removed, just returned.
    - If the index is not valid, <del>print an error message and</del> return null.

#### ADD Methods

10. Implement the add method `add(Face face)`.
    - If the structure is not full, add to the end of the list. (The _end_ of the list refers to the last element in the list.)
    - If the structure is full, ignore the request <del>print an error message</del>. Do not add anything to the list.
    - Maintain the count.

11. Implement the add method `add(Face face, int index)`.
    - If the index is invalid (i.e. a location that leaves space between elements or is out of range), ignore the request <del>print an error message</del>. Do not add the face to the list.
    - If the structure is not full and the index is valid, add the element at the index indicated.
    - Shift all elements as appropriate BEFORE adding the element to make space for it.
    - If the structure is full, ignore the request <del>print an error message</del>. Do not add anything to the list.
    - Maintain the count.

> Note that ignoring the request without providing feedback to the user is not a good idea. But neither are print statements. We will fix this at some point.
    
12. Implement the set method `void set(int index, Face face)`
    - IF the index is valid, relplace the element at index with the one passed to the method.

12. Write a test for `add(Face face, int index)` in which you are adding to the middle of the List. _Look for the TODO._

13. Write tests that test `add(Face face, int index)` when the index is beyond the last element (but not the capacity),
and one that is beyond the capacity. _Look for the TODO._

<hr>


#### FIND Method

15. Implement the `recordNo(Face face)` method.
    - If the face is in the list, return its index.
    - If the face is not in the list, return -1 (no error message required).

<hr>

#### CONVERT Method

16. Implement `Face[] toArray()`. It creates an array of the size of the number of elements stored. All elements are copied into the 
array in the order they appear in the List.

#### TESTS for Remove Methods

17. Write at least 2 tests for `remove(Integer index)`. One test should test to remove at a valid index and the other should test to remove at an invalid index.

18. Write at least 2 tests for `remove(Face face)`. One test should search for a face that is in the list and one for a face that is not in the list.


#### QUESTIONS

1. What is the best- and worst-case scenarios with respect to time for `add(Face,int)` and how do they compare with respect to the size or length of the array?
In other words, where in the array is it most efficient to add and where in the array is it least efficient to add; and how would you quantify the best and worst?

2. In Lab01, we stored the database of faces in Java's basic data structure array. What is the advantage of instead storing the database in 
this abstract data type of a List? What are some of the disadvantages?

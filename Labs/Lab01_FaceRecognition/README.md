## Lab 01 Best Programming Practices in the Context of Machine Learning

#### DUE Wednesday, September 14 end-of-day

In this lab, you will complete _cartoon_ facial recognition using a common
machine learning technique. In the process, you will learn about best industry
practices for programming. This includes:

- _Git_, one of the most popular code repositories
- _GitHub_, cloud service with GUI to remotely store your Git repo
- command-line operations in a shell for file management, compilation and execution
- _VS Code_ (or your favorite editor) for source code editing (not an IDE)
- JAVA Style Guide
- Unit Testing (an informal homegrown version - not JUnit testing)
- Javadocs for automated documentation
- Debugger (although we will not look at this until later in the semester)

> You can work with 1 other person in the class (but you do not have to).

<hr>

### Getting Started

Review the instructions at the top level of this repository to get your system ready.
When you are done, you should have _Java_, _git_ and _VS Code_ installed on your machine.

#### Clone This Repository

Open a terminal. Navigate to where you would like your repo for this course to go and clone it.
Here is an example from Dr. Larson's machine:

```
cd ~/courses
mkdir cs341
cd cs341
git clone https://github.com/lars1050/csc341-f22 
mkdir sandbox
```

In the repo, code for each lab and inclass exercises will be posted.
The _sandbox_ directory is for small programs that you might want to experiment with. I always
make a sandbox to try things out in.

#### Open in VS Code

If you see the VS Code icon with the .java files in your Finder, then you can double-click 
any of the files in Lab01 that you just cloned from your Finder and it will open VS Code. 
If there is a different icon, then right-click the file and choose to open it with VS Code.

Once VS Code is open, go to the dropdown "File" menu and choose to open a file. 
Navigate to the enclosing FOLDER and open the folder. This will create a left sidebar with all files.

Once you have the folder open, select the pulldown menu _Terminal_ and choose "New Terminal".
Now you are ready to compile the code within the terminal. Notice that the path in the Terminal
matches the location of the lab 
(although if it does not, then you need to navigate to the directory within the terminal).

<hr>

### Machine Learning for Facial Recognition

If someone asked you to find the person in the room who is closest in height to yourself,
you would be able to do this, no problem! But what was the ALGORITHM that you used to do that?

If someone asked you to find the person in the room who is closest in build to yourself,
you can still do this, but it is a little trickier! Now you have to look at height, weight and
general body shape. How do you evaluate multiple characteristics to find the closest match?
It might even be subjective (meaning based on a person's opinion). One person might
think that the person who is proportionally similar is closest, regardless of height, 
whereas someone else might think it is most important to match height and use body shape second.

In many machine learning applications, this is precisely what the system is trying to achieve --
find the best match based on multiple criteria (referred to as _features_). A simple technique,
which we are using here, is to take the difference between features and add them up. Here is 
an example:

```
Person1 =   height:65"    weight:120lb    waist:27"   bicep:11"
Person2 =   height:63"    weight:105lb    waist:26"   bicep:11"
Person3 =   height:67"    weight:135lb    waist:28"   bicep:11"

Difference Person1 vs Person2 = 65-63 + 120-105 + 27-26 + 11-11 = 18
Difference Person1 vs Person3 = 65-67 + 120-135 + 27-28 + 11-11 = -18
```

Notice that the difference has the same magnitude, but different signs (one positive, one negative).
Person2 and Person3 are equidistance from Person1, but the values are different.
To fix this, we take the SQUARE of each difference, sum them all, then take 
the square root to make it more in scale with the original values.

```
((65-63)^2 + (120-105)^2 + (27-26)^2 + (11-11)^2) ^ 0.5
```

Once you compare the object to all the rest, the best match is the one with the minimum difference.
That is a pretty simple formula that might not do a great job finding the
subtle differences that make a significant impact. As the designer of the machine learning
system, you might modify this in different ways to improve performance. For example, you might
think one feature is more important than another, therefore you multiply it by a constant.
On the other hand, you might think it is less important and divide it by a constant. 
The weight of a person is on a scale 10x of the bicep measurement. If you want them
to be of equal importance, you might divide the weight by 10.
Applying a constant to a feature to emphasize or de-emphasize its importance
is called *weighting* the feature. Much of machine learning makes use of
sophisticated techniques to measure the distance between objects, as well as
determining which of the features is the most important to consider.

<hr>

## Deliverables

<hr>

### Write Face.compare(Face other)

Your task is to write a function `Face.compare(Face other)` in the Face class
that calculates a difference between "this" object and the other. In facial
recognition, we might have images at different distances, so we want a measure that
is not influenced by this. Therefore, we use ratios that compare facial features 
relative to the width or height of the face. Here are your features to use:

- face width / face height
- (eye delta * 2) / face width
- nose length / face height
- nose width / face width
- mouth delta / face height

_Eye delta_ is the length from the nose to the edge of the eye. The _mouth delta_
is the length from the bottom of the nose to the top of the mouth.

>Be sure to use inline comments with `\\` to explain your code.
<br>

### Unit Tests for the Compare Method

_Test-Driven Developement_ is a technique whereby you first write the tests for your code,
THEN you write the code. It has a lot of benefits, but it is a hard habit to form. In this
code you will see that some tests have bee provided for you. To run the tests on the command
line, type `java UnitTestFace` once the file has been compiled with `javac *.java`.  
You might have passed the tests or they might have failed. If they passed, you will not see
any error messages. But if it does fail, you will see both the expected and acutal values, as shown below. 

```
amylarson@MacBook-Pro-110 ~/C/c/_/Lab01> javac *.java
amylarson@MacBook-Pro-110 ~/C/c/_/Lab01> java UnitTestFace
***** TESTING Face constructor with String
***** TESTING Face compare method
***** TESTING Best Match
FAIL match same value
       expected 1, results 0
FAIL match different value
       expected 4, results 0
```

>If you failed the *compare method* test, be sure to fix the code and pass the tests before moving on.

<br>

### Write Unit Test for compare

Write 1 unit test for the compare method as indicated in the code. Run the tests and make sure they pass.
NOTICE that a test of doubles is unique in 
that you have to specify a tolerance. For example, do you consider .0011 and .0018 equal but not .011 and .018?
If so, then you would specify a tolerance of .001.

```
javac *.java
java UnitTestFace
```

<br>

### Write Main.findBestMatch(face,faces) and Main.findWorstMatch(face,faces)

Complete the 2 separate functions that take a given face and compare it to all others. For _findBestMatch()_, 
it should return the face in _faces_ that has the minimum difference,  and for _findWorstMatch()_,
it should return the face with the maximum difference.

Once you have completed `Main.findBestMatch()`, run the unit tests again and see if you have passed. Be sure
to fix the code before moving on.

Complete `Main.findWorstMatch()`. It is identical to findBestMatch() except for a few minor changes.

<br>

### Write Unit Tests for Main.findWorstMatch

As part of this assignment, you need to write 3 unit tests for the `Main.findWorstMatch()` method. The unit tests for
this should be similar to those for `findBestMatch`. 

> oops! Looks like I forgot to remove the tests before posting. Lucky you. You might want to write one just to make sure you understand how they work.

<br>

### Complete Javadocs

*Complete the Javadocs for th Face class only*. Each method should have a general description that includes a
list of parameters and return value, each with a short description. Please use the `@param` and `@return` tags
within the description. You do NOT have to document the setters and getters.

<br>

### Answer Questions in report.txt

Create a file `report.txt` and answer the following questions:

<ol>
<li> In the code, you will see 2 different forms of an array. One is an `ArrayList` class that is imported
with `import java.util.ArrayList;` and the other is a built-in data type defined using square brackets.
Consider the following definitions:,

```Java
Face[] facesArray = new Face[10];
ArrayList<Face> facesList = new ArrayList<>();
```
<ol>
<li>Write the syntax to add an element to each of these structures.
<li>Briefly describe the difference in how elements are added to each of these data structures.
</ol>

<li> Look at the Point class definition. This class has 2 member variables x and y. If you declared a 
Point and then wanted to get the x value, you could do this in 2 ways:

```Java
System.out.println(point.x);
System.out.println(point.x())
```

<ol><li>Briefly compare them by discussing their advantages and disadvanteges.
</ol></ol>

<hr>

### Submit to Moodle

Zip the folder and submit via Moodle. You can zip the folder by right clicking the icon and choosing
to compress it.
       














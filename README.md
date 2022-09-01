# CSC341 Data Structures (Fall 2022)

This is the repository of code for CSC341 Data Structures. The majority of assignments
will be posted here including weekly labs and inclass exercises. In this course, you
will be developing best coding practices such as using a repository and a style guide.

It is important that you ready your personal machine for the semester. You will need to install
- Java SDK (https://www.oracle.com/technetwork/java/javase/downloads/index.html)
- git (https://git-scm.com/)
- VS Code (https://code.visualstudio.com/)

<hr>

## Command Line

Most people interact with the software on their computer through the icons: either applications on your desktop
or folders and files in your Finder. However, many computer scientists interact through a _terminal_ or
_command window_ or _shell_ (all terms you might hear to essentially mean the same thing). 
`terminal` is both a general term to mean a window in which you type commands and the official name of the application for Macs. This is also referred to as a `shell` and there are different languages that can be used to interpret
the commands that you type. `Bash shell` (https://en.wikipedia.org/wiki/Bash_(Unix_shell)) is common for Mac and Linux. 

> _Linux_ and/or _Unix_ (https://en.wikipedia.org/wiki/Linux, https://en.wikipedia.org/wiki/Unix) 
is another operating system commonly used for networking sytems, robotics, embedded systems 
and other systems that interact closely with hardware. It is often the preferred OS of programmers. Mac's come packaged with 
what is essentially a Linux shell, although Mac calls this environment `Darwin` -- something you occasionally see referenced.

Windows has typically referred to the terminal as the _command window_ and it used slightly different commands (e.g. `dir` instead of `ls`). Now in Windows, 
there is the `power shell` that functions almost identically to a Linux shell. 

For this class, we will move away from Netbeans and start using the command line. Netbeans is an _IDE_ because
it integrates code editing, compilation, execution and debugging. But it automates a lot of functionality that
can interfere with your ability to understand how code works.
In this class, rather than using Netbeans, you will primarily use the VS Code editor along with command line compilation and execution. At some point, we will use Netbeans to look at formal debugging of code.

Here are the most useful and most used shell commands:

|    COMMAND        |     DESCRIPTION      |
| --------------|:-----------------------------------------------|
| `ls` | list all files in the current directory |
| `ls ..` | list all files in the parent directory
| `ls lab01` | list all files in the directory _lab01_ (or whatever directory you list that is within the current directory) |
| `ls -a` | list all files in the current directory, including those that start with a `.`, such as `.git`
| `ls -l` | list all files in the current directory with all information, such as time of creation, size,  permissions, etc. |
| `cd ..` | change the current directory to the parent directory |
| `cd lab01` | change the current directory to _lab01_ (or whatever directory you list) |
| `cd ../lab02` | change the current directory to _lab02_ which is inside the parent directory |
| `cd ~` | change the current directory to your _home_ directory |
| `pwd` | show the current path |
| `mv readme.md ..` | move the file _readme.md_ to the parent directory |
| `cp readme.md ../lab02/.` | copy the file _readme.md_ and place in the folder _lab02_, which is inside the parent directory |
| `rm mainOld.txt` | remove the file _mainOld.txt_ from the current directory |
| `..` | in general refers to the parent directory |
| `.` | in general refers to the current directory |
|    |   |

> Mac and Linux use `/` slashes to dilineate folders, but Windows uses `\`. Try the other slash if things are not working!

At any time while you are typing a command, you can hit `tab` and it will attempt to auto-complete your command.
For example, if you were trying to navigate to csc341F22, you can type `cd csc341` then `tab` and it will finish the
folder name for you.

Also, you can use your arrow keys to scroll through all previous commands that you typed. This comes in 
handy when you are compiling your Java code. It would look like this ...

```
javac *.java
java Main
```

... you make changes to a file and you `up-arrow` 2 times to compile, `return`. `up-arrow` 2 times and `return` to run.

For more information about 


<hr>

## Git

Git is a code repository application that works similarly to Google Drive, except it is designed specifically for coding.
One major difference between using Google drive and Git is that there is a copy of the files maintained both
locally on your machine and on a remote server in the cloud. You can use different services for storing in the cloud, 
such as GitHub and BitBucket. For this class, we will use GitHub.

Git with Github offers a lot of functionality, most of which we will not use. Primarily for this class, GitHub will be used to 
post assignments. You will _pull_ down the repo each time an assignment is posted, which will grab only
what has changed and put it into your git directory.

> "Pro Git", found here https://git-scm.com/book/en/v2, is a great and easy read to learn more about Git.

To get things started, you have to _clone_ the repo. So once you have git installed locally, navigate to the directory
in which you want to place the repository. When you clone the repo, it will create a directory/folder at the location where you issued the command. The folder will have the same name as the repo. 

> NOTE: Be thoughtful about your file management. It is not a good idea to put everything on your desktop. It is not
a good idea to have multiple copies of files all over your machine.

1. Open a terminal.
2. Navigate to the directory in which you want to place the repo.
3. Type `git clone https://github.com/lars1050/csc341F22`
4. `ls` and you should see the new folder. You can also go to your Finder and see it there.
5. `cd csc341F22/labs/lab01.face_recognition`

Now you can edit the lab (or whichever assignment you are working on). The next time an assignment is posted, 

1. Open a terminal.
2. Navigate to the repo so that you are inside the `csc341F22` folder.
3. Type `git pull`

Typically, one uses a repo to both pull from a repo and _push_ to a repo to contribute changes. For group
projects, this gives everyone easy access to all the code and incorporate other's work into their own.
As an individual programmer, it provides a way to work on code from different machines, and importantly,
creates a back-up and a log of all code changes (which can easily be undone or branched to a different version).
You cannot push to the course repo because you do not have permission (only the pulling is public).

> If you are switching between machines, for example between a laptop at school and a PC at home, and you 
want to use git and a cloud service to manage that, please attend Dr. Larson's office hours to discuss
(unless you already know how to do this). It should be noted that all repos are public on GitHub
unless you pay for a membership. On the other hand, all repos on BitBucket are private.

<hr>

#### VS Code

Visual Studio Code (VS Code) is an open source editor designed specifically for coding. The file
extension of the file (e.g. .py, .java, .cpp) is an indication of the programming language being used.
The editor has packages for different languages that automatically control things like spacing, braces and 
color coding based on the language. 

VS Code is moving more and more towards the functionality of an IDE, yet it remains
transparent and the programmer still has a lot of control over the file management. One great feature is 
the integrated Terminal with the editor. When configured, it will have the same window structure as 
Netbeans with all the files in the left sidebar, code editing in the main window, and the terminal
at the bottom to see the output of the program.

If you see the VS Code icon with the .java files in your Finder, then you can just double-click 
a file and it will open in VS Code. 
If there is a different icon (like Netbeans), then right-click the file and choose to open it with VS Code.

> To permanentaly change all files to automatically open with VS Code, right-click the file and 
view Preferences (or maybe Information, depending on your OS). Select VS Code and check the box
to make this the default for all files.

Once VS Code is open, go to the dropdown "File" menu and choose to open a file. 
Navigate to the enclosing FOLDER and open the folder. This will create a left sidebar with all files from that folder.

Once you have the folder open, select the pulldown menu _Terminal_ and choose "New Terminal".
Now you are ready to compile the code within the terminal. Notice that the path in the Terminal
matches the location of the folder you opened 
(although if it does not, then you need to navigate to the directory within the terminal).





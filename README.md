# CS180_Project 4_Learning_Management_System_059

## Instructions to compile and run the project:

In order to compile the project

## Submissions

### Project Description
Our choice is option one, to implement a learning management system discussion board. The Discussion Board gives access to teachers to create discussion forums and allows students to post replies. This discussion board works similar to the discussion boards on brightspace. Teachers are allowed to add, edit and delete courses while students can access the discussion posts and forums within these courses. Our implementation also allows students to vote for the best discussion posts within the forum.

### Class Descriptions

#### User.java:
An abstract class that holds a static ArrayList of DiscussionForum instances.
It has two subclass, Student.java and Teacher.java
A static ArrayList of forum is stored in User class, which can be access be multiple users.

#### Teacher.java extends User.class
A class that represents a teacher

#### Student.java extends User.class
A class that represents a student and takes care of the functions students can perform in the discussion board. Specifically, students are able to view the courses on their dashboard, create their own replies to discussions, and upvote other students' posts.

#### DiscussionForum.java
A class that represents a discussion forum

#### DiscussionPost.java:
A class that represents posts in a discussion forum. This class includes the functionality for teachers and students through their ability to edit, create, and reply to posts.

#### userActivites.java
This is the major class that holds all the operations and menus

#### Course.java
A class that represents a course. A course is identified by its title. There are forums in a course

#### Courselist.java
This class helps to store the data to local file

#### DataManager.java
A class that helps to read and store the user information in a format of
 * ************************************
 * username
 * password
 * User Type(T for Teacher, S for Student)
 * ************************************

#### Vote.java
This class represents a vote.

### Exceptions Descriptions

#### AcountInfoNotMatchException.java
Exception is thrown when the username entered doesn't exist or the password is incorrect.

#### AlreadyVotedException.java
Exception is thrown when a student has already voted and is attempting to vote again

#### NoPermissionException.java
Exception is thrown when a user of a type does not have permission to do the intended operation. For example, a user of type teacher cannot vote and a user of type student cannot create or edit courses. This exception is thrown when an attempt is made.

#### NoSuchTargetException.java
Ecxception is thrown when a specified course, forum, post or reply does not exist.

#### TeacherCannotVoteException.java
Exception is thrown when a teacher user attemps to vote.

#### UsernameAlreadyTakenException.java
Exception is thrown when a user enters a username that is already on file while creating an account.

### Program Decription
In this thread, the user is asked to do the following things in linear order
1. Read from files to update users information, forum information (including the posts in forums)
2. Ask if they to create an account or log in 
   1. If they want to create the account, then 
      1. let them enter a username 
         1. if the username is taken, handle exception and repeat [a.]
         2. if the username is available, proceed program 
      2. let the user enter the passcode
      3. assign the user to UserActivities.currentUser
   2. If the user want to log in 
      1. let them enter username and password
      2. check if match with Users info
         1. match, assign the user to current user, proceed the program
         2. not match, handle exception, return to beginning of 2.
   3. Proceed to 3. 
3. select from menu
   1. Create forum
      1. Add a DiscussionForum instance in User.forums, then repeat 3 
      ###### P.S. Handle the exception if the user does not have permission
   2. Edit forum 
      Edit the given forum's topic with a user input, which is the topic of the forum, then repeat 3
      ######P.S. Handle the exception if the user does not have permission
   3. Delete forum 
      1. Delete the given forum, then repeat 3
      ######P.S. Handle the exception if the user does not have permission
      ######P.S. Handle the exception if the given forum does not exist
   4. Choose a forum 
      1. proceed to 4
   5. Log out 
      1. proceed to 8
4. select forum
   a. e.g. forum one (topic)
   proceed to 5
   b. e.g. forum two
   proceed to 5
   c. e.g. forum three
   proceed to 5
   d. back to last menu
   back to 3
5. select action (Display the topic of the forum selected)
   a. add post
   add the post, and repeat 5
   b. reply post
   proceed to 6
   c. back to last menu
   back to 4
   d. log out
6. select action
   a. e.g. post one (the first 30 character...)
   proceed to 7
   b. e.g. post two
   same with a.
   c. e.g. post three
   same with a.
   d. back to last menu
   back to 3
7. select action
   a. import from file
   let the user enter a file name, add the reply and back to 5
   b. enter reply
   let the user enter a String type reply, and add the reply, then back to 5
8. Log out
   a. save the user info again
   b. save the forum (and the post in it)
   c. End the program

#### UserInfo.txt
The text file that includes all the user data
In the format showing below:
Username
Password
User Type (T for Teachaer, S for Student)

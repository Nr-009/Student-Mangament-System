## School Management System

The school management system is an application that allows small academies manage and organize 
all the students, teachers and classes information in one single application. 
The application will allow teachers to set grades, register and set absences for each student,
as well as be a platform where students can check in their grades and register or drop classes.

I was inspired to create this application as during my last volunteer as a math teacher in a chess academy, I notice 
that they did not have a good system for tracking attendance, nor to track the classes they were teaching. This due to
the cost it implies the construction of one of those sites as well as its maintenance. This project will allow all 
this starting academies have a **reliable**, **free** and **easy** system to track all their information.  

### User Stories:

- As a teacher I want to create a student and add it to the list of students in the class I am teaching
- As a student I want to see my grades and drop one of my classes
- As a student I want to edit my information and edit my address
- As a teacher I want to assign a grade to a specific student
- As a teacher I want to be able to save the changes I have done to my classes.
- As a student I want to be able to load the previous changes of my registration 

<img alt="Photo of the Academy" height="250" src="https://greekreporter.com/wp-content/uploads/2018/11/knowledge-e1542040512810.jpg" width="500"/>

# Instructions for Grader  

- In the package gui run the class StartFrame, click on the image and select last version
- In the login enter the login Name: 0 and password: fisica12.  
- In the teacher menu click on the blue button creating or delete Classes
- To add a class just put the fields on Create Class, the id 0 to assign it to your current user 
in ID of teacher. After submit you may see the class has been added in the table 
- You may also delete your classes by putting the id of the class show on the table, though you can only delete the
classes that are shown to have teacher id of 0. This restriction is due to only being able to delete classes you teach.
- The visual component was the image you had to click first when starting the application
- To save the user story you press the logout button and say yes to save
- To load the last changes you have to when starting again  Startframe, choose last version.  

### Phase 4: Task2:
- User started with Saved DataSystem Thu Mar 30 13:14:10 PDT 2023
- Teacher with id 0 logged in Thu Mar 30 13:14:17 PDT 2023
- Student: Athena Kadirov,id: 4 created Thu Mar 30 13:14:40 PDT 2023
- Teacher Liliana Avila, id :7 created Thu Mar 30 13:14:56 PDT 2023
- Teacher: Gregor Gregor ,id: 2 deleted Thu Mar 30 13:15:08 PDT 2023
- AcademyClass: CPSC310 ,id: 8 created Thu Mar 30 13:15:49 PDT 2023
- Teacher with id 0 logged in Thu Mar 30 13:16:12 PDT 2023
- Teacher Nicolas  El Inmortal, id :0 changed his fn Thu Mar 30 13:16:13 PDT 2023
- Teacher Nicolas Mickelsen, id :0 changed his ln Thu Mar 30 13:16:13 PDT 2023.  

### "Phase 4: Task 3":
-The main problem in the structure of the project is the tightly coupled relationship the classes Academy Class, 
Student, and Teacher have. There are unnecessary bidirectional relationships, which both occupy excessive space and
make the performance slow as they require constant traversal, deletion, and addition of objects in their respective 
list. We could solve that by having each one, have either a set or a map that uses mainly the id and not the object. 
For instance, when needing to add a class, we would just depend on DataSystem to add the id of the student to the set 
of Id in the AcademyClass and also to add the Id of the AcademyClass into the Map of id to grades in the student. 
This would eliminate the bidirectional relationships and increase the cohesion of the DataSystem class, because right 
now, DataSystem is mostly working as the place to store the data rather than actually being the supposed connector of 
all the classes of the system.  
# Testing of Accounting System

The purpose of our project is to test the accounting system through the development of several types of tests. </br>
For the realization of the project we used Java in combination with the Spring Boot Framework.

You can find the initial project here: https://github.com/gabrieldim/Accounting-System 


### Software organization:
• **Repository package**- For each connection to the database that inherited from JpaRepository tests have been done to properly add a column to the database, delete a column from the database as well as find all the added objects it has. These are Junit tests that are organized according to the origin of the connection. </br>
• **Service package**- We tested the service layer using the Mockito Framework. Here we covered the tests for taking all objects from the database, deleting and taking an object according to an identifier, creating a new object as well as finding an object according to similarities in the names.</br>
• **Controllers package** - Test API’s.</br>
• **Model package** - We made mutations for the PitTest for more methods inside the model.</br>





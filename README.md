# CiphyerByteProjects

## Guess the Number Game
### Description:
The Guess the Number Game is a Java project developed using Eclipse IDE. It generates a random number between 1 and 100 and allows users to guess the number within a limited number of attempts.

### Key Features:
1. Random Number Generation: The game generates a random number between 1 and 100.
2. User Interaction: Users are prompted to enter their guessed number.
3. Limited Attempts: Users have a maximum of 5 attempts to guess the number.
4. Scoring: The game provides a score based on the number of attempts used.

### Technologies Used:
1. Java
2. Eclipse IDE

### How to Use:
#### Setup:
Ensure Java and Eclipse IDE are installed on your system.

#### Running the Game:
Clone the repository or download the project files.
Open the project in Eclipse IDE.

#### Executing the Game:
Locate the main Java file (e.g., GuessTheNumberGame.java).
Compile and run the file to start the game.

#### Gameplay:
1. Once the game starts, a random number between 1 and 100 will be generated.
2. You will be prompted to enter your guessed number.
3. After each guess, the game will inform you if your guess is correct or provide a hint (higher/lower).
4. Continue guessing until you either guess the correct number or exhaust your 5 attempts.

#### Scoring:
The game will provide a score based on how quickly you guess the correct number.

#### Restarting the Game:
To play again, restart the program from the beginning.


## Online Examination Application:
The Online Examination Application is a Java-based web application developed using Maven and Eclipse IDE. It allows users to register, login, update their profile and password, take exams, and view their exam scores. The application is designed to manage a set of 10 general knowledge questions stored in a MySQL database.

### Features:
1. User Registration and Authentication: New users can register with the application by providing necessary details. Registered users can securely authenticate themselves using their credentials.

2. Profile Management: Users can update their profile information such as name, email, and other relevant details. Passwords can be changed securely through the application.

3. Exam Management: The application includes a set of 10 general knowledge questions stored in a MySQL database. Users can select and attempt exams from available options.

4. Exam Taking: Users can attempt exams within a specified time limit. Answers are recorded and evaluated upon completion of the exam.

5. Scoring: Scores are calculated based on the number of correct answers given by the user. Users can view their scores and performance feedback post-exam.

### Technologies Used: 
1. Java
2. Maven
3. Eclipse IDE
4. MySQL
5. JDBC for database connectivity

### Setup Instructions:
1. Database Setup:
Ensure MySQL is installed and running.
Create a database named online_exam_app.
Import the provided SQL schema (online_exam_app.sql) to create the necessary tables and populate initial data (10 questions on general knowledge).

2. Application Configuration:
Clone the repository from GitHub.
Import the project into Eclipse IDE.
Configure database connection settings (src/main/resources/application.properties).

3. Build and Run:
Build the project using Maven (mvn clean install).
Run the application as a Java application in Eclipse or deploy the WAR file to a servlet container like Apache Tomcat.

4. Accessing the Application:
Open a web browser and navigate to http://localhost:8080/online-exam-app (adjust port number if necessary).
Register a new user, login, update profile information, and take exams.

5. Usage:
i. User Registration and Login:
Create a new account by filling out the registration form.
Log in using your registered credentials.

ii. Profile Management:
Update your profile details such as name, email, and password securely.

iii. Exam Taking:
Select an exam from the available options.
Answer the questions within the allocated time frame.
Submit the exam to view your score and feedback.

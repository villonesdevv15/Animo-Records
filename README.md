# Animo-Records
Final Project in Programming 1 | Student Record Management System

# OFFICIAL MANUAL
# Animo Records (JavaFX)
<img width="952" height="603" alt="image" src="https://github.com/user-attachments/assets/612681aa-4d0a-411c-8118-3b890f5a38aa" />

A simple desktop app to manage student records.

<img width="918" height="653" alt="image" src="https://github.com/user-attachments/assets/66302efa-84c2-4d22-9700-511674b4d104" />

# FLOW CHART
<img width="2880" height="4080" alt="fundamentals flowchart " src="https://github.com/user-attachments/assets/164ec0f4-83a2-431f-a5e9-d4a4abdf65d0" />


## Features
- Has a login screen (admin account: `admin` / `tagalogmasarap`)  <!--dagdagan niyo if possible like student>
- The given user could also make their own account to access the information but they could not delete nor add account
- Can add, update, delete students
- Has Search bar for ID, name, or course
- Click a table row to edit it
- Records are saved automatically to `students.csv` <!--file handling mostly .csv ginagamit rather than .txt>

## The Structure of the Project
<!--Change the structure if ever 
you've change the directory of the files-->
    src/main/java/studentrecords/
        Main.java                 starts the app, shows login
        LoginController.java      checks credentials, opens dashboard
        DashboardController.java  add / update / delete / search
        Student.java              student model
        StudentStorage.java       reads/writes students.csv
    src/main/resources/studentrecords/
        login.fxml
        dashboard.fxml

## Run with Maven (JDK 25+)
    mvn javafx:run

## Run in IntelliJ / Eclipse
1. Open the folder as a Maven project (or add the JavaFX SDK to your project).
2. Run `studentrecords.Main`.
3. If you add the SDK manually, use these VM options:
   `--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml`

Change `javafx.version` in `pom.xml` if you use a different JavaFX version.

## FOR VS CODE 
1. Download JavaFX 27 `https://openjfx.io/`
2. Download Extension Pack for Java
3. Open `AnimoRecords` folder and locate Main.java on `src/main/java/studentrecords/Main.java
4. `RUNNING THE PROGRAM` to manually run it press `Ctrl + Shift + B`

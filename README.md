# Mortgage Plan API

This application is built with Spring Boot and Maven build tool. 

## How to start the application on terminal

In order to start the application, please proceed in the following 3 steps. If your local machine does not have `mvn` and `java` Java JDK installed, consider having them installed first.

You can use these command lines to install them.

> `sudo apt install maven` 

> `sudo apt install default-jdk`

### Step 1: Clone this repository to your local 
In a terminal window, run:
> `git clone git@github.com:trgngochuyen/mortgagePlan.git`

### Step 2: Build 
Next, please change the working directory to `mortgage`, where there is pom.xml file, and run this to build the project with Maven:
> `mvn package`

### Step3: Run
Finally, go ahead and run the Spring Boot app:
> `java -jar target/mortgageplan-0.0.1-SNAPSHOT.jar`

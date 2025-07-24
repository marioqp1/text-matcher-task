# Text Similarity Matcher

This is a Spring Boot CLI application that compares a reference text file to a group of other text files in a directory. It calculates how similar each file is to the reference based on word overlap (ignoring order), and prints the results sorted by score.

## Tech Stack

- Java 17
- Spring Boot
- Maven

## Project Structure

com.mario.textmatcher
├── config      # Configuration loader from properties file
├── runner      # Main class that runs the task
├── service     # Core logic for similarity calculation
├── model       # Result model class

## Configuration

Set the following properties in src/main/resources/application.properties:

config.reference-file-path=src/main/resources/input/fileA.txt  
config.pool-directory-path=src/main/resources/input/pool

Place your files in:

- Reference file: src/main/resources/input/fileA.txt  
- Pool folder: src/main/resources/input/pool/ (contains fileB.txt, fileC.txt, etc.)

## Run the Application

Using Maven:

mvn spring-boot:run

Or using the JAR (after building it):

java -jar target/textmatcher-0.0.1-SNAPSHOT.jar

## Sample Output

pool/fileB.txt - 50.00%  
pool/fileC.txt - 25.00%

## Build the Project

mvn clean install

This will generate the executable JAR in the target/ directory.

## How It Works

- Reads words from the reference file.
- Compares them with each file in the pool directory.
- Calculates the percentage of words that match.
- Outputs each file’s similarity score.

## Sample Files

src/main/resources/input/  
├── fileA.txt            # Reference file  
└── pool/  
    ├── fileB.txt  
    └── fileC.txt

## Author

Mario Sherif  
Email: Mario.Sherif25@gmail.com  
LinkedIn: https://www.linkedin.com/in/mario-sherif-362389271/

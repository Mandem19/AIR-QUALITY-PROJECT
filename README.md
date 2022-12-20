# Air Quality Control
## Software Engineering IST Course

This is a project made for the Software Engineering Course in INSA LYON
- By Jordan Ukawoko, Albin Perrsson, Luca Bova, Jeremy Demirel

- Object Orientated Programming using Java
- Use of Abstract Classes
- Reads from user input 

## About

This is a java object orientated software designed for an agency to 
- Compute the mean of air quality at a given timespan 
- Identify sensors with similar behaviours based on the mean
- Characterise air quality at a given place 
- In our respitory also exists Class, Use Case & Sequence Diagrams
- Test Cases exist within the code

## How to Compile
On terminal use the instructions:
cd src
javac App.java
javac Attributes.java
java App

- The path for MAC is different to windows. If it does not work and If using a MAC change the path to 

- "AIR-QUALITY-PROJECT/lib/1Year.csv"; for App.java and DataHandler.java 
- "AIR-QUALITY-PROJECT/lib/AttributeType.csv"; for Attribute.Java
- "AIR-QUALITY-PROJECT/lib/SensorsData.csv"; for Sensors.java

on private static final String PATH = for each of the files mentioned above

However if this does not work (there was some errors
calling the CSVS when compiled for some reason), However it does work in an IDE, if it does not work  then please open the
project in an IDE and run App.java. User will be greeted
with user inputs for what they want to do (get mean, Characterise air quality etc)

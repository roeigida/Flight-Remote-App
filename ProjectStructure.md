
# Project Structure and Description
The structure of the application is based on the MVVM Design Pattern which divides the project files and its departments into 3 main parts, the Model, the ViewModel and the View. When each of them has a responsibility for a different part of the app.

## View
#### MainActivity:
This class uses a XML file which defines the application design. It includes several buttons for connecting to the FlightGear server and to start the plane engine, user controls such as seek bars and a Joystick. This class responsible for displaying the app screen, the buttons, the fields and the controls that are used in the app. For this purpose, the class contains ViewModel and does nothing but updating the ViewModel when the user touch the controls or pressing buttons.  

![image](https://user-images.githubusercontent.com/72979371/123118614-75dd3880-d44b-11eb-9da2-89f081737af7.png)  


## View Model
#### ViewModel:
This class drives all the app , it is responsible for the logic of the application and is the one who decides what to do and when, what functions to run and what to send to whom. The class holds the Model and after receiving notifications from the View about changes, it will decide which functions to run in the Model. For example, when the user clicks the connect button, the View notifies the ViewModel and it send the IP and Port addresses to the Model.

## Model
#### Model:
This class responsibles for connecting (creating the
Socket) and sending the relevant information to the
FlightGear. The class functions called from the
ViewModel after it has received notifications from the
View. For example, when clicking the start engine button, the View notifies the ViewModel that will notify the Model which will send to the FlightGear the required commands to start the engine.

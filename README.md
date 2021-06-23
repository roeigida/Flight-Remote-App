# Flight-Remote-App

#### Contributes
* Tomer Shay
* Roei Gida

This is an android application for controlling FlightGear flight simulator.

1. [General](#General)
    - [Background](#background)
    - [Project Description](https://github.com/tomershay100/Flight-Inspection-App/blob/main/README.md#project-description)
    - [Project Stucture](https://github.com/tomershay100/Flight-Inspection-App/blob/main/README.md#project-stucture)
    - [Features](https://github.com/tomershay100/Flight-Inspection-App/blob/main/README.md#features)
2. [Dependencies](#dependencies)
3. [Installation](#installation)

## General
### Background
This application connect to FlightGear, flight simulator, and let the user control the planes' velocity and directions while the simulator displays the flight.  

### Project Description
  
The application interfaces with the FlightGear simulator (instruction for download at [Dependencies](#dependencies)) and they work side-by-side. The idea is that the user will connect to flightGear simulator with the FlightGears' IP and Port and will control the plane through the controls the app displays. the application will let the user control the throttle, aileron, rudder and the elevator.


### Project Structure
This project designed according to MVVM architecture. The classes can be divided into two groups in order to create total segregation between the presentation logic and the business logic.
The presentation logic implemented in:
* View class
* JoystickView class

The business logic implemented in:
* Model class

This classes can communicate via the ViewModel class that constitutes as an abstract Model layer to the View and as an abstract View layer to the Model.
You can see more information about the class hierarchy in [UML](https://github.com/roeigida/FlightRemote/blob/master/FlightRemoteApp%20UML.pdf).

### Features
* **Connect button** When the user clicks on ```connect``` button, a connection is made to the FlightGear server using the entered IP and PORT addresses.
* **Start engine:** When clicking the ```Start Engine``` button the planes' engine will start.
* **SeekBars:** When moving the horizontal ```seek bar``` the user can control the rudder and by moving the vertical ```seek bar``` the user can control the throttle.
* **Joystick:** Joystick: When moving the ```Joystick``` up and down the user can control the elevator value and by moving the joystick to the sides you can control the aileron value.

For more features explanations, you can watch [this video](https://youtu.be/t_-Bs4jf07Y).


## Dependencies
1. [FlightGear](https://www.flightgear.org/download/)
2. [.NET 5.0](https://dotnet.microsoft.com/download/dotnet-framework/net48)
3. [Oxyplot](https://www.nuget.org/packages/OxyPlot.Wpf/2.1.0-Preview1)
4. [CircularGauge](https://www.nuget.org/packages/CircularGauge)

## Installation
1. Open FlightGear from command line:
     ```
    $ cd C:\Program Files\FlightGear 2020.3.6
    $ cd bin
    $ start fgfs.exe --telnet=socket,in,10,127.0.0.1,5400,tcp
    ```
   Notice that ```C:\Program Files\FlightGear 2020.3.6``` is the path to the place where you download the FlightGear.

2. Click _fly_ on FlightGear.

3. Clone the repository from **another** command line:
    ```
    $ git clone https://github.com/tomershay100/Flight-Inspection-App.git
    ```
4. Run the program:
     ```
    $ cd Flight-Inspection-App
    $ cd bin
    $ start DesktopApp.exe
    ```
Notice it may take a while.

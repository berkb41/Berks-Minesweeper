# Berk's Minesweeper Game

## Playing and Rules
Minesweeper is a logic-based game where players uncover squares on a grid without detonating hidden mines. 
Numbers on revealed squares indicate how many mines are adjacent to that square, allowing players to deduce the positions of the mines.
Minesweeper is a puzzle video game. In the game, mines (that resemble naval mines in the classic theme) are scattered throughout a board, which is divided into cells. Cells have three states: unopened, opened and flagged. An unopened cell is blank and clickable, while an opened cell is exposed. 
Flagged cells are those marked by the player to indicate a potential mine location.

A player selects a cell to open it. If a player opens a mined cell, the game ends. 
Otherwise, the opened cell displays either a number, indicating the number of mines diagonally and/or adjacent to it, or a blank tile (or "0"), and all adjacent non-mined cells will automatically be opened. 

## Technologies
- **Java**: The core programming language used for the game logic and implementation.
- **Swing**: The Java GUI toolkit used for building the graphical user interface.

## How To Run
- **Pre-requisites**: Java Development Kit (JDK) / Ensure you have a compatible version of the Java Development Kit (JDK) installed on your system.

> git clone https://github.com/berkb41/Berks-Minesweeper
>
> javac org/minesweeper/*.java
>
> java org.minesweeper.Minesweeper

- **From Intellij or any other Java IDE**: Run Minesweeper.java Run as a class with any JDK supports Java 11+
- **Using Docker**: You can also run the code via Docker if you follow those simple steps, but first ensure Docker Engine installed
> docker build -t minesweeper .
> 
> docker run -it minesweeper

## How To Run Tests

### Pre Requisites: Maven

Suggested method for running tests is:
> cd Berks-Minesweeper-Maven
> 
> mvn clean install

By running this commands you can initially install Junit dependencies from Maven repo,
After installing Junit, tests are automatically executed.
To see tests src/main/tests folder can be visited
(Test coverage is exceptionally low for a production application but due to time limitations main parts are covered)

## Advanced Parts
### Enhanced adjacent reveal:
Although not stated in the requirements, enhanced adjacent reveal algorithm added to help if empty cell clicked it also reveals other empty cells and adjacent cells next to mines

### Three levels of game
There are Beginner, Medium and Expert option for playing which makes it more fun.

### Mine positions are preserved for each game
Mines are in the fixed location

### HashSet usage shortened application code & checks
Since set is only contatining unique values, usage of hashset made code block shorter.

### Dockerization support
By using technology like Docker, you can easily set your running environment and deploy the application to the cloud

### Tests are included
Although coverage is low (Below Section for Details) there are unit tests which lay out the foundation, by having more time, production level coverage can be included.

## Things Can Be Improved

### Test coverage
Test coverage cannot reach %80 due to time limitations however it is important sufficient test coverage in place for production applications

### Abstraction Level
There are improvements for better abstraction when it comes to object oriented design. Currently mines are represented -1, empty cells 0 and other cells with count of adjacent mines. There could be cell object
And extending MineCell, EmptyCell and AdjacentCell which fits better into production application context

### Refactoring
If there would be more time, code could have been improved with better practices

### Concurrency Support
Maybe for that scale, can be overkill. However tasks in the game can be threaded and parallelized by implementing safe concurrency mechanisms to improve performance

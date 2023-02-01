# BlackjackGame
Team project

Design Considerations:

Inheritance<br>
Blackjack is one kind of the card game, it is the subclass of the card. Also,
accessing the same data type declared by superclass. Use enum to implement suit
and values to be more loose coupling design.
Playgame extends Game class, override the method and delegate the jobs from
Game, focus on playing the game and declaring the winner.
Composition<br>
Each Game class must have a dealer, who is the composition of the game.
Implementing Game as abstract class, it can be more flexible for the other subclass
to focus on the concrete thing and encapsulated the method.
Player needs to validate first before entering the game, increasing the validator
class to do specific thing to be more cohesiveness.
Aggregation<br>
Each game accommodates 2 to 7 players, every player has a unique name with
private String data type, and Game class has scope that contains Arraylist of player
data type, it is organized construction.

UML Class Diagram

<img width="559" alt="Card Game Project" src="https://user-images.githubusercontent.com/77931757/216165499-1dbb4cfd-fc23-453e-8186-0419d9b8e492.png">


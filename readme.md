# School project: Tic Tac Toe
> The actual project was supposed to be outputted in the Console window with no GUI as at the time of creation the school course was still at the introduction level to Java, but I am studying on my own and it happened that someone was talking about JavaFx which I fell in love with, so I created the project with JavaFx as an own training to try to learn JavaFX.

------------


## The Challenge:

As simple as the GUI looks like still there is a ton of logic behind everything the user sees.
The GUI was built using Scene Builder and FXML files.
As the logic lives in the Controller class of the FXML file you can imagine that the code would grow insanely long, this had to be solved.

## The idea behind the solution:
The obvious solution would be to divide the logic into smaller digestible chunks! As I am a complete newbie, I didn’t know how to divide the Controllers (actually the GUI into separate FXMLs per Pane!).
So I started researching on how to use nested FXML files in my main FXML file which I found to an amazing solution and an absolute beauty that JavaFx has!

## Implementing the solution:
I had absolutely no clue on how to make the Controllers recognize the instances of the other Controllers that I created in them!
After 2 whole days of reading and trying I found out my foolish mistake of not using the @FXML annotation + actually adding the fx:id to the main FXML file!
Which worked beautifully!

### Notes about the GUI:
- The application panes are set to transparent
- All the images for the UI were designed by me (as silly as they look!)
- The images are in the form of transparent PNGs.
- The UI is divided to smaller panes
 - Title pane
 - Operation pane
 - Board pane.

I’ve created a simplified example for those who want to learn about injecting Controllers in a multiple FXML environment: [JavaFx multiple Controllers communications. – (tutorial)](https://github.com/MohamadOjail/JavaFx-multiple-Controllers-communications-tutorial.git "JavaFx multiple Controllers communications. – (tutorial)")

## Here’s a little demo:
![](/images/demo.gif)

`one side note: the project was created before I learned how to use Github`
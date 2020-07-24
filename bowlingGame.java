import java.util.Arrays;

public class bowlingGame {

	public static void main(String[] args) {
		
		bowlingInterface theView = new bowlingInterface();	//creating the bowling interface
		bowlingCalculations calculatedResults = new bowlingCalculations(theView);	//passing the interface to the model which does the calculations
		theView.setVisible(true);


	}//end of main class

}//end of bowling Game

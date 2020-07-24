import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bowlingCalculations {
	//Object used to interact with the interface text fields
	private bowlingInterface theView;
	private int totalScore;		//calculates frame results
	private String results;		//returns frame results in layout
	
	//constructor
	public bowlingCalculations(bowlingInterface theView) {
			this.theView = theView;
			this.totalScore = 0;
			this.theView.addCalculateListener(new CalculateListener());
		}
	
	//Button Calculates Results
	class CalculateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//Stores interface text fields in arrays
			String[][] nineFrames = new String[9][2];
			String[] tenthFrame = new String[3];
			
			nineFrames[0][0] = theView.getFrameOneInputOne();
			nineFrames[0][1] = theView.getFrameOneInputTwo();
			nineFrames[1][0] = theView.getFrameTwoInputOne();
			nineFrames[1][1] = theView.getFrameTwoInputTwo();
			nineFrames[2][0] = theView.getFrameThreeInputOne();
			nineFrames[2][1] = theView.getFrameThreeInputTwo();
			nineFrames[3][0] = theView.getFrameFourInputOne();
			nineFrames[3][1] = theView.getFrameFourInputTwo();
			nineFrames[4][0] = theView.getFrameFiveInputOne();
			nineFrames[4][1] = theView.getFrameFiveInputTwo();
			nineFrames[5][0] = theView.getFrameSixInputOne();
			nineFrames[5][1] = theView.getFrameSixInputTwo();
			nineFrames[6][0] = theView.getFrameSevenInputOne();
			nineFrames[6][1] = theView.getFrameSevenInputTwo();
			nineFrames[7][0] = theView.getFrameEightInputOne();
			nineFrames[7][1] = theView.getFrameEightInputTwo();
			nineFrames[8][0] = theView.getFrameNineInputOne();
			nineFrames[8][1] = theView.getFrameNineInputTwo();
			tenthFrame[0] = theView.getFrameTenInputOne();
			tenthFrame[1] = theView.getFrameTenInputTwo();
			tenthFrame[2] = theView.getFrameTenInputThree();
			
			//Loop through the first 9 frames and shows calculated results
			for (int i = 0; i < nineFrames.length; i++) {	
				if(isValid(nineFrames[i][0],nineFrames[i][1])) {	//checks validity of initial inputs
					if (nineFrames[i][1].equals("/") && i != nineFrames.length-1) {
						spareCalculations(nineFrames[i+1][0]);
					}else if (nineFrames[i][1].equals("/") && i == nineFrames.length-1) {
						spareCalculations(tenthFrame[0]);
					}else if((nineFrames[i][1].equals("x") || nineFrames[i][1].equals("X")) && i == 7 && ((nineFrames[i+1][1].equals("x") || nineFrames[i+1][1].equals("X")))) {
						strikeCalculations(nineFrames[i+1][1], tenthFrame[0]);
					}
					else if((nineFrames[i][1].equals("x") || nineFrames[i][1].equals("X")) && i != nineFrames.length-1) {
						strikeCalculations(nineFrames[i+1][0], nineFrames[i+1][1]);
					}else if((nineFrames[i][1].equals("x") || nineFrames[i][1].equals("X")) && i == nineFrames.length-1) {
						strikeCalculations(tenthFrame[0],tenthFrame[1]);
					}
					else {
						simpleCalculations(nineFrames[i][0],nineFrames[i][1]);
					}
				}else {
					//returns error message if initial inputs are not valid
					theView.displayErrorMessage("Incorrect Input");
					System.exit(0);
				}
				showFrameResults(i);
			}
			
			//10th frame calculations
			if(isValid(tenthFrame[0],tenthFrame[1]) && isValid("0",tenthFrame[2])) {	//checks validity of initial inputs
				final10thFrameCalculations(tenthFrame[0],tenthFrame[1],tenthFrame[2]);
			}else {
				//returns error message if initial inputs are not valid
				theView.displayErrorMessage("Incorrect Input");
				System.exit(0);
			}
			
		}
	}
	
	//Method used to add 2 numbers and stores those results
	public void addNumbers(String frameOne, String frameTwo) {
		
		int fOne = 0;
		int fTwo = 0;
		
		fOne = Integer.parseInt(frameOne);
		fTwo = Integer.parseInt(frameTwo);
		//returns error message the two in each frame digit value exceeds 9
		if(fOne+fTwo >= 10) {
			theView.displayErrorMessage("Incorrect Input");
			System.exit(0);
		}
		
		totalScore = totalScore + fOne + fTwo;
		results = Integer.toString(totalScore);
		
	}
	//Method used to calculate a spare and store the results
	public void spareCalculations(String nextBallValue) {
		
		if (isNumber(nextBallValue)) {
			totalScore = totalScore + 10 + Integer.parseInt(nextBallValue);
		}else {
			
			if(nextBallValue.equals("-")) {
				totalScore = totalScore + 10 + 0;
			}else if(nextBallValue.equals("x") || nextBallValue.equals("X") || nextBallValue.equals("")) {
				totalScore = totalScore + 10 + 10;
			}
		}
		
		results = Integer.toString(totalScore);
	}
	//Method used to calculate a strike and store the results
	public void strikeCalculations(String nextBallOne, String nextBallTwo) {
		
		if(isNumber(nextBallOne) && isNumber(nextBallTwo)) {
			totalScore = totalScore + 10 + Integer.parseInt(nextBallOne) + Integer.parseInt(nextBallTwo);
		}
		if(isGutterBall(nextBallOne) && isGutterBall(nextBallTwo)) {
			totalScore = totalScore + 10;
		}
		if(isNumber(nextBallOne) && isGutterBall(nextBallTwo)) {
			totalScore = totalScore + 10 + Integer.parseInt(nextBallOne);
		}
		if(isGutterBall(nextBallOne) && isNumber(nextBallTwo)) {
			totalScore = totalScore + 10 + Integer.parseInt(nextBallTwo);
		}
		if(isGutterBall(nextBallOne) && isSpare(nextBallTwo)) {
			totalScore = totalScore + 10 + 10;
		}
		if(isNumber(nextBallOne) && isSpare(nextBallTwo)) {
			totalScore = totalScore + 10 + 10;
		}
		if(isStrike(nextBallOne) && isGutterBall(nextBallTwo)) {
			totalScore = totalScore + 10 + 10;
		}if(isStrike(nextBallOne) && isNumber(nextBallTwo)) {
			totalScore = totalScore + 10 + 10 + Integer.parseInt(nextBallTwo);
		}
		if(isStrike(nextBallOne) && isStrike(nextBallTwo)) {
			totalScore = totalScore + 10 + 10 + 10;
		}
		
		results = Integer.toString(totalScore);
	}
	//Method used to check for gutter balls
	public boolean isGutterBall(String value) {
		if(value.equals("-")) {
			return true;
		}
		return false;
	}
	//Method used to check for strikes
	public boolean isStrike(String value) {
		if(value.equals("x") || value.equals("X")) {
			return true;
		}
		if (value.equals("")) {
			return true;
		}
		return false;
	}
	//Method used to check for spares
	public boolean isSpare(String value) {
		if(value.equals("/")) {
			return true;
		}
		return false;
	}
    //Method used to check for correct initial inputs
    public boolean isValid (String input1, String input2) {
    	boolean check1 = false;
    	boolean check2 = false;
    	String[] validInput1 = {"","0","1","2","3","4","5","6","7","8","9","x","X","-"};
    	String[] validInput2 = {"0","1","2","3","4","5","6","7","8","9","x","X","/","-"};
    	
    	for(int i =0; i < validInput1.length; i++) {
    		if(input1.equals(validInput1[i])) {
    			check1 = true;
    			break;
    		}
		}
    	
    	for(int i =0; i < validInput2.length; i++) {
    		if(input2.equals(validInput2[i])) {
    			check2 = true;
    			break;
    		}
		}
   
    	if(input1.equals("-") && input2.equals("x")) {
    		check2 = false;
    	}
    	
    	if(input1.equals("-") && input2.equals("X")) {
    		check2 = false;
    	}
    	
    	if(check1 && check2) {
    		return true;
    	}
    	
    	return false;
    }
    //Method used to check if the value in the text field is a number
    public boolean isNumber(String nextFrame) {
    	switch(nextFrame)
    	{
    	   case "0" :
    	      return true;
    	   case "1" :
    	      return true;
    	   case "2" :
     	      return true;
     	   case "3" :
     	      return true;
    	   case "4" :
     	      return true;
     	   case "5" :
     	      return true;
    	   case "6" :
     	      return true;
     	   case "7" :
     	      return true;
    	   case "8" :
     	      return true;
     	   case "9" :
     	      return true;
    	   default : 
    	      return false;
    	}
    }
    //Method used for simple frame calculations
    public void simpleCalculations(String fOne, String fTwo) {
    	if(isNumber(fOne) && isNumber(fTwo)) {
    		addNumbers(fOne,fTwo);
    	}else if (isNumber(fOne) && isGutterBall(fTwo)) {
    		addNumbers(fOne,"0");
    	}else if (isNumber(fTwo) && isGutterBall(fOne)) {
    		addNumbers("0",fTwo);
    	}else if (isGutterBall(fTwo) && isGutterBall(fOne)) {
    		addNumbers("0","0");
    	}
    }
    //Method used to show the first 9 frame results in the layout
    public void showFrameResults(int frameResults) {
    	switch(frameResults) {
 	   		case 0 :
 	   			theView.setFrameOneResults(results);
 	   		case 1 :
 	   			theView.setFrameTwoResults(results);
 	   		case 2 :
 	   			theView.setFrameThreeResults(results);
 	   		case 3 :
 	   			theView.setFrameFourResults(results);
 	   		case 4 :
 	   			theView.setFrameFiveResults(results);
 	   		case 5 :
 	   			theView.setFrameSixResults(results);
 	   		case 6 :
 	   			theView.setFrameSevenResults(results);
 	   		case 7 :
 	   			theView.setFrameEightResults(results);
 	   		case 8 :
 	   			theView.setFrameNineResults(results);
		}
    }
    //Method use to calculate the 10th frame and show results in the layout
    public void final10thFrameCalculations(String fOne, String fTwo, String fThree) {
    	if(isNumber(fOne) && isNumber(fTwo) && isNumber(fThree)) {
    		addNumbers(fOne,fTwo);
    		addNumbers(fThree,"0");
    	}else if (isNumber(fOne) && isNumber(fTwo) && isGutterBall(fThree)) {
    		addNumbers(fOne,fTwo);
    	}else if (isNumber(fOne) && isNumber(fThree) && isGutterBall(fTwo)) {
    		addNumbers(fOne,fThree);
    	}else if (isNumber(fTwo) && isNumber(fThree) && isGutterBall(fOne)) {
    		addNumbers(fTwo,fThree);
    	}else if (isNumber(fOne) && isNumber(fThree) && isGutterBall(fTwo)) {
    		addNumbers(fOne,fThree);
    	}else if (isGutterBall(fOne) && isGutterBall(fTwo) && isGutterBall(fThree)) {
    		addNumbers("0","0");
    	}else if (fTwo.equals("/")) {
    		spareCalculations(fThree);
    	}else if (fOne.equals("x") || fOne.equals("X")) {
    		strikeCalculations(fTwo,fThree);
    	}else if(fThree.equals("/") || fThree.equals("x") || fThree.equals("X")) {
    		totalScore = totalScore + 10;
    	}else if(fTwo.equals("/") && fThree.equals("/")) {	//error checks 10th frame text field inputs
			theView.displayErrorMessage("Incorrect Input");
			System.exit(0);
    	}
    	results = Integer.toString(totalScore);
    	theView.setFrameTenResults(results);
    }//end of final10thFrameCalculations
}//end of bowlingCalculations class

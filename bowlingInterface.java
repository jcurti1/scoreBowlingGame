
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bowlingInterface extends JFrame{
	
	//declaring variables for the interface
	private JLabel frameOneTitle = new JLabel("Frame One");
	private JLabel frameOneResults = new JLabel("Frame One Results");
	private JLabel frameTwoTitle = new JLabel("Frame Two");
	private JLabel frameTwoResults = new JLabel("Frame Two Results");
	private JLabel frameThreeTitle = new JLabel("Frame Three");
	private JLabel frameThreeResults = new JLabel("Frame Three Results");
	private JLabel frameFourTitle = new JLabel("Frame Four");
	private JLabel frameFourResults = new JLabel("Frame Four Results");
	private JLabel frameFiveTitle = new JLabel("Frame Five");
	private JLabel frameFiveResults = new JLabel("Frame Five Results");
	private JLabel frameSixTitle = new JLabel("Frame Six");
	private JLabel frameSixResults = new JLabel("Frame Six Results");
	private JLabel frameSevenTitle = new JLabel("Frame Seven");
	private JLabel frameSevenResults = new JLabel("Frame Seven Results");
	private JLabel frameEightTitle = new JLabel("Frame Eight");
	private JLabel frameEightResults = new JLabel("Frame Eight Results");
	private JLabel frameNineTitle = new JLabel("Frame Nine");
	private JLabel frameNineResults = new JLabel("Frame Nine Results");
	private JLabel frameTenTitle = new JLabel("Frame Ten");
	private JLabel frameTen3rdSlot = new JLabel("Frame Ten Third Slot");
	private JLabel frameTenResults = new JLabel("Frame Ten Results");
    private JTextField fOne_InputOne  = new JTextField(5);
    private JTextField fOne_InputTwo  = new JTextField(5);
    private JTextField fOne_Results  = new JTextField(5);
    private JTextField fTwo_InputOne  = new JTextField(5);
    private JTextField fTwo_InputTwo  = new JTextField(5);
    private JTextField fTwo_Results  = new JTextField(5);
    private JTextField fThree_InputOne  = new JTextField(5);
    private JTextField fThree_InputTwo  = new JTextField(5);
    private JTextField fThree_Results  = new JTextField(5);
    private JTextField fFour_InputOne  = new JTextField(5);
    private JTextField fFour_InputTwo  = new JTextField(5);
    private JTextField fFour_Results  = new JTextField(5);
    private JTextField fFive_InputOne  = new JTextField(5);
    private JTextField fFive_InputTwo  = new JTextField(5);
    private JTextField fFive_Results  = new JTextField(5);
    private JTextField fSix_InputOne  = new JTextField(5);
    private JTextField fSix_InputTwo  = new JTextField(5);
    private JTextField fSix_Results  = new JTextField(5);
    private JTextField fSeven_InputOne  = new JTextField(5);
    private JTextField fSeven_InputTwo  = new JTextField(5);
    private JTextField fSeven_Results  = new JTextField(5);
    private JTextField fEight_InputOne  = new JTextField(5);
    private JTextField fEight_InputTwo  = new JTextField(5);
    private JTextField fEight_Results  = new JTextField(5);
    private JTextField fNine_InputOne  = new JTextField(5);
    private JTextField fNine_InputTwo  = new JTextField(5);
    private JTextField fNine_Results  = new JTextField(5);
    private JTextField fTen_InputOne  = new JTextField(5);
    private JTextField fTen_InputTwo  = new JTextField(5);
    private JTextField fTen_InputThree  = new JTextField(5);
    private JTextField fTen_Results  = new JTextField(5);
    private JButton calculateButton = new JButton("Calculate");
    
    
    
    //creating the interface
    bowlingInterface(){
        //Sets up the view and adds the components
        JPanel bowlingView = new JPanel();
        
        //Opens the LayOut in a specific location based off or your screen size
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//closes JFrame operations on exit
        this.setSize(445, 350);	//size of layout by height and width
        
       //Sets up LayOut of Interface
        bowlingView.add(frameOneTitle);
        bowlingView.add(fOne_InputOne);

        bowlingView.add(fOne_InputTwo);
        bowlingView.add(frameOneResults);

        bowlingView.add(fOne_Results);
        
        bowlingView.add(frameTwoTitle);
        bowlingView.add(fTwo_InputOne);

        bowlingView.add(fTwo_InputTwo);
        bowlingView.add(frameTwoResults);

        bowlingView.add(fTwo_Results);
        
        bowlingView.add(frameThreeTitle);
        bowlingView.add(fThree_InputOne);

        bowlingView.add(fThree_InputTwo);
        bowlingView.add(frameThreeResults);

        bowlingView.add(fThree_Results);
        
        bowlingView.add(frameFourTitle);
        bowlingView.add(fFour_InputOne);

        bowlingView.add(fFour_InputTwo);
        bowlingView.add(frameFourResults);

        bowlingView.add(fFour_Results);
        
        bowlingView.add(frameFiveTitle);
        bowlingView.add(fFive_InputOne);

        bowlingView.add(fFive_InputTwo);
        bowlingView.add(frameFiveResults);

        bowlingView.add(fFive_Results);
        
        bowlingView.add(frameSixTitle);
        bowlingView.add(fSix_InputOne);

        bowlingView.add(fSix_InputTwo);
        bowlingView.add(frameSixResults);

        bowlingView.add(fSix_Results);
        
        bowlingView.add(frameSevenTitle);
        bowlingView.add(fSeven_InputOne);

        bowlingView.add(fSeven_InputTwo);
        bowlingView.add(frameSevenResults);

        bowlingView.add(fSeven_Results);
        
        bowlingView.add(frameEightTitle);
        bowlingView.add(fEight_InputOne);

        bowlingView.add(fEight_InputTwo);
        bowlingView.add(frameEightResults);

        bowlingView.add(fEight_Results);
        
        bowlingView.add(frameNineTitle);
        bowlingView.add(fNine_InputOne);

        bowlingView.add(fNine_InputTwo);
        bowlingView.add(frameNineResults);

        bowlingView.add(fNine_Results);
        
        bowlingView.add(frameTenTitle);
        bowlingView.add(fTen_InputOne);

        bowlingView.add(fTen_InputTwo);
        
        bowlingView.add(frameTen3rdSlot);
        bowlingView.add(fTen_InputThree);
        
        bowlingView.add(frameTenResults);
        bowlingView.add(fTen_Results);

        bowlingView.add(calculateButton);

        this.add(bowlingView);
        this.setTitle("Bowling Score");

        // End of setting up the components --------
    }
    
    
    //Text Input Getter Functions
    public String getFrameOneInputOne() {
    	return fOne_InputOne.getText();
    }

    public String getFrameOneInputTwo() {
    	return fOne_InputTwo.getText();
    }

    public String getFrameTwoInputOne() {
    	return fTwo_InputOne.getText();
    }

    public String getFrameTwoInputTwo() {
    	return fTwo_InputTwo.getText();
    }
    public String getFrameThreeInputOne() {
    	return fThree_InputOne.getText();
    }

    public String getFrameThreeInputTwo() {
    	return fThree_InputTwo.getText();
    }
    public String getFrameFourInputOne() {
    	return fFour_InputOne.getText();
    }

    public String getFrameFourInputTwo() {
    	return fFour_InputTwo.getText();
    }
    public String getFrameFiveInputOne() {
    	return fFive_InputOne.getText();
    }

    public String getFrameFiveInputTwo() {
    	return fFive_InputTwo.getText();
    }
    public String getFrameSixInputOne() {
    	return fSix_InputOne.getText();
    }

    public String getFrameSixInputTwo() {
    	return fSix_InputTwo.getText();
    }
    public String getFrameSevenInputOne() {
    	return fSeven_InputOne.getText();
    }

    public String getFrameSevenInputTwo() {
    	return fSeven_InputTwo.getText();
    }
    public String getFrameEightInputOne() {
    	return fEight_InputOne.getText();
    }

    public String getFrameEightInputTwo() {
    	return fEight_InputTwo.getText();
    }
    public String getFrameNineInputOne() {
    	return fNine_InputOne.getText();
    }

    public String getFrameNineInputTwo() {
    	return fNine_InputTwo.getText();
    }
    public String getFrameTenInputOne() {
    	return fTen_InputOne.getText();
    }

    public String getFrameTenInputTwo() {
    	return fTen_InputTwo.getText();
    }
    public String getFrameTenInputThree() {
    	return fTen_InputThree.getText();
    }

    //Text Setter Functions
    public void setFrameOneResults(String value) {
    	fOne_Results.setText(value);
    }
    public void setFrameTwoResults(String value) {
    	fTwo_Results.setText(value);
    }
    public void setFrameThreeResults(String value) {
    	fThree_Results.setText(value);
    }
    public void setFrameFourResults(String value) {
    	fFour_Results.setText(value);
    }
    public void setFrameFiveResults(String value) {
    	fFive_Results.setText(value);
    }
    public void setFrameSixResults(String value) {
    	fSix_Results.setText(value);
    }
    public void setFrameSevenResults(String value) {
    	fSeven_Results.setText(value);
    }
    public void setFrameEightResults(String value) {
    	fEight_Results.setText(value);
    }
    public void setFrameNineResults(String value) {
    	fNine_Results.setText(value);
    }
    public void setFrameTenResults(String value) {
    	fTen_Results.setText(value);
    }
    
    //Action Listner for Calculate Button
    void addCalculateListener(ActionListener listenForCalcButton){

    	calculateButton.addActionListener(listenForCalcButton);
    }

    // Open a popup that contains the error message passed
    void displayErrorMessage(String errorMessage){

    	 JOptionPane.showMessageDialog(this, errorMessage);
     }

}//end of bowlingInterface Class

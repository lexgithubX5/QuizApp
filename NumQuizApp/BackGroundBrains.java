import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BackGroundBrains implements ActionListener{
	JFrame frame = new JFrame();
	JLabel label = new JLabel();//This is the heading Label
	JTextField field = new JTextField();// This is the answer field
	JTextField qus = new JTextField();// This is the question field
	JButton submitButton = new JButton("Enter");
	JButton clearButton = new JButton("Clear");

	
	BackGroundBrains(){
		//header
		label.setBounds(0, 0, 500, 40);
		label.setOpaque(true);
		label.setBackground(new Color(201, 187, 185));
		label.setFont(new Font("Calbiri",Font.ITALIC, 25));
		label.setText("Quiz App! Test your Math Skillz!");
		
		//Buttons
		submitButton.setBounds(400, 302, 70, 40);
		submitButton.addActionListener(this);
        submitButton.setFocusable(false);
		clearButton.setBounds(330, 302, 70, 40);
		clearButton.addActionListener(this);
        clearButton.setFocusable(false);
		
		// Answer Field
		field.setBounds(5, 211, 490, 90);
		field.setOpaque(true);
		field.setFont(new Font("Arial",Font.ITALIC, 25));
		
		//Question Field
		qus.setBounds(5, 44, 490, 150);
		qus.setOpaque(true);
		qus.setBackground(new Color(212, 249, 255));
		qus.setFont(new Font("Monospace",Font.BOLD, 50));
		qus.setEditable(false);
		
		//Frame
		frame.add(field);
		frame.add(submitButton);
		frame.add(label);
		frame.add(qus);
		frame.add(clearButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setBounds(5,5,512,500);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
	}
	ArrayList<String> operators = new ArrayList<>();
	
	Double val=0.0;
	void brains() {
		// Mathematical Operators
		operators.add("+");
		operators.add("-");
		operators.add("x");
		operators.add("/");
		
		//Random Generator
		Random rand = new Random();
		String rndmElem = operators.get(rand.nextInt(operators.size()));
		int x= rand.nextInt(30);
		int y = rand.nextInt(30);
		
		//Test values
		System.out.println(x);
		System.out.println(y);
		System.out.println(rndmElem);
		
		qus.setText(String.valueOf(x)+rndmElem+String.valueOf(y));
		switch(rndmElem) {
		case "+":  val = Double.valueOf( x) + Double.valueOf(y);
		break;
		case "-":  val = Double.valueOf( x) - Double.valueOf(y);
		break;
		case "x":  val = Double.valueOf( x) * Double.valueOf(y);
		break;
		case "/":  val = Double.valueOf( x) / Double.valueOf(y);
		break;
		}
		
//		System.out.println(val);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== submitButton) {
			try {
			double ans = Math.round(Double.parseDouble(field.getText()));
			if(ans==Math.round(val) ){
				field.setText("Correct!");
				field.setForeground(Color.GREEN);
				field.setEditable(false);
			}
			else{
				field.setText("Incorrect! Ans:" + val );
				field.setForeground(new Color(230, 92, 71));
				field.setEditable(false);

			}}
			catch(Exception x) {
				System.out.println(x);
				
			}}
		else if(e.getSource()==clearButton) {
				field.setText("");
				field.setForeground(Color.black);
				field.setEditable(true);
				brains();
			}

	
	

}
}
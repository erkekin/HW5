import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import javax.swing.*;

public class homework5 extends JFrame{


	private static final long serialVersionUID = 1L;
	
	
JPanel jpContainer;
	JPanel jpBlueContainer;
	JPanel jpGreenContainer;
		JPanel jpOrangeContainer;
		JPanel jpYellowContainer;

public homework5(){
	
jpContainer = new JPanel();
jpContainer.setBackground(Color.pink);

GroupLayout layout = new GroupLayout(jpContainer);
jpContainer.setLayout(layout);
getContentPane().add(jpContainer);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	jpBlueContainer = new JPanel();
	GroupLayout layoutBlue = new GroupLayout(jpBlueContainer);
	jpBlueContainer.setLayout(layoutBlue);
	jpBlueContainer.setBackground(new Color(204, 204,255));
	jpBlueContainer.setBounds(50, 20, 550, 150);
	jpContainer.add(jpBlueContainer);
	
		JLabel alabel = new JLabel("A");
		alabel.setBounds(10, 10, 200, 30);
		jpBlueContainer.add(alabel);
		final JTextField aTextField = new JTextField(10);
		aTextField.setBounds(10, 40, 500, 30);
		jpBlueContainer.add(aTextField);
		
		JLabel blabel = new JLabel("B");
		blabel.setBounds(10, 70, 200, 30);
		jpBlueContainer.add(blabel);
		final JTextField bTextField = new JTextField(10);
		bTextField.setBounds(10, 100, 500, 30);
		jpBlueContainer.add(bTextField);

	jpGreenContainer = new JPanel();
	GroupLayout layoutGreen = new GroupLayout(jpGreenContainer);
	jpGreenContainer.setLayout(layoutGreen);
	jpGreenContainer.setBackground(new Color(204, 255,204));
	jpGreenContainer.setBounds(50, 170, 550, 150);
	jpContainer.add(jpGreenContainer);
	
		jpOrangeContainer = new JPanel(new BorderLayout());
		jpOrangeContainer.setBackground(new Color(255, 204,153));
		jpOrangeContainer.setBounds(40, 30, 200, 90);
		jpGreenContainer.add(jpOrangeContainer);
		
			JButton button11 = new JButton("B = reverse(A)");	
			jpOrangeContainer.add(button11, BorderLayout.NORTH);
			JButton button12 = new JButton("does B include A?");		
			jpOrangeContainer.add(button12, BorderLayout.CENTER);
			JButton button13 = new JButton("B = sort_alphabetically(A)");
			jpOrangeContainer.add(button13, BorderLayout.SOUTH);

		jpYellowContainer = new JPanel(new BorderLayout());
		jpYellowContainer.setBackground(new Color(255, 255,102));
		jpYellowContainer.setBounds(250, 30, 270, 90);
		jpGreenContainer.add(jpYellowContainer);
		
			JButton button21 = new JButton("change backgroundcolor o A rondomly");			
			jpYellowContainer.add(button21, BorderLayout.NORTH);
			JButton button22 = new JButton("change visibility of B");		
			jpYellowContainer.add(button22, BorderLayout.CENTER);
			JButton button23 = new JButton("make smaller length of A and B");
			jpYellowContainer.add(button23, BorderLayout.SOUTH);
			
			
			button11.addActionListener(new ActionListener() { //B = reverse(A)

				@Override
				public void actionPerformed(ActionEvent arg0) {

					String string= aTextField.getText();
					String reverse = new StringBuffer(string).reverse().toString();
					bTextField.setText(reverse);

				}
			});      
			button12.addActionListener(new ActionListener() {//does B include A?

				@Override
				public void actionPerformed(ActionEvent arg0) {



					if (bTextField.getText().contains(aTextField.getText())) 
						JOptionPane.showMessageDialog(aTextField, "YEAH");
					else
						JOptionPane.showMessageDialog(aTextField, "NONNO");


				}
			});      
			button13.addActionListener(new ActionListener() {//B = sort_alphabetically(A)

				@Override
				public void actionPerformed(ActionEvent arg0) {

					Collator col = Collator.getInstance(new Locale("en", "EN"));
					String s = aTextField.getText();
					String[] s1= s.split("");
					Arrays.sort(s1, col);
					String sorted = "";
					for (int i = 0; i < s1.length; i++)
					{
						sorted += s1[i];
					}
					bTextField.setText(sorted);

				}
			});      
			button21.addActionListener(new ActionListener() {//change backgroundcolor o A randomly

				@Override
				public void actionPerformed(ActionEvent arg0) {

					Random rand = new Random();
					// Java 'Color' class takes 3 floats, from 0 to 1.
					float r = rand.nextFloat();
					float g = rand.nextFloat();
					float b = rand.nextFloat();
					Color randomColor = new Color(r, g, b);
					aTextField.setBackground(randomColor);
				}
			});      
			button22.addActionListener(new ActionListener() {//change visibility of B

				@Override
				public void actionPerformed(ActionEvent arg0) {

					bTextField.setVisible(!bTextField.isVisible());

				}
			});      
			button23.addActionListener(new ActionListener() {//make smaller length of A and B

				@Override
				public void actionPerformed(ActionEvent arg0) {

					if (aTextField.getSize().width<5) {
						aTextField.setSize(500, aTextField.getSize().height);
						bTextField.setSize(500, bTextField.getSize().height);	
					} else {
						aTextField.setSize(aTextField.getSize().width-50, aTextField.getSize().height);
						bTextField.setSize(bTextField.getSize().width-50, bTextField.getSize().height);	
					}

				}
			});      

			setSize(600,400);
			setVisible(true);

}




public static void main(String[] args){

	new homework5();
}


}
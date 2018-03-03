import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class CountingSummations {
	
	JFrame frmMain = new JFrame();
	JPanel panel = new JPanel();
	JLabel LabelTitle = new JLabel();
	JLabel LabelNumero = new JLabel();
	JLabel LabelNumberOfWays = new JLabel();
	JTextField txtNumber = new JTextField();
	JButton btnEnter = new JButton();
	JButton btnDisplay = new JButton();
	JButton btnInstructions = new JButton();
	JButton btnAboutProject = new JButton();
	JButton btnAboutProgrammer = new JButton();
	JTextArea txtArea = new JTextArea();
	JScrollPane scrollable = new JScrollPane(txtArea,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	final int CAUTION[] = new int[] {25, 25};
	int n, w, wr, r, confirm, array2[], test_num;
	String str2, input, message;
	StringBuilder display;

	public static void main(String[] args) {
		new CountingSummations();
	}
	
	public CountingSummations() {
		int width, height;
		width = 631;
		height = 564;
		frmMain.setLayout(null);
		frmMain.setPreferredSize(new Dimension(width,height));
		frmMain.setMinimumSize(new Dimension(width,height));
		frmMain.setMaximumSize(new Dimension(width,height));
		frmMain.setTitle("Counting summations");
		
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(width,195));
		panel.setMinimumSize(new Dimension(width,195));
		panel.setMaximumSize(new Dimension(width,195));
		panel.setBounds(0, 0, width, 195);
		panel.setVisible(true);
		
		LabelTitle.setText("Counting summations");
		LabelTitle.setBounds(142, 0, 500, 50);
		LabelTitle.setFont(new Font("Arial",Font.PLAIN,34)
				.deriveFont(34));
		LabelTitle.setBackground(Color.BLACK);
		
		LabelNumero.setText("Number :");
		LabelNumero.setBounds(15, 45, 100, 50);
		LabelNumero.setFont(new Font("Arial",Font.PLAIN,16)
				.deriveFont(16));
		LabelNumero.setBackground(Color.BLACK);
		
		txtNumber.setBounds(100, 58, 40, 25);
		txtNumber.setFont(new Font("Arial",Font.PLAIN,16)
				.deriveFont(16));
		
		btnEnter.setText("ENTER");
		btnEnter.setBounds(150, 53, 80, 35);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input = txtNumber.getText();
				try {
					test_num = Integer.parseInt(input);
					if(!(test_num>1)){
						JOptionPane.showMessageDialog(null,
								"Number must be greater than 1");
						txtNumber.grabFocus();
						txtNumber.setText("");
					}else if(test_num>125){
						JOptionPane.showMessageDialog(null,
								"Number too large");
						txtNumber.grabFocus();
						txtNumber.selectAll();
					}else if(test_num!=n){
						if(test_num > CAUTION[0]){
							message = "You have entered a large n"+
									  "umber. Larger numbers\ntak"+
									  "e longer time to load. You"+
									  "r computer might be\nbusy "+
									  "counting summations.";
							confirm=JOptionPane.showConfirmDialog
									(null, message,
									"Confirmation Message",
									JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.WARNING_MESSAGE);
							if(confirm==JOptionPane.OK_OPTION){
								Number_of_Ways(n,true);
							}else{
								txtNumber.grabFocus();
								txtNumber.selectAll();
							}
						}else{
							Number_of_Ways(n,true);
						}
					}
				} catch(Exception ex0) {
					try {
						Double.parseDouble(input);
						JOptionPane.showMessageDialog(null,
								"Integers only");
						txtNumber.grabFocus();
						txtNumber.setText("");
					} catch(Exception ex1) {
						if(input.length()==0){
							JOptionPane.showMessageDialog(null,
									"Please enter a number");
							txtNumber.grabFocus();
					    } else {
							JOptionPane.showMessageDialog(null,
									"Numbers only");
							txtNumber.grabFocus();
							txtNumber.setText("");
						}
					}
				}
			}
		});
		
		LabelNumberOfWays.setBounds(15, 127, 500, 50);
		LabelNumberOfWays.setFont(new Font("Arial",Font.PLAIN,16)
				.deriveFont(16));
		LabelNumberOfWays.setBackground(Color.BLACK);
		
		btnDisplay.setText("DISPLAY");
		btnDisplay.setBounds(246, 143, 90, 35);
		btnDisplay.setEnabled(false);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(wr!=w||!txtArea.isEnabled()){
					if(n > CAUTION[1]){
						message = "You have entered a large numb"+
					            "er. Larger numbers\ntake longer "+
								"time to display its summations. "+
					            "Your\ncomputer might be busy loa"+
								"ding summations.";
						confirm=JOptionPane.showConfirmDialog(
								null, message,
								"Confirmation Message",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.WARNING_MESSAGE);
						if(confirm==JOptionPane.OK_OPTION){
							Ways(n,true);
						}else{
							txtNumber.grabFocus();
							txtNumber.selectAll();
						}
					}else{
						Ways(n,true);
					}
				}
				wr=w;
			}
		});
		
		btnInstructions.setText("INSTRUCTIONS");
		btnInstructions.setBounds(390, 53, 200, 35);
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				message = "Enter an integer greater than 1 to co"+
						"mpute for the number of\ndifferent ways"+
						" it can be written as a sum of numbers."+
						"\nIntegers greater than "+CAUTION[0]+" "+
						"take much time to compute.\n\nClick dis"+
						"play to view the results. Displaying th"+
						"e results\nconsumes much time if the nu"+
						"mber entered is greater "+
						"than " + CAUTION[1] + '.';
				JOptionPane.showMessageDialog(null, message,
						"Instructions", JOptionPane
						.DEFAULT_OPTION);
			}
		});
		
		btnAboutProject.setText("ABOUT THE PROGRAM");
		btnAboutProject.setBounds(390, 98, 200, 35);
		btnAboutProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				message = "This program counts and displays the "+
			            "different number of ways\na number can "+
						"be written as a sum of numbers such tha"+
			            "t each\ncombination of the said numbers"+
						" is unique.\n\nIt was taken from Proble"+
			            "m 76 of ProjectEuler.net";
				JOptionPane.showMessageDialog(null, message,
						"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnAboutProgrammer.setText("ABOUT THE PROGRAMMER");
		btnAboutProgrammer.setBounds(390, 143, 200, 35);
		btnAboutProgrammer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				message = "This program was made by Andre M. Cab"+
			            "atingan, a student\ntaking up BS Applie"+
						"d Math with I.T. at Far Eastern Univers"+
			            "ity.";
				JOptionPane.showMessageDialog(null, message,
						"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		txtArea.setFont(new Font("Arial",Font.PLAIN,16)
				.deriveFont(16));
		scrollable.setBounds(15, 195, 584, 300);
		txtArea.setEditable(false);
		txtArea.setEnabled(false);
		
		frmMain.add(panel);
		frmMain.add(scrollable);
		panel.add(LabelTitle);
		panel.add(LabelNumero);
		panel.add(txtNumber);
		panel.add(btnEnter);
		panel.add(LabelNumberOfWays);
		panel.add(btnDisplay);
		panel.add(btnInstructions);
		panel.add(btnAboutProject);
		panel.add(btnAboutProgrammer);
		
		frmMain.pack();
		frmMain.setLocationRelativeTo(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setVisible(true);
	}
	
	private void Number_of_Ways(int n,boolean initial) {
		if(initial){
			txtArea.setText("");
			txtArea.setEnabled(false);
			btnDisplay.setEnabled(true);
			n = this.n = test_num;
			w=0; r=0;
			array2 = new int[n];
		}
		
		int a, b, redundant, x;
		for(a=n-1;a>0;a--){
			b=n-a;
			array2[r]=a;
			array2[r+1]=b;
			redundant=0;
			for(x=0;x<=r;x++){
				if(array2[x]<array2[x+1]){
					redundant=1; break;
				}
			}
			if(redundant==0)w++;
			if(b>1){
				r++; Number_of_Ways(b,false); r--;
			}
		}
		
		if(initial){
			btnDisplay.setEnabled(true);
			LabelNumberOfWays.setText("<html>Numb"+
					"er of ways "+n+"<br>can be written a"+
					"s a sum :  "+w+"</html>");
		}
	}
	
	private void Ways(int n,boolean initial) {
		if(initial){
			r=0;
			txtArea.setEnabled(true);
			btnDisplay.setEnabled(false);
			display = new StringBuilder();
		}
		
		int a,b,redundant,newline,x;
		for(a=n-1;a>0;a--){
			b=n-a;
			array2[r]=a;
			array2[r+1]=b;
			newline=0;
			redundant=0;
			for(x=0;x<=r;x++){
				if(array2[x]<array2[x+1])redundant=1;
				if(array2[x]!=1||array2[x+1]!=1)newline=1;
			}
			if(redundant==0){
				for(x=0;x<=r+1;x++){
					if(x>0)display.append(" + ");
					display.append(array2[x]);
				}
				if(newline==1)display.append("\n");
			}
			if(b>1){
				r++; Ways(b,false); r--;
			}
		}
		
		if(initial){
			txtArea.setText(display.toString());
		}
	}

}

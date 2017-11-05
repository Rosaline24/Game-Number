import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class Game extends JFrame  {

	//the answer
	String s1 = null;
	//the user's answer
	int ss = 0;
	//the user's answer's length
	int len = 0 ;

	String[] arr1;


	//the computer's random answer
	int g1 = 0;
	int g2 = 0;
	int g3 = 0;
	int g4 = 0;

	//the button is check the answer and display answer	
	JButton jbt2 = null;
	JButton jbt3 = null;
	//display the rule
	JLabel jaaa = null;
	//user's panel
	JTextField input = null;
	//display all the result
	JTextField text = null;
	JTextArea record = null;
	JPanel p1 = null;
	JPanel p2 = null;
	


	Game() {

		//First will display a message 
		setLayout(null);
		JDialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog(null,"首先電腦會想好一組由左至右排列好的四個數碼（且數碼不可以重複出現被使用）","猜數字遊戲",JOptionPane.INFORMATION_MESSAGE);


		JPanel p1 = new JPanel(new FlowLayout());

		arr1 = new String[1];
	

		//add the two button
		JButton jbt2 = new JButton("確定");
		JButton jbt3 = new JButton("顯示答案");

		//add the button to p1
		p1.add(jbt2);
		p1.add(jbt3);

		//add the jbt2 's actionListener function
		jbt2.setForeground(Color.BLUE);
		jbt2.addActionListener(new StartListener());

		//add the jbt3 's actionListener function
		jbt3.setForeground(Color.BLUE);		
		jbt3.addActionListener(new AnswerListener());
		
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(p1);
		p2.setBounds(2, 2, 600, 80);
		add(p2);

		//display the game's rule
		jaaa = new JLabel();
		jaaa.setText("遊戲規則:如數字相同且位置相同則為A，數字相同位置不同則為B，均不同則不顯示");
		p2.add(jaaa , BorderLayout.NORTH);

		record = new JTextArea();

		record.setBounds(52 , 310 , 500 , 200);
		record.setText("");
		add(record);
		record.setEditable(false);

		//the textfield , user to enter			
		input = new JTextField(200);
		input.setBounds(52, 90, 500, 100);
		input.setText("");
		add(input);


		text = new JTextField(200);
		text.setBounds(52, 200, 500, 100);
		add(text);
		text.setEditable(false);

		//the random of the standard answer
		for (int i = 0 ; i <= 1 ; i++) {

			double c = Math.random()*10;
			int m1 = (int)c;
			double d = Math.random()*10;
			int m2 = (int)d;
			double e = Math.random()*10;
			int m3 = (int)e;
			double f = Math.random()*10;
			int m4 = (int)f;


			//if it has the same digit ,it will restart the random
			if (m1 == m2 || m1 == m3 || m1 == m4 || m2 == m3 ||m3 == m4 || m2==m4) {
				i = 0 ;
			}

			else {
				this.g1 = m1;
				this.g2 = m2;
				this.g3 = m3;
				this.g4 = m4;
			}

			//show the answer
			s1 = this.g1+"" + this.g2+"" + this.g3+""+ this.g4;
		}
	}

	//the class to invoke the actionlistener
	class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			domath();
		}
	}

	public void domath(){


		//the user's input answer
		String t = input.getText();


		//to judge the user's answer is only digit
		boolean isDigit = true;

		for(int i = 0 ; i < t.length() ; i++){
			if(!(Character.isDigit(t.charAt(i)))){
				isDigit = false;
			}
		}

		//if it not only has digit will display this 		
		if(!isDigit){
			text.setText("你輸入的不是數字,請重新輸入");
		}	
		else{	
			
			ss = Integer.parseInt(t);	
			int len = t.length();
			if ( len < 4 || len > 4) {
				text.setText("你輸入的數字,不是四位數,請重新輸入");
			}

			else{


				//judge the q1 q2 q3 q4
				int q1 = ss / 1000;
				int q2 = (ss % 1000) / 100;
				int q3 = (ss % 100) / 10 ;
				int q4 = ss % 10;

				int[] arr1 = {q1,q2,q3,q4};
				int x = arr1[0];
				int y = arr1[1];
				int z = arr1[2];
				int w = arr1[3];

				//define a b
				int a = 0 ;
				int b = 0 ;

				//if the user enter the same digit will display this
				if(q1==q2||q2==q3||q3==q4||q1==q3||q2==q4||q1==q4){

					text.setText("你輸入相同數字,請重新輸入");
				}
				
				//若輸入不同才進入else中去判斷幾a幾b或答對
				else{

					if(q1==g1){
						a++;
					}
					else if (q1 == g2 || q1 == g3 || q1 == g4) {
						b++;
					}

					if(q2==g2){
						a++;
					}
					else if (q2 == g1 || q2 == g3 || q2 == g4) {
						b++;
					}

					if(q3==g3){
						a++;
					}
					else if (q3 == g2 || q3 == g1 || q3 == g4) {
						b++;
					}

					if(q4==g4){
						a++;
					}
					else if (q4 == g2 || q4 == g3 || q4 == g1) {
						b++;
					}
			
					if(a==4) {
						text.setText("恭喜你答對了");
					
					}
					else{
						text.setText("電腦提示: "+a+"A"+b+"B");
						//把文字加入到textArea中使用append method 他不會覆蓋掉原本內容，\r\n讓每次插入的文字都換行顯示
						record.append(arr1[0]+""+arr1[1]+""+arr1[2]+""+arr1[3]+"is"+a+"A"+b+"B"+"\r\n");
							
						
						System.out.println(arr1[0]+""+arr1[1]+""+arr1[2]+""+arr1[3]+"is"+a+"A"+b+"B");

					}
				}
			}
		}

		//the textfield will display nothing 
		input.setText("");
	}

	//the class to invoke the actionlistener
	class AnswerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			text.setText(s1);

		}
	}
}
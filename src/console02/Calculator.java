package console02;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator {
	JFrame frame; //프레임
	JPanel panel;  //
	JLabel result; //결과 
	String total = null;
	// 전역변수 초기화 
	int first = 0;
	int second = 0;
	int cal = 0;
	boolean count;
	
	public void Layout() {
		frame = new JFrame();
		panel = new JPanel();
		
		//버튼 생성 
		JButton btn_num1 = new JButton("1");
		JButton btn_num2 = new JButton("2");
		JButton btn_num3 = new JButton("3");
		JButton btn_num4 = new JButton("4");
		JButton btn_num5 = new JButton("5");
		JButton btn_num6 = new JButton("6");
		JButton btn_num7 = new JButton("7");
		JButton btn_num8 = new JButton("8");
		JButton btn_num9 = new JButton("9");
		JButton btn_num10 = new JButton("0");
		JButton btn_plus = new JButton("+");
		JButton btn_minus = new JButton("-");
		JButton btn_mul = new JButton("*");
		JButton btn_div = new JButton("/");
		JButton btn_result = new JButton("=");
		
		JButton btn_reset = new JButton("ac");
		
		
		result = new JLabel("0", JLabel.RIGHT); //결과 창이 0으로 오른쪽으로 만들어주는것 
		
		panel.setLayout(null);
		
		// panel에 요소들 추가
		panel.add(result);
		panel.add(btn_plus);
		panel.add(btn_minus);
		panel.add(btn_mul);
		panel.add(btn_div);
		panel.add(btn_num1);
		panel.add(btn_num2);
		panel.add(btn_num3);
		panel.add(btn_num4);
		panel.add(btn_num5);
		panel.add(btn_num6);
		panel.add(btn_num7);
		panel.add(btn_num8);
		panel.add(btn_num9);
		panel.add(btn_num10);
		panel.add(btn_result);
		panel.add(btn_reset);
		
		// 각 레이아웃에 배치해주는 곳 
		result.setBounds(50, 50, 230, 50);
		btn_plus.setBounds(50, 110, 50, 50);
		btn_minus.setBounds(110, 110, 50, 50);
		btn_mul.setBounds(170, 110, 50, 50);
		btn_div.setBounds(230, 110, 50, 50);
		btn_num1.setBounds(50, 170, 50, 50);
		btn_num2.setBounds(110, 170, 50, 50);
		btn_num3.setBounds(170, 170, 50, 50);
		btn_num4.setBounds(50, 230, 50, 50);
		btn_num5.setBounds(110, 230, 50, 50);
		btn_num6.setBounds(170, 230, 50, 50);
		btn_num7.setBounds(50, 290, 50, 50);
		btn_num8.setBounds(110, 290, 50, 50);
		btn_num9.setBounds(170, 290, 50, 50);
		btn_num10.setBounds(50, 350, 170, 50);
		btn_result.setBounds(230, 170, 50, 110);
		btn_reset.setBounds(230, 290, 50, 110);
		
		// 버튼에 액션 리스너 부착 
		btn_num1.addActionListener(new Calculate());
		btn_num2.addActionListener(new Calculate());
		btn_num3.addActionListener(new Calculate());
		btn_num4.addActionListener(new Calculate());
		btn_num5.addActionListener(new Calculate());
		btn_num6.addActionListener(new Calculate());
		btn_num7.addActionListener(new Calculate());
		btn_num8.addActionListener(new Calculate());
		btn_num9.addActionListener(new Calculate());
		btn_num10.addActionListener(new Calculate());
		
		btn_plus.addActionListener(new Sign());
		btn_minus.addActionListener(new Sign());
		btn_mul.addActionListener(new Sign());
		btn_div.addActionListener(new Sign());
		
		btn_result.addActionListener(new Result());
		btn_reset.addActionListener(new Reset());
		
		//프레임 값 넣어주기 
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //꺼주는 것
		frame.setSize(350, 500); //프레임 크기 
		frame.setVisible(true); //창을 보여주는것 
	}
	
	//액션 이 발생했을떄 실행코드를 작동하게 하는 역할 ..
	class Calculate implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			  String strNum =   btn.getText();
			  result.setText(" ");
			if(count==false) {  //카운트가 false이면 출력 
				if(strNum.equals("1"))
					first = 1;
				else if(strNum.equals("2"))
					first = 2;
				else if(strNum.equals("3"))
					first = 3;
				else if(strNum.equals("4"))
					first = 4;
				else if(strNum.equals("5"))
					first = 5;
				else if(strNum.equals("6"))
					first = 6;
				else if(strNum.equals("7"))
					first = 7;
				else if(strNum.equals("8"))
					first = 8;
				else if(strNum.equals("9"))
					first = 9;
				else if(strNum.equals("0"))
					first = 0;
				else if(strNum.equals("+"))
					first = '+';
				String tempResult = " ";
				tempResult = result.getText();
				result.setText(tempResult + String.valueOf(first));
			}
			else if(count==true) {  //카운트가 true이면 출력 
				if(strNum.equals("1"))
					second = 1;
				else if(strNum.equals("2"))
					second = 2;
				else if(strNum.equals("3"))
					second = 3;
				else if(strNum.equals("4"))
					second = 4;
				else if(strNum.equals("5"))
					second = 5;
				else if(strNum.equals("6"))
					second = 6;
				else if(strNum.equals("7"))
					second = 7;
				else if(strNum.equals("8"))
					second = 8;
				else if(strNum.equals("9"))
					second = 9;
				else if(strNum.equals("0"))
					second = 0;
				result.setText("");  //결과 텍스트  초기화
				String tempResult = " "; 
				tempResult = result.getText();
				result.setText(tempResult + String.valueOf(second));
				
			}
		}
	}
		class Sign implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			  String strNum =   btn.getText();
			count=true;
			if(strNum.equals("+")) 
				cal = 1;  
			else if(strNum.equals("-"))
				cal = 2;
			else if(strNum.equals("*"))
				cal = 3;
			else if(strNum.equals("/"))
				cal = 4;
		}
		
		}			
		class Result implements ActionListener {
			public void actionPerformed(ActionEvent e) { 
		if(cal==1) {  // cal이 1이 맞을떄 돌아간다 	
			total = Integer.toString(first+second);
		}
		else if(cal==2) {
			total = Integer.toString(first-second);
		}
		else if(cal==3) {
			total = Integer.toString(first*second);
		}
		else if(cal==4) {
			total = Integer.toString(first/second);
		}
			result.setText(total);
			}
		}
	
		
	
	class Reset implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			first = 0;
			second = 0;
			cal = 0;
			total = null;
			result.setText("0");
			count = false;
		}
	}
	public static void main(String[] args) {
		Calculator SwingCal = new Calculator();
		SwingCal.Layout();
		
	}
}
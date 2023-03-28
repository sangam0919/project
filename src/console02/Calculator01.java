package console02;

import java.awt.event.*;
import javax.swing.*;


/**
 *
 * swing으로 사칙연산 계산기 프로그램 만들기
 *
 */
public class Calculator01 extends JFrame implements ActionListener {
	JLabel result;
	// int num1 , num2 ;
	int a = 0;
	int b = 0;
	boolean count;
	boolean firstNum = false; // 첫번째숫자
	boolean secondNum = false; // 두번째 숫자

	// + , - , * , /
	// --------------------------------------------------------------------
	public Calculator01() {
		super("Calculator");
		JPanel panel = new JPanel(); // 행과 열로 구성된 레이아웃 설정
		JPanel butten = new JPanel(); // 버튼 생성
		JFrame frame = new JFrame(); // 프레임 생성

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// --------------------------------------------------------------------
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");
		JButton btn10 = new JButton("0");
		JButton btnup = new JButton("+"); // 더하기 버튼
		JButton btnmi = new JButton("-"); // 빼기 버튼
		JButton btnmul = new JButton("*"); // 곱하기 버튼
		JButton btndiv = new JButton("/"); // 나누기 버튼
		JButton btnreset = new JButton("ac"); // 리셋시키는 버튼
		JButton btnresult = new JButton("="); // 값을 호출하는버튼
		result = new JLabel("0", JLabel.RIGHT); // 결과값

		// --------------------------------------------------------------------
		// 버튼에 액션 리스너 부착
		btn1.addActionListener(this);
		btn2.addActionListener(this); // 생성자 안이라서 this사용가능
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btnup.addActionListener(this);
		btnmi.addActionListener(this);
		btnmul.addActionListener(this);
		btndiv.addActionListener(this);
		btnreset.addActionListener(this);
		btnresult.addActionListener(this);

		// 4행 3열의 그리드 레이아웃이 적용된 패널 생성
		// 칸을 나누고 순차적으로 하나의 컴포넌트를 추가해나간다.
		// 남는 칸은 빈칸으로 남아 있음.

		// panel에 요소 추가

		panel.setLayout(null);
		panel.add(result);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);
		panel.add(btn10);
		panel.add(btnup);
		panel.add(btnmi);
		panel.add(btnmul);
		panel.add(btndiv);
		panel.add(btnreset);
		panel.add(btnresult);

		// --------------------------------------------------------------------
		// 버튼 위치 설정
		result.setBounds(200, 50, 50, 50);
		btn1.setBounds(50, 100, 50, 50);
		btn2.setBounds(100, 100, 50, 50);
		btn3.setBounds(150, 100, 50, 50);
		btn4.setBounds(50, 150, 50, 50);
		btn5.setBounds(100, 150, 50, 50);
		btn6.setBounds(150, 150, 50, 50);
		btn7.setBounds(50, 200, 50, 50);
		btn8.setBounds(100, 200, 50, 50);
		btn9.setBounds(150, 200, 50, 50);
		btn10.setBounds(50, 250, 50, 50);
		btnup.setBounds(100, 250, 50, 50);
		btnmi.setBounds(150, 250, 50, 50);
		btnmul.setBounds(200, 100, 50, 50);
		btndiv.setBounds(200, 150, 50, 50);
		btnreset.setBounds(200, 200, 50, 50);
		btnresult.setBounds(200, 250, 50, 50);

		// --------------------------------------------------------------------
		frame.add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
		// frame.setSize(350,500); //프레임 사이즈
		this.setVisible(true); // 프레임이 보이도록 설정
		setBounds(100, 100, 300, 400); // 프레임의 크기 지정
		// 컨텐트 패널은 JFrame의 기본 컨테이너이며 프레임 내의 콘텐츠 및 구성 요소 관리를 담당합니다
		// 프레임 > 메인 컨텐트 패널 > 패널 > 컴포넌트(버튼 ,레이블 ,텍스트필드)
		setContentPane(panel); // 패널을 메인(Root)컨텐트 패널에 추가하는 메소드

	}

	// 액션 리스너(이벤트가 발생했을 때 처리하는 메소드)
	public void actionPerformed(ActionEvent e) {

		if (firstNum == false) {
			// 첫번째
		}

		System.out.println("actionPerformed");
		// double result = 0;
		JButton btn = (JButton) e.getSource();
		String strNum = btn.getText();
		

		System.out.println("btn.getText" + btn.getText());
		// --------------------------------------------------------------------
		// if (count == false) { //count 와 false의 주소값을 비교

		if (strNum.equals("1")) // equals는 내용 자체를 비교
			a = 1;
		else if (strNum.equals("2"))
			a = 2;
		else if (strNum.equals("3"))
			a = 3;
		else if (strNum.equals("4"))
			a = 4;
		else if (strNum.equals("5"))
			a = 5;
		else if (strNum.equals("6"))
			a = 6;
		else if (strNum.equals("7"))
			a = 7;
		else if (strNum.equals("8"))
			a = 8;
		else if (strNum.equals("9"))
			a = 9;
		else if (strNum.equals("0"))
			a = 0;

		String tempResult = "0";
		tempResult = result.getText();
		result.setText(tempResult + String.valueOf(a));

		if (strNum.equals("+") || strNum.equals("-") || strNum.equals("*") || strNum.equals("/")) {
			System.out.println("현재 눌린 키 : " + strNum);
			tempResult = result.getText();
			System.out.println("tempResult : " + tempResult);
			result.setText("");

		}

		if (strNum.equals("=")) {
			System.out.println("현재 눌린 키 : " + strNum);
			result.setText(""); // 결과창 클리어

			String tempResult2 = "0";
			tempResult2 = result.getText();

			System.out.println("tempResult : " + tempResult + " \t " + "tempResult2 : " + tempResult2);

			// 첫번째 입력된 값과 두번째 입력된 값 연산
			int intResult = Integer.parseInt(tempResult) + Integer.parseInt(tempResult2);

			// 연산된 결과를 다시 겱롸창에 보여주기
			result.setText(String.valueOf(intResult));

		}

		// }
		// --------------------------------------------------------------------
//	          //else if(count == true) {
//	             if (strNum.equals("1"))
//	                b = 1;
//	             else if (strNum.equals("2"))
//	                b = 2;
//	             else if (strNum.equals("3"))
//	                b = 3;
//	             else if (strNum.equals("4"))
//	                b = 4;
//	             else if (strNum.equals("5"))
//	                b = 5;
//	             else if (strNum.equals("6"))
//	                b = 6;
//	             else if (strNum.equals("7"))
//	                b = 7;
//	             else if (strNum.equals("8"))
//	                b = 8;
//	             else if (strNum.equals("9"))
//	                b = 9;
//	             else if (strNum.equals("0"))
//	                b = 0;
//	          }

//	          else if(strNum.equals("=")) {
//	            
//	             result = a + b;
	}

	public static void main(String[] args) {
		new Calculator01();
	}
}

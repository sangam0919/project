package console02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator02 extends JFrame implements ActionListener {

    private JPanel buttonPanel;
    private JTextField textField; // 결과창
    private double firstNumber = 0, secondNumber = 0, result = 0;
    // 연산의 종류를 보관하는 변수
    private String operator = "";

    public Calculator02() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        // 결과창 폰트 늘림
        textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, 40));

        // 버튼을 부착할 패널 생성
        buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        addButton("7");
        addButton("8");
        addButton("9");
        addButton("/");
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("*");
        addButton("1");
        addButton("2");
        addButton("3");
        addButton("-");
        addButton("0");
        addButton("C");
        addButton("=");
        addButton("+"); 
        
                                                                                

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        // 결과 창을 컨텐트 패널의 위에 배치
        contentPane.add(textField, BorderLayout.NORTH);
       
        // 버튼 패널을 컨텐트 패널의 중앙에 배치
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        pack();   // 프레임에 컴포넌트들의 사이즈를 맞춤.
        setLocationRelativeTo(null);
        setVisible(true);   // 보이기
    }

    // 버튼을 부착할 메소드
    private void addButton(String label) {
        JButton button = new JButton(label);
        // 버튼에 액션 리스너 부착
        button.addActionListener(this);
       
        // 폰트 사이즈 늘림
        button.setFont(button.getFont().deriveFont(button.getFont().getSize() * 2f));
       
        // 버튼 부착
        buttonPanel.add(button);
        // C 버튼 추가
        if (label.equals("0")) {
            button.setPreferredSize(new Dimension(108, 50));
        } else if (label.equals("C")) {
            button.setPreferredSize(new Dimension(50, 50));
        }
    }
    

    /*
     * 액션 리스너
     */
    @Override
    public void actionPerformed(ActionEvent event) {
       // 어떤 버튼이 눌렸는지 값을 갖고옴.
        String command = event.getActionCommand();

        // 1. 결과 클리어
        if (command.equals("C")) {
            textField.setText("");
           
        // 2. 사칙연산과 = 에 대한 연산 처리    
        } else if (command.equals("=")) {
           // = 버튼 클릭시 현재 결과창의 값을 임시 변수에 저장
            secondNumber = Double.parseDouble(textField.getText());
            // 요청되었던 연산의 종류에 따른 연산 수행
            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operator.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (operator.equals("*")) {
                result = firstNumber * secondNumber;
            } else if (operator.equals("/")) {
                result = firstNumber / secondNumber;
            }
            
            
           
            // 연산 결과를 결과창에 출력
            textField.setText(Double.toString(result));
           
            // 첫번째, 두번째 숫자 0으로 초기화
            firstNumber = 0;
            secondNumber = 0;
           
            // 연산자도 초기화
            operator = "";
           
        // 3. 연산 수행 : + - / * 연산자 클릭시
        } else if (command.equals("+") || command.equals("-") ||
                 command.equals("*") || command.equals("/")) {
           
           // 클릭된 연산자를 보관
           // 이렇게 보관된 연산자를 "="이 눌렸을 경우에 사용해서 연산 수행함.
            operator = command;
           
            // 연산 버튼이 눌렸으므로 현재의 입력된 숫자를 첫번째 수에 보관
            firstNumber = Double.parseDouble(textField.getText());
           
            // 결과창 클리어
            textField.setText("");
        // 1번(클리어), 2(=, 연산수행), 3(사칙연산 버튼 클릭시 연산자 기억)이 아닌 경우
        } else {
            textField.setText(textField.getText() + command);
        }
    }

    public static void main(String[] args) {
        new Calculator02();
    }
}
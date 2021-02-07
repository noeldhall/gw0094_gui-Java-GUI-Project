import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the calculator code for assignment #2
 *
 * @author Noel Hall
 * @date 2/6/2021
 *
 */

public class Calculator {
    private JPanel rootPanel;
    private JLabel Operand1Label;
    private JLabel Operand2Label;
    private JTextField operand1;
    private JLabel Result;
    private JButton zerobtn;
    private JButton onebtn;
    private JButton fivebtn;
    private JButton threebtn;
    private JButton dotbtn;
    private JButton fourbtn;
    private JButton twobtn;
    private JButton plusbtn;
    private JButton divbtn;
    private JButton sqrtbtn;
    private JButton clearbtn;
    private JButton resultbtn;
    private JLabel mathoperations;
    private JTextField operand2;
    private JTextField result;
    Calculations calc=new Calculations();
    JFrame frame=new JFrame("Calculator");

    public Calculator() {
        zerobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calc.getToggleFocus()==0)
                {
                    calc.setO1("0");
                    operand1.setText(calc.getO1());
                }
                else
                {
                    calc.setO2("0");
                    operand2.setText(calc.getO2());
                }
            }
        });
        onebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calc.getToggleFocus()==0)
                {
                    calc.setO1("1");
                    operand1.setText(calc.getO1());
                }
                else
                {
                    calc.setO2("1");
                    operand2.setText(calc.getO2());
                }
            }
        });
        twobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calc.getToggleFocus()==0)
                {
                    calc.setO1("2");
                    operand1.setText(calc.getO1());
                }
                else
                {
                    calc.setO2("2");
                    operand2.setText(calc.getO2());
                }
            }
        });
        threebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calc.getToggleFocus()==0)
                {
                    calc.setO1("3");
                    operand1.setText(calc.getO1());
                }
                else
                {
                    calc.setO2("3");
                    operand2.setText(calc.getO2());
                }
            }
        });
        fourbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calc.getToggleFocus()==0)
                {
                    calc.setO1("4");
                    operand1.setText(calc.getO1());
                }
                else
                {
                    calc.setO2("4");
                    operand2.setText(calc.getO2());
                }
            }
        });
        fivebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calc.getToggleFocus()==0)
                {
                    calc.setO1("5");
                    operand1.setText(calc.getO1());
                }
                else
                {
                    calc.setO2("5");
                    operand2.setText(calc.getO2());
                }
            }
        });
        dotbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(calc.getToggleFocus()==0)
                {
                    String s=calc.getO1();
                    if (s.contains(".")==false) {
                        calc.setO1(".");
                        operand1.setText(calc.getO1());
                    }
                }
                else
                {
                    String s=calc.getO2();
                    if (s.contains(".")==false) {
                        calc.setO2(".");
                        operand2.setText(calc.getO2());
                    }
                }
            }
        });

        plusbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                calc.setOp(Operations.ADD);
                if (calc.getO1()!=""&& calc.getO2()!="")
                    resultbtn.setEnabled(true);

            }
        });

        divbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setOp(Operations.DIV);
                if (calc.getO1()!=""&& calc.getO2()!="")
                resultbtn.setEnabled(true);

            }
        });
        sqrtbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setOp(Operations.SQRT);
                if(calc.getO1()!="")
                resultbtn.setEnabled(true);

            }
        });
        clearbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    calc.setO1("");
                    operand1.setText(calc.getO1());
                    result.setText("");
                    calc.setO2("");
                    operand2.setText(calc.getO2());




            }
        });
        resultbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1=Double.parseDouble(calc.getO1()),r=0;
                if (calc.getOp()==Operations.SQRT)
                    r=Math.sqrt(num1);
                else {
                    double num2=Double.parseDouble(calc.getO2());
                    if (calc.getOp() == Operations.ADD)
                        r = num1 + num2;
                    else if (calc.getOp() == Operations.DIV)
                        r = num1 / num2;
                    else if (calc.getOp() == Operations.SQRT)
                        r = Math.sqrt(num1);
                }
                calc.setResult(Double.toString(r));
                result.setText(calc.getResult());
                resultbtn.setEnabled(false);



            }
        });
        operand1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                calc.setToggleFocus(0);
            }
        });
        operand2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                calc.setToggleFocus(1);
            }
        });

        operand1.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    if (e.getKeyCode() !=e.VK_BACK_SPACE)
                    {

                          operand1.setText("");
                            operand1.setText(calc.getO1());
                    }
                    else
                    {
                        String s=calc.getO1();
                        int length= s.length();
                        String newO1="";
                        for (int i=0;i<s.length()-1;i++)
                            newO1+=s.charAt(i);
                        calc.setO1("");
                        calc.setO1(newO1);
                        operand1.setText("");
                        operand1.setText(newO1);

                    }
                }


        });

        operand2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() !=e.VK_BACK_SPACE)
                {

                    operand2.setText("");
                    operand2.setText(calc.getO1());
                }
                else
                {
                    String s=calc.getO1();
                    int length= s.length();
                    String newO1="";
                    for (int i=0;i<s.length()-1;i++)
                        newO1+=s.charAt(i);
                    calc.setO1("");
                    calc.setO1(newO1);
                    operand2.setText("");
                    operand2.setText(newO1);

                }
            }


        });


    }

    public static void main (String[] args){
        Calculator calculator=new Calculator();
        calculator.createWindow();

    }

    public void createWindow(){
        frame.setContentPane(new Calculator().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        operand1.requestFocusInWindow();
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Noel Hall's Calculator");
        centerTheWindow();

    }

    public void centerTheWindow(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x=(int) ((dimension.getWidth()-frame.getWidth())/2);
        int y=(int) ((dimension.getHeight()-frame.getHeight())/2);
        frame.setLocation(x,y);
    }
}

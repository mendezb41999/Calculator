import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame implements ActionListener  
{
   //class constants 
   public static final int WIDTH = 400;
   public static final int HEIGHT = 300;
   public static final int NUMBER_OF_DIGITS = 30;

   private JTextField ioField;
   private double answer = 0.0;

   public static void main(String[] args)
   {
     Calculator calc = new Calculator();  //declare a calculat object
     calc.setVisible(true);
   }
     //constructor for Calculator
     public Calculator()
     {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        ioField = new JTextField("Enter input values", NUMBER_OF_DIGITS);
        ioField.setBackground(Color.YELLOW);
        textPanel.add(ioField); //add ioField as a component of the panel
        add(textPanel, BorderLayout.NORTH);

        //create  a JPanel for command buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GREEN);
        buttonPanel.setLayout(new FlowLayout());

        //add button components to buttonPanel
        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        JButton subButton = new JButton("-");
        subButton.addActionListener(this);
        buttonPanel.add(subButton);

        JButton reset = new JButton("Reset to 0");
        reset.addActionListener(this);
        buttonPanel.add(reset);

        //include the button panel component
        add(buttonPanel, BorderLayout.CENTER);
     }


     public void actionPerformed(ActionEvent e)
     {
        try
        {
           assumingCorrectNumberFormats(e);
        }
        catch (NumberFormatException e2)
        {
           ioField.setText("Error: reenter value");
        }
     }

     public void assumingCorrectNumberFormats(ActionEvent e)
     {
       String actionCommand = e.getActionCommand();
       if(actionCommand.equals("+"))
       {
          answer = answer + stringToDouble(ioField.getText());
          ioField.setText(Double.toString(answer));
       }
       else if(actionCommand.equals("-"))
       {
          answer = answer - stringToDouble(ioField.getText());
          ioField.setText(Double.toString(answer));
       }
       else if(actionCommand.equals("Reset to 0"))
       {
          answer = 0.0;
          ioField.setText("0.0");
       }
       else
          ioField.setText("error");
     }

     private static double stringToDouble(String stringObject)
     {
        return Double.parseDouble(stringObject.trim());
     }
}  











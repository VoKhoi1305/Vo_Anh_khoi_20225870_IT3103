import javax.swing.JOptionPane;
public class CaculateTwoNumbers {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "the caculate are: \n";

        strNum1 = JOptionPane.showInputDialog(null,"Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
    
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
       
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2; 
        strNotification += strNum1 + " + " + strNum2 + " = " + sum +"\n";
        double diff = num1 - num2;
        strNotification += strNum1 + " - " + strNum2 + " = " + diff +"\n";
        double product = num1 * num2;
        strNotification += strNum1 + " * " + strNum2 + " = " + product +"\n";
        if(num2){
        double quotient = num1 / num2; 
        strNotification += strNum1 + " / " + strNum2 + " = " + quotient +"\n";}
        else {
            strNotification += "can't divided by 0";
        }

        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

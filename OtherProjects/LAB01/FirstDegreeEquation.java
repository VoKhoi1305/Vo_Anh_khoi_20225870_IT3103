import javax.swing.JOptionPane;
public class FirstDegreeEquation {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = " ";

        strNum1 = JOptionPane.showInputDialog(null,"Please input a: ", "Solve ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
        
        strNum2 = JOptionPane.showInputDialog(null,"Please input b: ", "Solve ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);
        if (a == 0) {
            if (b == 0) {
                strNotification += "The equation has infinitely many solutions.";
            }
            else strNotification += "The equation has no solution";
        }
        else {
            double solution = -b / a; 
            strNotification += "the solution is " + solution;
        }
    
        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

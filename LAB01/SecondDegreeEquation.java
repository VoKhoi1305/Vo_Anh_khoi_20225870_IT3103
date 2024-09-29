import javax.swing.JOptionPane;
public class SecondDegreeEquation {
    public static void main(String[] args){    
        String strNum1, strNum2, strNum3;
        String strNotification = " ";
        strNum1 = JOptionPane.showInputDialog(null,"Please input a: ", "Solve ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"Please input b: ", "Solve ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null,"Please input c: ", "Solve ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);
        double c = Double.parseDouble(strNum3);
        double delta = b*b - 4*a*c;
        if(delta == 0){
            if (b == 0) {
                if (c == 0) {
                    strNotification += "The equation has infinitely many solutions";
                }
                else strNotification += "The equation has no solution";
            }
            else {
                double solution = -b / (2*a); 
                strNotification += " x = " + solution;
            }
        }
        else if (delta > 0){
           double x1 = (-b + Math.sqrt(delta))/(2*a);
           double x2 = (-b - Math.sqrt(delta))/(2*a);
           strNotification += "x1 = " + x1 + " x2 = " +x2;
        }
        else strNotification += "The equation has no solution";
        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
import javax.swing.JOptionPane;
public class FirstDegreeSystemEquation {
    public static void main(String[] args){
        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
        String strNotification = " ";

        strNum1 = JOptionPane.showInputDialog(null,"Please input a11: ", "Solve a11x1 + a12x2 = b1 and a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"Please input a12: ", "Solve a11x1 + a12x2 = b1 and a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null,"Please input b1: ", "Solve a11x1 + a12x2 = b1 and a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        strNum4 = JOptionPane.showInputDialog(null,"Please input a21: ", "Solve a11x1 + a12x2 = b1 and a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        strNum5 = JOptionPane.showInputDialog(null,"Please input a22: ", "Solve a11x1 + a12x2 = b1 and a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        strNum6 = JOptionPane.showInputDialog(null,"Please input b2: ", "Solve a11x1 + a12x2 = b1 and a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(strNum1);
        double a12 = Double.parseDouble(strNum2);
        double b1 = Double.parseDouble(strNum3);
        double a21 = Double.parseDouble(strNum4);
        double a22 = Double.parseDouble(strNum5);
        double b2 = Double.parseDouble(strNum6);
        double D = a11 * a22 - a21 * a12;
        double D1 = b1*a22 - b2*a12;
        double D2 = b1*a11 - b2*a21;
        if(D == 0){
            if(D1 == 0 && D2 == 0)
            strNotification += "infinity solution";
            else if(D1 != 0 || D2 != 0)
            strNotification += "no solution";
        }
        else {
            double x = D1 / D;
            double y = D2 / D;
            strNotification += "x = " + x +"\ny = " +y;
        }
        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    
}
}

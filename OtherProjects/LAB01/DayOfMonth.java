import java.util.Scanner;

public class DayOfMonth  {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int year;
        String monthInput; 
        year = scanner.nextInt();
        while(year <= 0)
        {
            System.out.println("enter again!");
            year = scanner.nextInt();
        }
        scanner.nextLine();
        monthInput = scanner.nextLine().trim();
        int month = getMonthNumber(monthInput);
        while (month == -1) {
            System.out.println("Invalid month. Please enter again.");
            monthInput = scanner.nextLine().trim();
            month = getMonthNumber(monthInput);
        }

        // Determine the number of days in the given month and year
        int days = getDaysInMonth(month, year);
        System.out.println("The number of days in " + monthInput + " " + year + " is: " + days);
          // Exit the loop if all inputs are valid
    }


    public static int getMonthNumber(String monthInput) {
        switch (monthInput.toLowerCase()) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "may.": case "5": return 5;
            case "june": case "jun.": case "jun": case "6": return 6;
            case "july": case "jul.": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;  // Invalid month
        }
    }

    // Function to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function to get the number of days in a given month and year
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;  // Invalid month
        }  
    }
}

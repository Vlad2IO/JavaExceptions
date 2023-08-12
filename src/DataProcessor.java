import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter data in the format: 'Last Name' 'First Name' 'Middle Name' 'Date of Birth'(xx.xx.xxxx) 'Phone Number'(8XXXXXXXXXX) 'Gender'(M/F) or enter 'Stop' to terminate:");
            String input = scanner.nextLine();
            
            if ("Stop".equalsIgnoreCase(input)) {
                break;
            }
            
            try {
                Person person = parseInput(input);
                validateData(person);
                writeToFile(person);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    public static Person parseInput(String input) {
        String[] tokens = input.split(" ");
        
        if (tokens.length != 6) {
            throw new IllegalArgumentException("Invalid amount of data in the entered string.");
        }
        
        Person person = new Person();
        person.lastName = tokens[0];
        person.firstName = tokens[1];
        person.middleName = tokens[2];
        
        // Pattern for Date of Birth
        Pattern dobPattern = Pattern.compile("(\\d{2}\\.\\d{2}\\.\\d{4})");
        Matcher dobMatcher = dobPattern.matcher(input);
        if (dobMatcher.find()) {
            person.dateOfBirth = dobMatcher.group(1);
        }
        
        // Pattern for Phone Number
        Pattern phonePattern = Pattern.compile("8\\d{10}");
        Matcher phoneMatcher = phonePattern.matcher(input);
        if (phoneMatcher.find()) {
            person.phoneNumber = phoneMatcher.group(0);
        }

        // Checking Gender
        if (input.contains("M")) {
            person.gender = "M";
        } else if (input.contains("F")) {
            person.gender = "F";
        }
        
        return person;
    }

    public static void validateData(Person person) {
        if (person.lastName == null || person.firstName == null || person.middleName == null ||
            person.dateOfBirth == null || person.phoneNumber == null || person.gender == null) {
            throw new IllegalArgumentException("Some data fields are missing or in incorrect format.");
        }
    }

    public static void writeToFile(Person person) throws IOException {
        String filename = person.lastName + ".txt";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("<" + person.lastName + "><" + person.firstName + "><" + person.middleName +
                         "><" + person.dateOfBirth + "><" + person.phoneNumber + "><" + person.gender + ">\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    String lastName;
    String firstName;
    String middleName;
    String dateOfBirth;
    String phoneNumber;
    String gender;
}

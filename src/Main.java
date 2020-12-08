import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java Exceptions!");
        ioExceptionDemo();
        tryWithResourcesDemo();
    }

    private static void tryWithResourcesDemo() throws Exception {
        System.out.println("---Try With Resources---");

        try (FileReader reader = new FileReader(
                    "C:\\Users\\Mike\\Documents\\Repos\\JavaExceptions\\test.txt")) {
            // read file here
            reader.read();
            int i = 5/0;
        } catch (IOException | ArithmeticException e) { // multicatch
            System.out.println("File can't be read or division by zero!");
            throw e;
        } finally {
            System.out.println("Finally block.");
            // reader.close(); does not exist. It is closed AUTOMATICALLY by try-with-resources
        }
    }

    private static void ioExceptionDemo() throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader(
                    "C:\\Users\\Mike\\Documents\\Repos\\JavaExceptions\\test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File can't be read!");
        } catch (IOException e) {
            System.out.println("More general catch.");
        } finally {
            System.out.println("Closing file.");
            reader.close();
        }
    }
}

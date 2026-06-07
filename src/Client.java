import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter number of subjects: ");
            int numSubjects = scanner.nextInt();

            int[] marks = new int[numSubjects];
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter Mark for Subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }

            Socket socket = new Socket("localhost", 5000);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeInt(id);
            dos.writeUTF(name);
            dos.writeInt(numSubjects);
            for (int mark : marks) {
                dos.writeInt(mark);
            }
            dos.flush();

            System.out.println("Data sent successfully.");

            dos.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
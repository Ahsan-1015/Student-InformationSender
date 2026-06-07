import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is running... Waiting for student data.");

            HashMap<Integer, Integer[]> studentMarksMap = new HashMap<>();
            List<String> namesList = new ArrayList<>();

            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                try {
                    int id = dis.readInt();
                    String name = dis.readUTF();
                    int numSubjects = dis.readInt();

                    Integer[] marks = new Integer[numSubjects];
                    for (int i = 0; i < numSubjects; i++) {
                        marks[i] = dis.readInt();
                    }

                    studentMarksMap.put(id, marks);
                    namesList.add(name);

                    System.out.println("\n--- Current Student Records ---");
                    String[] namesArray = namesList.toArray(new String[0]);
                    int index = 0;
                    for (Integer studentId : studentMarksMap.keySet()) {
                        System.out.println("ID: " + studentId +
                                " | Name: " + namesArray[index] +
                                " | Marks: " + Arrays.toString(studentMarksMap.get(studentId)));
                        index++;
                    }
                } catch (IOException e) {
                    System.out.println("Error reading client data: " + e.getMessage());
                } finally {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
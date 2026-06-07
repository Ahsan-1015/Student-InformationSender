# Student Information Sender (SE-409)

This repository contains a **Student Info Transfer System** developed using **Java Socket Programming** and **Java Collections** for the course *Advanced Enterprise Java (SE-409)*.

The system allows a client to input student details (ID, Name, and Marks for multiple subjects) via console, send this data over a TCP socket, and have the server receive, organize, and display the collective records using a `HashMap` and a `List`/`Array`.

---

## Project Structure

*   **`Server.java`**: Listens on port `5000` for incoming data. It stores student IDs and marks in a `HashMap<Integer, Integer[]>` and maintains student names in a list converted to a `String[]`.
*   **`Client.java`**: Collects Student ID, Name, and subject marks using `Scanner` and transfers the binary structured data to the server using `DataOutputStream`.

---

## Prerequisites

*   Java Development Kit (JDK) 8 or higher installed.
*   Command-line terminal or an IDE (like IntelliJ IDEA, Eclipse, or VS Code).

---

## How to Compile and Run

Follow these steps in your terminal:

### 1. Compile the Source Files

Compile both the Client and Server files:
bash
javac Server.java

javac Client.java

### 2. Run the Server First
The server must be running and listening before the client attempts to connect:
bash
java Server

*Console output:*
text
Server is running... Waiting for student data.

### 3. Run the Client (in a separate terminal window)
Run the client program to input and send student information:
bash
java Client

---

## Sample Execution & Outputs

### Client Console Input/Output
text
Enter Student ID: 1015

Enter Student Name:Ahsan

Enter number of subjects: 2

Enter Mark for Subject 1: 95

Enter Mark for Subject 2: 90

Data sent successfully.

### Server Console Output
Upon receiving the data from the client, the server dynamically updates and outputs the total record pool:
text
Server is running... Waiting for student data.

--- Current Student Records ---

ID: 1015 | Name: Ahsan habib | Marks: [ 90, 95]

If you run the client again to add another student (e.g., ID: `1083`, Name: `saju`, Marks: `[92, 88]`):
text
--- Current Student Records ---

ID: 1015	Name: Abir Rahman	Marks: [90.95]
ID: 1083	Name: saju	Marks: [92, 88]
---

## Technologies and Concepts Used

### 1. Java Collections Framework
*   **`HashMap<Integer, Integer[]>`**: Chosen to store unique Student IDs as keys and their corresponding subject marks (as an array) as values. This ensures an efficient $O(1)$ search lookup.
*   **`ArrayList` / `String[]`**: Used to dynamically collect incoming student names and represent them as an array on the console.

### 2. Socket Programming
*   **`ServerSocket`**: Binds to port `5000` on the host side, actively listening and waiting to accept incoming socket connection requests using the `.accept()` blocking method.
*   **`Socket`**: Establishes the communication pipeline between the local computer (`localhost`) and the server.
*   **`DataInputStream` & `DataOutputStream`**: Used to cleanly serialize/deserialize the raw data types (`int`, `UTF-8 Strings`) sequentially over the TCP stream.

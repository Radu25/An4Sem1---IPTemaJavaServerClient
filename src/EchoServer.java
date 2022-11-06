import Profesor.Profesor;
import Student.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * @author radu
 */
public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            while (true) {
                Socket client = server.accept();
                System.out.println("Connection success......");
                ServerThread serverthread = new ServerThread(client);
                serverthread.start();
            }
        } catch (IOException e) {
            System.err.println("Exception caught:" + e);
        }
    }
}

class ServerThread extends Thread {
    Socket client;
    ArrayList<Student> studenti = new ArrayList<>();
    ArrayList<Profesor> profesori = new ArrayList<>();

    ServerThread(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("[type 'bye' to disconnect]");
            while (true) {
                String line = reader.readLine();
                if (line.trim().equals("bye")) {
                    writer.println("[bye!]");
                    break;
                }
                if (line.trim().equals("sorteaza")) {
                    Collections.sort(studenti);
                    System.out.println(studenti);
                    Collections.sort(profesori);
                    System.out.println(profesori);
                }
                String[] names = line.split(" ");
                if (names[0].equals("Profesor")) {
                    profesori.add(new Profesor(line));
                }
                System.out.println(names[0]);
                if (names[0].equals("Student")) {
                    System.out.println("Sunt aici");
                    studenti.add(new Student(line));
                }
                writer.println("[Echo]" + line);
                System.out.println(line);

            }
        } catch (IOException e) {
            System.err.println("Exception caught:" + e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
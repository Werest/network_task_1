import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int port = Constants.PORT;
        String host = Constants.HOST;

        Scanner scanner = new Scanner(System.in);

        try(Socket clientSocket = new Socket(host, port);
            PrintWriter printWriter = new
                    PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println(in.readLine()); // Добро пожаловать на наш сервер! Как тебя зовут?
            printWriter.println(scanner.nextLine()); // Имя
            System.out.println(in.readLine()); // Ты ребёнок (да/нет)?
            printWriter.println(scanner.nextLine());
            System.out.println(in.readLine()); // Приветствие

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = Constants.PORT;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер стартовал! " + serverSocket.getInetAddress().getHostAddress() + ":" + serverSocket.getLocalPort());

            try(Socket socket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("Опредлено новое подключение: " + socket.getPort() + " - " + socket.getInetAddress().getHostName());

                printWriter.println("Добро пожаловать на наш сервер! Как тебя зовут?");
                final String name = bufferedReader.readLine();
                printWriter.println("Ты ребёнок (да/нет)?");
                final String answer = bufferedReader.readLine();
                if(answer.equals("да")){
                    printWriter.printf("Добро пожаловать в детскую комнату, %s! Давай играть!!!", name);
                }else if (answer.equals("нет")){
                    printWriter.printf("Добро пожаловать во взрослую зону, %s! Хорошего отдыхали, или хорошего работы дня!", name);
                }

            }
        } catch (IOException exception){
            exception.printStackTrace();
        }





    }
}
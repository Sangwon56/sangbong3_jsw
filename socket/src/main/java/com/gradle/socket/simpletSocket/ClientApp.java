package com.gradle.socket.simpletSocket;

import java.io.*;
import java.net.Socket;

public class ClientApp {
    private final static int port = 33333; // 0~65534, 0~9999 까지는 대부분 프로그램이 사용, 10000번 이상 사용하는게 좋다.
    // private final static String serverIp = "172.0.0.1";
    private final static String serverIp = "192.168.0.20";

    public static void main(String[] args) {

        // 서버 소켓을 만든다. (IP주소, 포트번호) (clientSocket)
        // 클라이언트 소켓으로 서버에 접속 시도한다.
        // 서버와 연결된 클라이언트 소켓으로 읽거나 쓴다.
        // 읽을 때는 동기상태 (블로킹)

        try {
            Socket clientSocket = init();
            BufferedWriter socKetWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader KeyboardReader = new BufferedReader(new InputStreamReader(System.in));
            socKetWriter.write(String.format("클라이언트[%s] 접속 함", serverIp));
            socKetWriter.newLine();
            socKetWriter.flush();

            while (true) {
                String readMsg = socketReader.readLine();
                System.out.printf("서버에서 받은 문자열 : %s%n", readMsg);
                if("exit".equalsIgnoreCase(readMsg)) {
                    break;
                }
                System.out.print("클라이언트에서 문자열 입력 : ");
                String keyboardMsg =KeyboardReader.readLine();
                socKetWriter.write(keyboardMsg);
                socKetWriter.newLine();
                socKetWriter.flush();
                if("exit".equalsIgnoreCase(keyboardMsg)) {
                    break;
                }
            }

            KeyboardReader.close();
            socketReader.close();
            socKetWriter.close();
            clientSocket.close();
        } catch (IOException ioE) {
            System.out.println("IOException");
            System.out.println(ioE.toString());
        } catch (Exception ex) {
            System.out.println("Exception");
            System.out.println(ex.toString());
        } finally {
            System.out.println("클라이언트 프로그램 종료");
        }
    }

    public static Socket init() throws IOException {
        Socket socket = new Socket(serverIp, port);
        System.out.println("클라이언트 소켓 생성 후 서버에 접속 성공");
        return socket;
    }
}

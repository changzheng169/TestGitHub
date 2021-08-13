package HomeWorkFifteen;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(12345);
        Socket s=ss.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while((line=br.readLine())!=null){
            System.out.println("客户端发来的数据是："+line);
        }
        //给出反馈
        OutputStream os = s.getOutputStream();
        os.write("服务端已经收到数据".getBytes(StandardCharsets.UTF_8));
        os.close();
        br.close();
        s.close();
        ss.close();
    }
}

package HomeWorkFifteen;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket(InetAddress.getByName("192.168.1.103"),12345);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("开始发送数据：");
        while((line=br.readLine())!=null){
            if("通讯结束".equals(line)){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        s.shutdownOutput();
        //接受反馈
        InputStream is = s.getInputStream();
        byte[] bys=new byte[1024];
        int len;
        while((len=is.read(bys))!=-1){
            System.out.println("客户端："+new String(bys,0,len));
        }
        is.close();
        br.close();
        bw.close();
        s.close();
    }
}

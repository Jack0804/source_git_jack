package Morning;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MP3Server {

   public static void main(String[] args) throws Exception
   {
      ServerSocket serverSocket=new ServerSocket(8080);
      
      while(true)
      {
         Socket socket=serverSocket.accept();

         OutputStream out=socket.getOutputStream();

         Scanner   scanner = new Scanner(socket.getInputStream());
         String str = scanner.nextLine();
         String [] arr=str.split(" ");

         str = arr[1].substring(1);
         //-->
         String fileName="C:\\zzz\\"+str;

         File file=new File(fileName);
         FileInputStream fin=new FileInputStream(file);

         String suffix= arr[1].substring(arr[1].lastIndexOf(".")+1);
         System.out.println(suffix);

         out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); //정상적으로온거임
         out.write(new String("Cache-Control: private\r\n").getBytes()); 
         out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes()); 
         
         if(suffix.equals("mp3")){
            out.write(new String("Content-Type: audio/mpeg; charset=UTF-8\r\n\r\n").getBytes());
         }
         else if(suffix.equals("html")){
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());
         }



         byte [] buffer=new byte[1024*8];
         int total=0;
         //<--

         while(true)
         {
            try
            {
               int cnt= fin.read(buffer);
               total += cnt;

               if(cnt==-1)
               {
                  break;
               }
               out.write(buffer, 0 , cnt);

               //System.out.println(total);
            } 

            catch (Exception e) 
            {
            }

         }//end while
         System.out.println("complete!!");
         fin.close();
         out.close();
         socket.close();
      }//end while
      //<--



      //   OutputStream out=new OutputStream(socket.);

   }

}
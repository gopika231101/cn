Client:
import java.io.*;
import java.net.*;
import java.util.*;
class Clientarp
{
            public static void main(String args[])
            {
            try
            {         
                        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
                        Socket clsct=new Socket(&quot;127.0.0.1&quot;,139);
                        DataInputStream din=new DataInputStream(clsct.getInputStream());
                        DataOutputStream dout=new DataOutputStream(clsct.getOutputStream());
                        System.out.println(&quot;Enter the Logical address(IP):&quot;);
                        String str1=in.readLine();
                        dout.writeBytes(str1+&#39;\n&#39;);
                        String str=din.readLine();
                        System.out.println(&quot;The Physical Address is: &quot;+str);             
                        clsct.close();
            }
            catch (Exception e)
            {
            System.out.println(e);
            }
            }
}
Server:
import java.io.*;
import java.net.*;
import java.util.*;
class Serverarp
{
            public static void main(String args[])
            {
            try
            {
                        ServerSocket obj=new ServerSocket(139);
                        Socket obj1=obj.accept();
                        while(true)
                        {
                                    DataInputStream din=new DataInputStream(obj1.getInputStream());
                                    DataOutputStream dout=new
DataOutputStream(obj1.getOutputStream());

                                    String str=din.readLine();
                                    String ip[]={&quot;165.165.80.80&quot;,&quot;165.165.79.1&quot;};
                                    String mac[]={&quot;6A:08:AA:C2&quot;,&quot;8A:BC:E3:FA&quot;};
                                    for(int i=0;i&lt;ip.length;i++)
                                    {
                                                if(str.equals(ip[i]))
                                                {
                                                            dout.writeBytes(mac[i]+&#39;\n&#39;);
                                                            break;
                                                }
                                    }                     
                                    obj.close();
                        }
                       
            }
            catch(Exception e)
            {
                        System.out.println(e);
            }
            }
}
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{//所有异常抛出
		ServerSocket server = null;                         //定义ServerSocket对象
		Socket client = null;//定义Socket对象，表示客户端
		server = new ServerSocket(3333);//此服务器在3333端口进行监听
		boolean f =true;//定义一个标记位
		while(f){//无限制接收客户端连接
			System.out.println("服务器运行，等待客户端连接");
			client = server.accept();//接收客户端连接
			new Thread(new CThread(client)).start();//实例化并启动一个线程对象
		}
		server.close();//关闭服务器端
	}

}

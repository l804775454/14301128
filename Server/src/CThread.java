import java.io.*;
import java.net.*;

public class CThread implements Runnable { // 实现Runnable接口
	private Socket client = null; // 接收客户端

	public CThread(Socket client) { // 通过构造方法设置Socket
		this.client = client;
	}

	@Override
	public void run() { // 覆盖run()方法
		PrintStream out = null; // 定义输出流
		BufferedReader buf = null; // 用于接收客户端发送来的信息
		try {
			buf = new BufferedReader(new InputStreamReader(client.getInputStream())); // 得到客户端的输出信息
			out = new PrintStream(client.getOutputStream()); // 实例化客户端的输出流
			boolean flag = true; // 标志位，表示一个客户端是否操作完成
			while (flag) { // 客户端循环操作
				String str = buf.readLine(); // 在此处不断的接收信息
				if (str == null || "".equals(str)) { // 判断输入的信息是否为空
					flag = false; // 客户端操作结束
				} else {
					if ("bye".equals(str)) {
						flag = false;
					} else {
						int length = str.length();
						String str1 = "";
						for (int i = 0; i < length; i++) {
							str1 = str.charAt(i) + str1;
						}
						out.print(str1); // 向客户端回显信息
					}
				}
			}
			out.close(); // 关闭输出流
			client.close(); // 关闭客户端
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

import java.io.*;
import java.net.*;

public class CThread implements Runnable { // ʵ��Runnable�ӿ�
	private Socket client = null; // ���տͻ���

	public CThread(Socket client) { // ͨ�����췽������Socket
		this.client = client;
	}

	@Override
	public void run() { // ����run()����
		PrintStream out = null; // ���������
		BufferedReader buf = null; // ���ڽ��տͻ��˷���������Ϣ
		try {
			buf = new BufferedReader(new InputStreamReader(client.getInputStream())); // �õ��ͻ��˵������Ϣ
			out = new PrintStream(client.getOutputStream()); // ʵ�����ͻ��˵������
			boolean flag = true; // ��־λ����ʾһ���ͻ����Ƿ�������
			while (flag) { // �ͻ���ѭ������
				String str = buf.readLine(); // �ڴ˴����ϵĽ�����Ϣ
				if (str == null || "".equals(str)) { // �ж��������Ϣ�Ƿ�Ϊ��
					flag = false; // �ͻ��˲�������
				} else {
					if ("bye".equals(str)) {
						flag = false;
					} else {
						int length = str.length();
						String str1 = "";
						for (int i = 0; i < length; i++) {
							str1 = str.charAt(i) + str1;
						}
						out.print(str1); // ��ͻ��˻�����Ϣ
					}
				}
			}
			out.close(); // �ر������
			client.close(); // �رտͻ���
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

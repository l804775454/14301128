import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{//�����쳣�׳�
		ServerSocket server = null;                         //����ServerSocket����
		Socket client = null;//����Socket���󣬱�ʾ�ͻ���
		server = new ServerSocket(3333);//�˷�������3333�˿ڽ��м���
		boolean f =true;//����һ�����λ
		while(f){//�����ƽ��տͻ�������
			System.out.println("���������У��ȴ��ͻ�������");
			client = server.accept();//���տͻ�������
			new Thread(new CThread(client)).start();//ʵ����������һ���̶߳���
		}
		server.close();//�رշ�������
	}

}

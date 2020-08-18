package hw.product;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductServer {
	
	public static void main(String[] args) {
		int port = 5100;
		ArrayList<Product> products;
		
		try(ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("소켓 서버 생성");
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			ObjectInputStream objInput = new ObjectInputStream(inputStream);
			
			products = (ArrayList<Product>)objInput.readObject();
			products.addAll((ArrayList<Product>)objInput.readObject());
			Iterator<Product> iter = products.iterator();
			while(iter.hasNext())
				System.out.println(iter.next());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

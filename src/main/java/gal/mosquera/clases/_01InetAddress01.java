package gal.mosquera.clases;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _01InetAddress01 {

	private static void probaMetodos(InetAddress dir) {
		InetAddress dir2;
		
		System.out.println("Método getByName: " + dir);
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("Método getLocalHost: " + dir2);
		} catch (UnknownHostException e) {
		}	
		System.out.println("Método getHostName: " + dir.getHostName());
		System.out.println("Método getHosAddress: " + dir.getHostAddress());
		System.out.println("Método toString: " + dir.toString());
		System.out.println("Método getCanonicalHostName: " + dir.getCanonicalHostName());
	}
	
	public static void main(String[] args) {
		
		InetAddress dir = null;
		
		try {
			dir = InetAddress.getByName("localhost");
			probaMetodos(dir);
			System.out.println();
			
			dir = InetAddress.getByName("www.google.es");
			probaMetodos(dir);			
			InetAddress[] dirs = InetAddress.getAllByName(dir.getHostName());
			for (int i = 0; i < dirs.length; i++) {
				System.out.println("\t\t" + dirs[i]);
			}
			
		} catch (UnknownHostException e) {			
		}

	}

}

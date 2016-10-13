package com.ling.listest;

/*
 * LoadRunner Java script. (Build: _build_number_)

 * 
 * Script Description: 
 *                     
 */

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Actions extends Thread {
	public void run() {
		ServerSocket server = null;
		Socket client = null;
		int port = 39000;
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				client = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Thread thread = new Thread(new Handler(client));
			thread.start();
		}
	}

	public static void main(String[] args) {
		Actions a = new Actions();
		a.start();
	}
}

package com.iu.n1.ex.client;

import java.io.*;
import java.net.*;
import java.util.*;

import com.iu.n1.ex.*;

public class ClientNetwork {
	
	private Socket socket;
	private OutputStream os;
	private OutputStreamWriter ow;
	private BufferedWriter bw;
	private InputStream is;
	private InputStreamReader ir;
	private BufferedReader br;
	

	
	public ClientNetwork() {
	}
	
	public void netWort(int num){
		
		try {
			socket=new Socket("192.168.20.58", 8282);
			os=socket.getOutputStream();
			ow=new OutputStreamWriter(os);
			bw=new BufferedWriter(ow);
			bw.write(num);
			bw.flush();
			

			is=socket.getInputStream();
			ir=new InputStreamReader(is);
			ArrayList<String> s=new ArrayList<>();
			br=new BufferedReader(ir);
			System.out.println(br.readLine());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				ow.close();
				os.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}

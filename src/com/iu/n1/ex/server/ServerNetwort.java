package com.iu.n1.ex.server;

import java.io.*;
import java.net.*;
import java.util.*;

import com.iu.n1.ex.*;

public class ServerNetwort {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private InputStreamReader ir;
	private BufferedReader br;
	private OutputStream os;
	private OutputStreamWriter ow;
	private BufferedWriter bw;
	private LunchDAO idao;
	private DinnerDAO ddao;
	private MenuRandom menuRandom;
	private LunchDTO lunchDTO;
	private DinnerDTO dinnerDTO;

	public ServerNetwort() {
		idao = new LunchDAO();
		ddao = new DinnerDAO();
		menuRandom = new MenuRandom();

	}

	public void netWort() {
		try {
			serverSocket = new ServerSocket(8282);
			socket = serverSocket.accept();
			is = socket.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			int num = br.read();

			os = socket.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);

			if (num == 1) {
				
				ArrayList<LunchDTO> lda = new ArrayList<>();
				lda=idao.getMember();
				lunchDTO = new LunchDTO();
				lunchDTO = menuRandom.randoml(lda);

				String str ="메뉴:"+lunchDTO.getMenu()+"가격:"+String.valueOf(lunchDTO.getPrice());
				bw.write(str);
				bw.flush();
				
			} else if (num == 2) {
				ArrayList<DinnerDTO> dda = ddao.getMember();
				dinnerDTO = new DinnerDTO();
				dinnerDTO = menuRandom.randomd(dda);

				String str1 ="메뉴:"+ dinnerDTO.getMenu()+"가격:"+ String.valueOf(dinnerDTO.getPrice());
				bw.write(str1);
				bw.flush();
			}

		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				serverSocket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

package com.iu.n1.ex;

import java.io.*;
import java.util.*;

public class LunchDAO {

	private File file;
	private FileReader fr;
	private BufferedReader br;
	private StringTokenizer st;
	private Random random;
	private ArrayList<LunchDTO> ar;

	public LunchDAO() {
		file=new File("c:\\test\\lunch.txt");
	}
	
	public ArrayList<LunchDTO> getMember(){
		ar=new ArrayList<>();
		try {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			
			while(br.ready()){
				LunchDTO lunchDTO=new LunchDTO();
				
				String str=br.readLine();
				st=new StringTokenizer(str, ",");
				lunchDTO.setMenu(st.nextToken());
				lunchDTO.setPrice(Integer.parseInt(st.nextToken()));
				ar.add(lunchDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ar;
		
	}
	
	

}

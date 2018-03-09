package com.iu.n1.ex;

import java.io.*;
import java.util.*;

public class DinnerDAO {
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private StringTokenizer st;
	private Random random;
	private ArrayList<DinnerDTO> ar;
	public DinnerDAO() {
		file=new File("c:\\test\\dinner.txt");
	}
	
	public ArrayList<DinnerDTO> getMember(){
		ar=new ArrayList<>();
		try {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			
			while(br.ready()){
				DinnerDTO dinnerDTO=new DinnerDTO();
				
				String str=br.readLine();
				st=new StringTokenizer(str, ",");
				dinnerDTO.setMenu(st.nextToken());
				dinnerDTO.setPrice(Integer.parseInt(st.nextToken()));
				ar.add(dinnerDTO);
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

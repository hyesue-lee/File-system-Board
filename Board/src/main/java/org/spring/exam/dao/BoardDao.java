package org.spring.exam.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

@Repository
public class BoardDao {
	//저장경로 
		private String saveLocation = "/Users/hyesuelee/Desktop/board/data/"; // for MAC
		//private String saveLocation = "D:/board/data/"; // for window
		
	public List<String> list(){ // 목록 
		
		List<String> datas = new ArrayList<String>();
		
		File dirFile = new File(saveLocation);
		File[] files = dirFile.listFiles();
		for(File file : files){
			if(file.isFile()){
				datas.add(file.getName());//파일명으로 파일 읽어들이기
			}
			
		}

		return datas;
		
	};
	

	/**
	 * 글 작성 write
	 * @param params
	 * @return
	 */
	public void write(HashMap<String, String> params) throws IOException{
		
		//1. 디렉토리(폴더) 지정.
		File destDir = new File(this.saveLocation); // 디렉토리 지정. 
		if(!destDir.exists()) { //해당 폴더 존재하지 않으면 
			destDir.mkdirs(); // 만들라 
		}

		//2. 파일 지정 [저장 디렉토리 경로, 저장할 파일명] 
		 File destFile = new File(destDir, params.get("title")); // (저장할 폴더,저장할 파일명)
		 
		//FileCopyUtils.copy([file data], target(디렉토리, 파일명);
		FileCopyUtils.copy(params.get("content").getBytes(), destFile);
	};
	
	
	/**
	 * 글 조회 read
	 */
	public HashMap<String, String> read(HashMap<String, String> params){
		
		//1. 파일 찾기 File(파일위치, 파일명)  
		File file = new File(saveLocation , params.get("title"));
		FileReader fr =null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 BufferedReader br = new BufferedReader(fr);
		 String content="";
		if(file.exists()) { // 해당 위치에 해당 파일명의 파일이 존재하면 
			
			try {
				String line = "";
				while((line = br.readLine()) != null){ //한라인씩 읽어들인다.
	               content = content+ "<br>" + line;
	            }
				br.close();
				
			} catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			} 
			
		}
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("content", content);//읽어들인 내용을 맵에 담는다.
		map.put("title",params.get("title"));
		return map; // 파일정보담은 맵 리턴.. 
	};

	
	/**
	 * 글 삭제 delete 
	 * @param params
	 * @return
	 */
	
	public int delete(HashMap<String, String> params){
		//1. 파일 찾기 File(파일위치, 파일명)  
		int result = 0;
		File file = new File(saveLocation , params.get("title")); // 파일명 
		 System.out.println("del title check:"+ params.get("title"));
		 if(file.exists()) { // 해당 위치에 해당 파일명의 파일이 존재하면 
			 file.delete();
			 result = 1;//삭제 성공 
		 }
		 return result;
	};
	
	/**
	 * 글 수정 update 
	 * @param params
	 * @return
	 */
	public HashMap<String, String> update(HashMap<String, String> params){
		
		File file = new File(saveLocation , params.get("title")); // 파일명 
		File fileNew = new File(saveLocation , params.get("titleNew")); // 새파일명 
		if(file.exists()) file.renameTo(fileNew);//새파일명으로 변경
		String msg="";
		
		//내용 수정(덮어쓰기)
		try {
			FileCopyUtils.copy(params.get("content").getBytes(), fileNew);
			msg ="수정완료";//수정성공메세지 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("title", fileNew.getName());
		map.put("msg", msg);
		return map;
	};
}

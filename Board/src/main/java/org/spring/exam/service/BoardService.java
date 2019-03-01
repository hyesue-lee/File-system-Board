package org.spring.exam.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public interface BoardService {
	/**
	 * 모든 리스트 list 
	 * @param typeSeq
	 * @return
	 */
	public List<String> list();
	

	/**
	 * 글 작성 write
	 * @param params
	 * @return
	 */
	public void write(HashMap<String, String> params) throws IOException;
	
	
	/**
	 * 글 조회 read
	 */
	public HashMap<String, String> read(HashMap<String, String> params);

	
	/**
	 * 글 삭제 delete 
	 * @param params
	 * @return
	 */
	
	public int delete(HashMap<String, String> params);
	
	/**
	 * 글 수정 update 
	 * @param params
	 * @return
	 */
	public HashMap<String, String> update(HashMap<String, String> params);

}

package org.spring.exam.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.spring.exam.dao.BoardDao;
import org.spring.exam.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired BoardDao dao;
	
	@Override
	public List<String> list() {
		
		return dao.list();
	}

	@Override
	public void write(HashMap<String, String> params) throws IOException {
		dao.write(params);
	}

	@Override
	public HashMap<String, String> read(HashMap<String, String> params) {
		
		return dao.read(params);
	}

	@Override
	public int delete(HashMap<String, String> params) {
		
		return dao.delete(params);
	}

	@Override
	public HashMap<String, String> update(HashMap<String, String> params) {
		
		return dao.update(params);
	}

}

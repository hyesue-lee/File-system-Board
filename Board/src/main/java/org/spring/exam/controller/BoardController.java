package org.spring.exam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.spring.exam.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService; 
		
		//home
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView home(Locale locale, Model model) {
			
			ModelAndView mv = new ModelAndView();
			RedirectView rv = new RedirectView("/exam/board/list.do");//게시판 목록으로
			mv.setView(rv);
			
			return mv;
		}
	
		//목록 
		@RequestMapping("/board/list.do")
		public ModelAndView list(@RequestParam HashMap<String, Object> params){
			
			System.out.println("n list params check: " + params);
			ModelAndView mv = new ModelAndView();

					//전체 게시글 리스트 셀렉.	
					List<String> selectList = new ArrayList<String>();
					
					//selectList = fileSystem.listFile(); 
					selectList = boardService.list();
					System.out.println("list:"+selectList);

					mv.addObject("list", selectList);
					if(params.containsKey("msg")){
						mv.addObject("msg", params.get("msg"));
					}
					mv.setViewName("board/list");
	
				
			return mv;
		}
		
		//글쓰기 페이지로 	
		@RequestMapping("/board/goToWrite.do")
		public ModelAndView goToWrite(@RequestParam HashMap<String, Object> params) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/board/write");
			return mv;
		}
		
		
		
		// 글쓰기
		@RequestMapping("/board/write.do")
		@ResponseBody
		public ModelAndView write(@RequestParam HashMap<String, String> params) throws IOException {

			System.out.println("write params:" + params);
			ModelAndView mv = new ModelAndView();
	
			boardService.write(params); // 글쓰기 service호출 
			HashMap<String, String> map = boardService.read(params); //해당글 읽기 service호출 

			mv.addObject("params",map);
		
			mv.setViewName("/board/read"); //작성글 조회페이지로 
			return mv;
			
			
		}
		
		//읽기 
		@RequestMapping("/board/read.do")
		public ModelAndView read(@RequestParam HashMap<String, String> params) {
			ModelAndView mv = new ModelAndView();

			HashMap<String,String> map = new HashMap<String,String>();
			map = boardService.read(params); // read service호출 
			mv.setViewName("/board/read");
			mv.addObject("params",map);

			return mv;
		}
		
		//글 삭제 
		@RequestMapping("/board/delete.do")
		public ModelAndView delete(@RequestParam HashMap<String,String> params) {
			ModelAndView mv = new ModelAndView();
				
				int result = boardService.delete(params);	//삭제 service 호출 
					if(result == 1 ) {
					RedirectView rv = new RedirectView("/exam/board/list.do");
					mv.setView(rv);
				
					mv.addObject("msg", "삭제 완료");
					}
				
			return mv;
			}
		
		//수정페이지로 
		@RequestMapping("/board/goToUpdate.do")
		public ModelAndView goToUpdate(@RequestParam HashMap<String,String> params) {
			ModelAndView mv = new ModelAndView();
			System.out.println("gotoupdate paramsssssss:"+params);
				
				//해당 글 정보 받기 위해 read 
				HashMap<String,String> map = new HashMap<String,String>();

				map = boardService.read(params); //read service호출 
				
				mv.setViewName("/board/update");
				mv.addObject("params",map);
			return mv;
		}
		
		//수정 
		@RequestMapping("/board/update.do")
		public ModelAndView update(@RequestParam HashMap<String,String> params) {
			ModelAndView mv = new ModelAndView();

			
			HashMap<String,String> map= new HashMap<String,String>();
			map = boardService.update(params); //글 정보 수정 service 호출 
			
			//read redirect 
			RedirectView rv = new RedirectView("/exam/board/list.do");
			mv.setView(rv);
			
			mv.addObject("params" ,map);
			mv.addObject("msg", map.get("msg"));
			return mv;
		}
		
		
		
}

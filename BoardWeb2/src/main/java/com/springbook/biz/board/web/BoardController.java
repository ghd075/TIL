package com.springbook.biz.board.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Paging;
import com.springbook.biz.common.Paging2;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@ModelAttribute("condMap")
	public Map<String, String> searchConditionMap()
	{
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("작성자", "WRITER");
		return conditionMap;
	}
	
	//수정폼
	//방법2
	@RequestMapping(value ="/boardUpdate/{seq}", method=RequestMethod.GET)
	public String boardUpdateForm(Model model,
								  @PathVariable Integer seq,
								  BoardVO vo) {
		vo.setSeq(seq); //seq 값 넘기기
		//단건조회
		model.addAttribute("board", service.getBoard(vo));
		//컨트롤러 메소드가 생성하는 모델 정보 중에서 @SessionAttributes에 지정한 이름과
		//동일한 이름이 있다면 이를 세션에 저장해준다.
		return "boardUpdate";
	}
	
	//방법1
	/*
	 * @RequestMapping(value ="/boardUpdate", method=RequestMethod.GET) public
	 * String boardUpdateForm(Model model, BoardVO vo) { //단건조회
	 * model.addAttribute("board", service.getBoard(vo)); return "boardUpdate"; }
	 */
	
	//수정처리
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(@ModelAttribute("board") BoardVO vo
							  ,SessionStatus st) {
		System.out.println("===update 파라미터 확인===\n"+vo);
		service.updateBoard(vo);
		st.setComplete(); //@SessionAttributes로 지정한 세션 속성을 지운다.
		return "redirect:boardList";
	}
	
	//목록조회
	@RequestMapping("/boardList")
	//public String boardList(Model model, BoardVO vo, Paging paging) {
	public String boardList(Model model, Paging2 paging, 
							@RequestParam(value="searchCondition", 
										  defaultValue="TITLE", 
										  required=false) String condition,
							@RequestParam(value="searchKeyword", 
										  required=false) String keyword) {
							//방법1
							//@RequestParam(value="searchKeyword", defaultValue="", required=false) String searchKeyword) {
		/*
		 * ArrayList<String> list = new ArrayList<String>(); list.add("사과");
		 * list.add("바나나");
		 */
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(condition);
		vo.setSearchKeyword(keyword);
		
		//페이징 처리
		// 페이지번호 파라미터
		if( paging.getPage() == null) {
			paging.setPage(1); 
		}
				
		// 시작/마지막 레코드 번호
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		//전체건수
		paging.setTotalRecord(service.getBoardCount(vo));
		
		model.addAttribute("paging", paging);
		model.addAttribute("list", service.getBoardList(vo));
		return "board";
	}
	
	//등록폼
	@RequestMapping("/boardInsertForm")
	public String boardInsertForm() {
		return "boardInsert";
	}
	
	//등록처리
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo, MultipartFile uploadFile) throws IllegalStateException, IOException {
		//파일 업로드 처리
		//MultipartFile uploadFile = vo.getUploadFile();
		//첨부 파일이 있으면
		if(!uploadFile.isEmpty() && uploadFile.getSize() > 0) {
			String filename = uploadFile.getOriginalFilename();
			long filesize = uploadFile.getSize();
			uploadFile.transferTo(new File("D:\\upload", filename));
			vo.setFilename(filename);
			System.out.println("업로드파일 : " + filename + " : " + filesize);
		}
		service.insertBoard(vo);
		return "redirect:boardList";
	}
	
	//삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		service.deleteBoard(vo);
		return "redirect:boardList";
	}
	
	/**
	 * 첨부파일로 등록된 파일에 대하여 다운로드를 제공한다.
	 *
	 * @param commandMap
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/FileDown")
	public void cvplFileDownload(@RequestParam Map<String, Object> commandMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String seq = (String) commandMap.get("seq");


		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(Integer.parseInt(seq));
		BoardVO result = service.getBoard(boardVO); //board테이블에서 단건조회!!

		File uFile = new File("d:/upload/", result.getFilename()); //파일이 저장되어 있는 경로 지정
		long fSize = uFile.length();

		if (fSize > 0) {
			String mimetype = "application/x-msdownload"; //다운로드 타입에 따라서 다운로드방식이 다르다.

			response.setContentType(mimetype);
			setDisposition(result.getFilename(), request, response);

			BufferedInputStream in = null;
			BufferedOutputStream out = null;

			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());

				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				in.close();
				out.close();
			}

		} else {
			response.setContentType("application/x-msdownload");

			PrintWriter printwriter = response.getWriter();
			
			printwriter.println("<html>");
			printwriter.println("<br><br><br><h2>Could not get file name:<br>" + result.getFilename() + "</h2>");
			printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("<br><br><br>&copy; webAccess");
			printwriter.println("</html>");
			
			printwriter.flush();
			printwriter.close();
		}
	}
	
	/**
	 * Disposition 지정하기.
	 *
	 * @param filename
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = getBrowser(request);

		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;

		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new IOException("Not supported browser");
		}

		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);

		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}
	
	/**
	 * 브라우저 구분 얻기.
	 *
	 * @param request
	 * @return
	 */
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}
}

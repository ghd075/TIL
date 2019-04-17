package com.jogiyo.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.controller.board.BoardInsertController;
import com.jogiyo.controller.board.BoardInsertFormController;
import com.jogiyo.controller.member.LoginController;
import com.jogiyo.controller.member.LoginFormController;
import com.jogiyo.controller.member.LoginOutController;
import com.jogiyo.controller.member.MemberDeleteController;
import com.jogiyo.controller.member.MemberDeleteFormController;
import com.jogiyo.controller.member.MemberInfoController;
import com.jogiyo.controller.member.MemberInsertController;
import com.jogiyo.controller.member.MemberModifyController;
import com.jogiyo.controller.member.MemberModifyFormController;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String charset = null; //인코딩 문자코드 지정할 변수
	HashMap<String, Controller> list = null; //컨트롤러 정보를 저장할 변수

	@Override
	public void init(ServletConfig sc) throws ServletException {

		charset = sc.getInitParameter("charset");
		
		//필요한 컨트롤러들을 리스트에 담아두기
		//('사용자가 정한 s이름.do', new 해당 컨트롤러);
		list = new HashMap<String, Controller>();
		list.put("/board/BoardList.do", new BoardListController());//메뉴 게시판
		list.put("/board/BoardList2.do", new BoardListController2());//지역 게시판
		list.put("/board/BestList.do", new BestListController());//베스트 게시판
		list.put("/admin/PostList.do", new PostListController());//게시물 리스트
		list.put("/admin/PostDelete.do", new PostDeleteController2());//게시물 삭제
		list.put("/admin/MemberList.do", new MemberListController()); //회원 리스트
		list.put("/admin/MemberDelete.do", new MemberDeleteController2());//회원삭 제
		//list.put("/memberInsert.do", new MemberInsertController());
		
		list.put("/board/MemberInsert.do", new BoardInsertController());//글쓰기 처리
		list.put("/board/MemberInsertForm.do", new BoardInsertFormController());//글쓰기화면 이동
		
		/**
		 * 회원가입, 로그인 관련 컨트롤러
		 * */
		list.put("/main/MianForm.do", new MainFormController()); //메인화면 이동
		list.put("/member/LoginForm.do", new LoginFormController()); //로그인화면 이동
		list.put("/member/RegisterForm.do", new RegisterFormController()); //회원가입화면 이동
		list.put("/member/MemberInfo.do", new MemberInfoController()); //화면에 보여줄 내정보 보여주기
		list.put("/member/MemberLogin.do", new LoginController()); //로그인처리
		list.put("/member/MemberLoginOut.do", new LoginOutController()); //로그아웃처리
		list.put("/member/MemberInsert.do", new MemberInsertController()); //회원가입처리
		list.put("/member/MemberModifyForm.do", new MemberModifyFormController()); //회원수정화면 이동
		list.put("/member/MemberModify.do", new MemberModifyController()); //회원수정처리
		list.put("/member/MemberDeleteForm.do", new MemberDeleteFormController()); //회원탈퇴화면 이동
		list.put("/member/MemberDelete.do", new MemberDeleteController()); //회원탈퇴처리
		/**
		 * 공지사항 관련 컨트롤러
		 * */
		list.put("/notice/AddNotice.do", new AddNoticeController()); //공지사항삽입처리
		list.put("/notice/NoticeUpdate.do", new NoticeUpdateController()); //공지사항수정처리
		list.put("/notice/NoticeDelete.do", new NoticeDeleteController()); //공지사항삭제처리
		list.put("/notice/DeleteBlack.do", new DeleteBlackListController()); //블랙리스트삭제
		list.put("/notice/AddBlack.do", new AddBlackListController()); //블랙리스트추가
		list.put("/notice/CntFood.do", new CntFoodController()); //음식점차트
		list.put("/notice/LocFood.do", new LocFoodController()); //음식점차트
		list.put("/notice/RankFood.do", new RankFoodController()); //음식점차트
		list.put("/notice/RankListForm.do", new RankListFormController()); //블랙리스트 화면으로 이동
		list.put("/chart/ChartForm.do", new ChartFormController()); //차트화면 화면으로 이동
		list.put("/notice/NoticeListForm.do", new NoticeListFormController()); //공지사항 화면으로 이동
		list.put("/notice/NoticeSelect.do", new NoticeSelectController()); //공지사항 선택
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * 댓글 관련 컨트롤러
		 * */
		list.put("/board/displayBoard.do", new DisplayBoardController());		//게시글 출력
		list.put("/board/updateBoardPage.do", new PostFormController());			//댓글수정 페이지
		list.put("/board/updateBoard.do", new PostUpdateController());			//댓글수정
		list.put("/board/deleteBoard.do", new PostDeleteController());			//댓글 삭제
		list.put("/board/displaylike.do", new LikeController());				//좋아요 출력
		list.put("/board/displayComment.do", new DisplayCommentController());	//댓글리스트 출력
		list.put("/board/checkEval.do", new EvaluationController());			//계정당 평점체크
		list.put("/board/insertBoard.do", new repleController());				//댓글입력
		list.put("/board/updateReple.do", new RepleUpdateController());			//댓글수정
		list.put("/board/deleteReple.do", new RepleDeleteController());			//댓글 삭제
		
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding(charset);

		String url = request.getRequestURI();
		// uri : /dev/memberInsert.do
		String contextPath = request.getContextPath();
		// contextPath 구하기(/dev)
		String path = url.substring(contextPath.length());
		// 경로 구하기
		// /memberInsert.do
		Controller subController = list.get(path);
		//해당 컨트롤러 찾고(MemberInsertController())
		String view = subController.execute(request, response);
		//이동할 페이지를 view변수에 담는다.
		//다형성(실행결과가 다 다름)
		//참조하는 자식객체 메서드 호출
		if( view != null) { //view변수가 NULL값이 아니면
			if(view.startsWith("redirect:")) { //view변수의 데이터가 redirect:로 시작하면
				response.sendRedirect(view.substring(9)); // /dev/memberList.do페이지를 리다이렉트로 실행
			}else {
				HttpUtil.forward(request, response, view); // view에 저장될 값을 forward로 실행
			}
		}
	}
}

package com.jogiyo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jogiyo.vo.HjhDTO;
import com.web.common.DAO;

public class HjhDAO extends DAO {
	private static HjhDAO dao = new HjhDAO();

	public static HjhDAO getInstance() {
		return dao;
	}

//food_code 게시판 조회
	public ArrayList<HjhDTO> boardList(int first, int last, String food_code) throws SQLException {

		ArrayList<HjhDTO> list = new ArrayList<HjhDTO>();

		PreparedStatement psmt = null;
		ResultSet rs = null;

		HjhDTO b_dto = null;
		connect();

		psmt = conn.prepareStatement(// where jsp에서 food_code 값을 받아온다.
				"select*from(select a.*, rownum rn from("
						+ " select board_no, title, board_text, images, cnt, b_date, user_code, food_code, loc_code from board where food_code=?"
						+ " ) a ) b where rn between ? and ?");
		psmt.setString(1, food_code);
		psmt.setInt(2, first);
		psmt.setInt(3, last);

		rs = psmt.executeQuery();

		while (rs.next()) {
			b_dto = new HjhDTO();
			b_dto.setBoard_no(rs.getInt("board_no"));
			b_dto.setTitle(rs.getString("title"));
			b_dto.setBoard_text(rs.getString("board_text"));
			b_dto.setImages(rs.getString("images"));
			b_dto.setCnt(rs.getInt("cnt"));
			b_dto.setB_date(rs.getDate("b_date"));
			b_dto.setUser_code(rs.getInt("user_code"));
			b_dto.setFood_code(rs.getString("food_code"));
			b_dto.setLoc_code(rs.getString("loc_code"));

			list.add(b_dto);
		}

		return list;
	}

	// 전체건수(페이징.푸드)
	public int count(String food_code) throws SQLException {
		connect();
		int cnt = 0;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		psmt = conn.prepareStatement("SELECT count(*) from board where food_code=?");
		psmt.setString(1, food_code);// jsp의 값을 받기 위해 파라미트를 쓴다.
		rs = psmt.executeQuery();

		rs.next();
		cnt = rs.getInt(1);// 첫번째 컬럼의 레코드 수

		return cnt;
	}

	// loc_code 게시판 조회
	public ArrayList<HjhDTO> boardList_l(int first, int last, String loc_code) throws SQLException {

		ArrayList<HjhDTO> list = new ArrayList<HjhDTO>();

		PreparedStatement psmt = null;
		ResultSet rs = null;

		HjhDTO b_dto = null;
		connect();

		psmt = conn.prepareStatement(// where jsp에서 food_code 값을 받아온다.
				"select*from(select a.*, rownum rn from("
						+ " select board_no, title, board_text, images, cnt, b_date, user_code, food_code, loc_code from board where loc_code=?"
						+ " ) a ) b where rn between ? and ?");
		psmt.setString(1, loc_code);
		psmt.setInt(2, first);
		psmt.setInt(3, last);

		rs = psmt.executeQuery();

		while (rs.next()) {
			b_dto = new HjhDTO();
			b_dto.setBoard_no(rs.getInt("board_no"));
			b_dto.setTitle(rs.getString("title"));
			b_dto.setBoard_text(rs.getString("board_text"));
			b_dto.setImages(rs.getString("images"));
			b_dto.setCnt(rs.getInt("cnt"));
			b_dto.setB_date(rs.getDate("b_date"));
			b_dto.setUser_code(rs.getInt("user_code"));
			b_dto.setFood_code(rs.getString("food_code"));
			b_dto.setLoc_code(rs.getString("loc_code"));

			list.add(b_dto);
		}

		return list;
	}

	// 전체건수(페이징.지역)
	public int count_l(String loc_code) throws SQLException {
		connect();
		int cnt = 0;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		psmt = conn.prepareStatement("SELECT count(*) from board where loc_code=?");
		psmt.setString(1, loc_code);// jsp의 값을 받기 위해 파라미트를 쓴다.
		rs = psmt.executeQuery();

		rs.next();
		cnt = rs.getInt(1);// 첫번째 컬럼의 레코드 수

		return cnt;
	}

	// 랭크조회
	public ArrayList<HjhDTO> bestList() throws SQLException {

		ArrayList<HjhDTO> list = new ArrayList<HjhDTO>();

		PreparedStatement psmt = null;
		ResultSet rs = null;

		HjhDTO b_dto = null;
		connect();

		psmt = conn.prepareStatement(// where jsp에서 food_code 값을 받아온다.
				" select*from(select a.*, rownum rn from("
						+ " select board.board_no, board.images, board.title, avg(EVAL.eval_score) avg_score, COUNT(LIKES.USER_CODE) CNT\r\n"
						+ " from board , reples, eval, LIKES\r\n"
						+ " where board.board_no = reples.board_no and reples.reple_no = eval.reple_no AND BOARD.BOARD_NO = LIKES.BOARD_NO(+)\r\n"
						+ " group by board.board_no, board.images, board.title\r\n" 
						+ " order by avg_score DESC, CNT DESC"
						+ " ) a ) b where rn <=3");

		rs = psmt.executeQuery();

		while (rs.next()) {
			b_dto = new HjhDTO();
			b_dto.setBoard_no(rs.getInt("board_no"));
			b_dto.setImages(rs.getString("images"));
			b_dto.setTitle(rs.getString("title"));
			list.add(b_dto);
		}

		return list;
	}

	// 전체 게시판 조회
	public ArrayList<HjhDTO> PostList(int first, int last, String desc) throws SQLException {

		if (desc == null) { // 널값이라 오류가 나기 때문에 기본 값을 설정해줌

			desc = "desc";
		}
		ArrayList<HjhDTO> list = new ArrayList<HjhDTO>();

		PreparedStatement psmt = null;
		ResultSet rs = null;

		HjhDTO b_dto = null;
		connect();

		psmt = conn.prepareStatement(// where jsp에서 food_code 값을 받아온다.
				"select*from(select a.*, rownum rn from("
						+ " select board_no, title, board_text, images, cnt, b_date, user_code, food_code, loc_code from board"
						+ " order by CNT " + desc + " ) a ) b where rn between ? and ?");

		psmt.setInt(1, first);
		psmt.setInt(2, last);

		rs = psmt.executeQuery();

		while (rs.next()) {
			b_dto = new HjhDTO();
			b_dto.setBoard_no(rs.getInt("board_no"));
			b_dto.setTitle(rs.getString("title"));
			b_dto.setBoard_text(rs.getString("board_text"));
			b_dto.setImages(rs.getString("images"));
			b_dto.setCnt(rs.getInt("cnt"));
			b_dto.setB_date(rs.getDate("b_date"));
			b_dto.setUser_code(rs.getInt("user_code"));
			b_dto.setFood_code(rs.getString("food_code"));
			b_dto.setLoc_code(rs.getString("loc_code"));
			b_dto.setRn(rs.getInt("rn"));

			list.add(b_dto);
		}

		return list;
	}

	// 전체건수(페이징)
	public int count_b(String desc) throws SQLException {
		connect();
		int cnt = 0;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		psmt = conn.prepareStatement("SELECT count(*) from board");

		rs = psmt.executeQuery();

		rs.next();
		cnt = rs.getInt(1);// 첫번째 컬럼의 레코드 수

		return cnt;
	}

	// 삭제기능(보드)
	public boolean delete(int board_no_d) {
		try {
			connect();
			PreparedStatement psmt = null;
			// 자식참조 제거 likes
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement("delete likes where board_no = ?");
			psmt.setInt(1, board_no_d);
			int rs = psmt.executeUpdate();
			// 자식참조 제거 eval
			psmt = conn
					.prepareStatement("delete eval where reple_no in (select reple_no from reples where board_no =?)");
			psmt.setInt(1, board_no_d);
			rs = psmt.executeUpdate();

			// 자식참조 제거 reples
			psmt = conn.prepareStatement("delete reples where board_no = ?");
			psmt.setInt(1, board_no_d);
			rs = psmt.executeUpdate();

			// 게시판 제거
			psmt = conn.prepareStatement("delete board where board_no = ?");
			psmt.setInt(1, board_no_d);
			rs = psmt.executeUpdate();
			if (rs != 1)
				throw new Exception();
			conn.commit(); // 커밋
		} catch (Exception e) {
			System.out.print("삭제오류" + e.getMessage());
			try {
				conn.rollback(); // 오류시에 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	// 전체 회원 조회
	public ArrayList<HjhDTO> MemberList(int first, int last, String desc) throws SQLException {

		if (desc == null) { // 널값이라 오류가 나기 때문에 기본 값을 설정해줌

			desc = "desc";
		}
		ArrayList<HjhDTO> list = new ArrayList<HjhDTO>();

		PreparedStatement psmt = null;
		ResultSet rs = null;

		HjhDTO b_dto = null;
		connect();

		psmt = conn.prepareStatement(// where jsp에서 food_code 값을 받아온다.
				"select*from(select a.*, rownum rn from(" + " select user_code, user_name, phone, address, r_date\r\n"
						+ " from members " + " order by r_date " + desc + " ) a ) b where rn between ? and ?");

		psmt.setInt(1, first);
		psmt.setInt(2, last);

		rs = psmt.executeQuery();

		while (rs.next()) {
			b_dto = new HjhDTO();
			b_dto.setUser_code(rs.getInt("user_code"));
			b_dto.setUser_name(rs.getString("user_name"));
			b_dto.setPhone(rs.getString("phone"));
			b_dto.setAddress(rs.getString("address"));
			b_dto.setR_date(rs.getDate("r_date"));
			b_dto.setRn(rs.getInt("rn"));

			list.add(b_dto);
		}

		return list;
	}

	// 전체건수(페이징)
	public int count_m(String desc) throws SQLException {
		connect();
		int cnt = 0;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		psmt = conn.prepareStatement("SELECT count(*) from members");

		rs = psmt.executeQuery();

		rs.next();
		cnt = rs.getInt(1);// 첫번째 컬럼의 레코드 수

		return cnt;
	}

	// 삭제기능(회원)
	public boolean delete_m(int user_code_d) {
		try {
			connect();
			PreparedStatement psmt = null;

			// 자식참조 제거 eval
			psmt = conn
					.prepareStatement("delete eval where reple_no in (select reple_no from reples where user_code =?)");
			psmt.setInt(1, user_code_d);
			int rs = psmt.executeUpdate();

			// 자식참조 제거 reples
			psmt = conn.prepareStatement("delete reples where user_code = ?");
			psmt.setInt(1, user_code_d);
			rs = psmt.executeUpdate();

			// 자식참조 제거 likes
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement("delete likes where user_code = ?");
			psmt.setInt(1, user_code_d);
			rs = psmt.executeUpdate();

			// 자식참조제거board(보드와 멤버테이블 참조관계 끊기)

			psmt = conn.prepareStatement("delete board where user_code = ?");
			psmt.setInt(1, user_code_d);
			rs = psmt.executeUpdate();
				// 멤버 제거
				psmt = conn.prepareStatement("delete members where user_code = ?");
			psmt.setInt(1, user_code_d);
			rs = psmt.executeUpdate();
			if (rs != 1)
				throw new Exception();
			conn.commit(); // 커밋
		} catch (Exception e) {
			System.out.print("삭제오류" + e.getMessage());
			try {
				conn.rollback(); // 오류시에 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

}

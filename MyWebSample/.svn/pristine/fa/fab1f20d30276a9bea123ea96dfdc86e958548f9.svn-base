package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jogiyo.vo.MemberDTO;
import com.jogiyo.vo.RepleDTO;
import com.web.common.DAO;

public class RepleDAO  extends DAO {
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	// 싱글톤 : static 필드
	static RepleDAO instance;
	
	public static RepleDAO getInstance() {
		if (instance == null)
			instance = new RepleDAO();
		return instance; 
		
	}
	
	public RepleDTO selectLast() throws Exception {
		RepleDTO bean = new RepleDTO();
		try {
			
			connect();
			stmt = conn.createStatement();
		
			String sql = "SELECT reple_no " +
					"FROM " + 
					"( SELECT reple_no FROM reples ORDER BY reple_no DESC ) " +
					"WHERE ROWNUM = 1";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				bean.setRepleNo(rs.getInt("reple_no"));
			}		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return bean;
	}
	// 중복 평점 체크
	public List<HashMap<String, Object>> checkEval(RepleDTO bean, MemberDTO mbean) throws Exception {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "select check_code from eval where user_code = "
					+ "(select user_code from members where id = ?) and check_code = 'T' and board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mbean.getId());
			pstmt.setInt(2, bean.getBoardNo());			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put(("checkValue"), rs.getString("check_code"));
				list.add(map);
			}
		} catch (Throwable e) {
			System.out.println("Eval check DB error");
			throw new Exception(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}		
		return list;
	}
	// 댓글목록
	public List<HashMap<String, Object>> selectAll(RepleDTO bean) throws Exception {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "select "
					+ "r.reple_no as reple_no"
					+ ", r.p_no as p_no"
					+ ", r.re_seq as re_seq"
					+ ", r.re_level as re_level"
					+ ", r.reple_text as reple_text"
					+ ", to_char(r.re_date, 'yyyy-mm-dd hh24:mi:ss') as re_date"
					+ ", m.id as user_id"
					+ ", r.board_no as board_no"
					+ ", e.eval_score as eval_score"
					+ ", e.check_code as check_code"
					+ " from reples r LEFT OUTER JOIN members m "
					+ "ON r.user_code = m.user_code "
					+ "LEFT OUTER JOIN eval e ON r.reple_no = e.reple_no "
					+ "where r.board_no = ? order by reple_no";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getBoardNo());			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("repleNo", rs.getInt("reple_no"));
				map.put("pNo", rs.getInt("p_no"));
				map.put("reSeq", rs.getInt("re_seq"));
				map.put("reLevel", rs.getInt("re_level"));
				map.put("repleText", rs.getString("reple_text"));
				map.put("rDate", rs.getString("re_date"));
				map.put(("userId"), rs.getString("user_id"));
				map.put(("bNo"), rs.getInt("board_no"));
				map.put(("score"), rs.getInt("eval_score"));
				map.put(("checkValue"), rs.getString("check_code"));
				list.add(map);
			}
		} catch (Throwable e) {
			System.out.println("comment selectAll error" + e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return list;
	}// end of method
	
	public HashMap<String, Object> update(RepleDTO bean) throws Exception {
		PreparedStatement pstmtCommentInsert = null;
		try {
			connect();
			conn.setAutoCommit(false);   //트랜잭션 처리
			//String sql ="update reples set reple_text=?, re_date=? where reple_no=? ";
			String sql ="update reples set reple_text=?, re_date=to_date(?,'yyyy-mm-dd hh24:mi:ss')	 where reple_no=? ";
			pstmtCommentInsert = conn.prepareStatement(sql);
			pstmtCommentInsert.setString(1, bean.getRepleText());
			pstmtCommentInsert.setString(2, bean.getReDate());			
			pstmtCommentInsert.setInt(3, bean.getRepleNo());
			/*
			System.out.println(bean.getRepleText());
			System.out.println(bean.getReDate());
			System.out.println(bean.getRepleNo());
			*/
			pstmtCommentInsert.executeUpdate();
			conn.commit();   // 커밋
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("repleNo", bean.getRepleNo());
			map.put("repleText", bean.getRepleText());
			map.put("rDate", bean.getReDate());
			return map;
		} catch (Throwable e) {
			try {
				conn.rollback();  //롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		} finally {
			conn.close();
		}
	}
	public HashMap<String, Object> delete(RepleDTO bean) throws Exception {
		PreparedStatement pstmtCommentInsert = null;
		try {
			connect();
			conn.setAutoCommit(false);   //트랜잭션 처리
			String sql ="delete from reples where reple_no=? "; 
			pstmtCommentInsert = conn.prepareStatement(sql);
			pstmtCommentInsert.setInt(1, bean.getRepleNo());
			pstmtCommentInsert.executeUpdate();

			conn.commit();   // 커밋
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("repleNo", bean.getRepleNo()); 
			return map;
		} catch (Throwable e) {
			try {
				conn.rollback();  //롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		} finally {
			conn.close();
		}
	}	
	
	public int insert(RepleDTO bean) {
		int n = 0;
		PreparedStatement pstmtCommentInsert = null;
		PreparedStatement pstmtEvalInsert = null;
		try {
			connect();
			conn.setAutoCommit(false);
			String sql1 = "insert into reples (reple_no, p_no, re_seq, re_level, "
					+ "reple_text, re_date, user_code, board_no) values (?,?,?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
			pstmtCommentInsert = conn.prepareStatement(sql1);
			pstmtCommentInsert.setInt(1, bean.getRepleNo());
			pstmtCommentInsert.setInt(2, bean.getpNo());
			pstmtCommentInsert.setInt(3, bean.getReSeq());
			pstmtCommentInsert.setInt(4, bean.getReLevel());
			pstmtCommentInsert.setString(5, bean.getRepleText());
			pstmtCommentInsert.setString(6, bean.getReDate());
			pstmtCommentInsert.setInt(7, bean.getUserCode());
			pstmtCommentInsert.setInt(8, bean.getBoardNo());
			System.out.println(bean.getRepleNo());
			System.out.println(bean.getpNo());
			System.out.println(bean.getReSeq());
			System.out.println(bean.getReLevel());
			System.out.println(bean.getRepleText());
			System.out.println(bean.getReDate());
			System.out.println(bean.getUserCode());
			System.out.println(bean.getBoardNo());
			pstmtCommentInsert.executeUpdate();
			String sql2 = "insert into eval (reple_no, eval_score, check_code, user_code, board_no) values (?,?,?,?,?)";
			pstmtEvalInsert = conn.prepareStatement(sql2);
			pstmtEvalInsert.setInt(1, bean.getRepleNo());
			pstmtEvalInsert.setInt(2, bean.getEvalScore());
			pstmtEvalInsert.setString(3, bean.getCheckCode());
			pstmtEvalInsert.setInt(4, bean.getUserCode());
			pstmtEvalInsert.setInt(5, bean.getBoardNo());
			pstmtEvalInsert.executeUpdate();
			conn.commit();   // 커밋			
/*
			System.out.println(bean.getRepleNo());
			System.out.println(bean.getEvalScore());
			System.out.println(bean.getCheckCode());
			System.out.println(bean.getUserCode());
*/						
		} catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
			n = 1;
			try {
				conn.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			//5. 연결해제
			disconnect();
		}
		
		return n;
	}

	public int repleyInsert(RepleDTO bean) {
		int n = 0;
		PreparedStatement pstmtCommentInsert = null;
		PreparedStatement pstmtEvalInsert = null;
		try {
			connect();
			conn.setAutoCommit(false);
			//System.out.println("-------------------------------------------");
			//System.out.println(bean);
			//System.out.println("-------------------------------------------");
			
			String sql1 = "update reples set re_seq = re_seq + 1 where p_no = ? and re_seq >= ?";
			
			pstmtCommentInsert = conn.prepareStatement(sql1);
			pstmtCommentInsert.setInt(1, bean.getpNo());
			pstmtCommentInsert.setInt(2, bean.getReSeq());			
			
			//System.out.println(bean.getRepleText());
			//System.out.println(bean.getReDate());
			//System.out.println(bean.getRepleNo());
			pstmtCommentInsert.executeUpdate();

			String sql2 = "insert into reples (reple_no, p_no, re_seq, re_level, "
					+ "reple_text, re_date, user_code, board_no) values (?,?,?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
			pstmtCommentInsert = conn.prepareStatement(sql2);
			pstmtCommentInsert.setInt(1, bean.getRepleNo());
			pstmtCommentInsert.setInt(2, bean.getpNo());
			pstmtCommentInsert.setInt(3, bean.getReSeq());
			pstmtCommentInsert.setInt(4, bean.getReLevel());
			pstmtCommentInsert.setString(5, bean.getRepleText());
			pstmtCommentInsert.setString(6, bean.getReDate());
			pstmtCommentInsert.setInt(7, bean.getUserCode());
			pstmtCommentInsert.setInt(8, bean.getBoardNo());
			pstmtCommentInsert.executeUpdate();
			String sql3 = "insert into eval (reple_no, eval_score, check_code, user_code, board_no) values (?,?,?,?,?)";
			pstmtEvalInsert = conn.prepareStatement(sql3);
			pstmtEvalInsert.setInt(1, bean.getRepleNo());
			pstmtEvalInsert.setInt(2, bean.getEvalScore());
			pstmtEvalInsert.setString(3, bean.getCheckCode());
			pstmtEvalInsert.setInt(4, bean.getUserCode());
			pstmtEvalInsert.setInt(5, bean.getBoardNo());
			pstmtEvalInsert.executeUpdate();
			conn.commit();   // 커밋
	
		} catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
			n = 1;
			try {
				conn.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			//5. 연결해제
			disconnect();
		}
		
		return n;
	} 
}

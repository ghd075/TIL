package com.edu.emp;

import java.sql.*;
import java.util.*;
import com.edu.common.ConnectionManager;

public class EmpDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤 : static 필드
	static EmpDAO instance;
	public static EmpDAO getInstance() {
		if(instance == null)
			instance = new EmpDAO();
		return instance;
	}
	
	//등록
	public int insert(EmpDTO dto) {
		int r = 0;
		try {
			//1. DB연결
			conn = ConnectionManager.getConnnect();
			//트랜잭션 처리
			conn.setAutoCommit(false);
			//2. sql구문 준비(삽입)
			String sql = "insert into employees (employee_id, last_name, email, "
					+ "hire_date, job_id) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setString(1, dto.getEmployee_id());
			pstmt.setString(2, dto.getLast_name());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getHire_date());
			pstmt.setString(5, dto.getJob_id());
			r = pstmt.executeUpdate();
			conn.commit();
			//4. 결과처리
			System.out.println(r + " 건이 등록됨");
		}catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			//5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}
	//수정
	public int update(EmpDTO dto) {
		int r = 0;
		
		try {
			//1. DB연결
			conn = ConnectionManager.getConnnect();
			//2. sql구문 준비(수정)
			String sql = "update employees set last_name = ?, email = ?, "
					+ "hire_date = ?, job_id = ? where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setString(1, dto.getLast_name());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getHire_date());
			pstmt.setString(4, dto.getJob_id());
			pstmt.setString(5, dto.getEmployee_id());
			r = pstmt.executeUpdate();
			//4. 결과처리
			System.out.println(r + " 건이 수정됨");
		}catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
		}finally {
			//5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}
	//삭제
	public int delete(EmpDTO dto) {
		int r = 0;
		
		try {
			//1. DB연결
			conn = ConnectionManager.getConnnect();
			//2. sql구문 준비(삭제)
			String sql = "delete employees where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setString(1, dto.getEmployee_id());
			r = pstmt.executeUpdate();
			//4. 결과처리
			System.out.println(r + " 건이 삭제됨");
		}catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
		}finally {
			//5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}
	//단건조회
	public EmpDTO selectOne(EmpDTO dto) {
		EmpDTO emp = new EmpDTO();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from employees where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployee_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				emp.setEmployee_id(rs.getString("employee_id"));
				emp.setFirst_name(rs.getString("first_name"));
				emp.setLast_name(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone_number(rs.getString("phone_number"));
				emp.setHire_date(rs.getString("hire_date"));
				emp.setJob_id(rs.getString("job_id"));
				emp.setSalary(rs.getString("salary"));
				emp.setCommission_pct(rs.getString("commission_pct"));
				emp.setManager_id(rs.getString("manager_id"));
				emp.setDepartment_id(rs.getString("department_id"));	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//연결해제
			ConnectionManager.close(conn);
		}
		return emp;
	}
	
	//전체조회
	public List<EmpDTO> selectAll(){
		List<EmpDTO> datas = new ArrayList<EmpDTO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from employees order by employee_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpDTO emp = new EmpDTO();
				emp.setEmployee_id(rs.getString("employee_id"));
				emp.setFirst_name(rs.getString("first_name"));
				emp.setLast_name(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone_number(rs.getString("phone_number"));
				emp.setHire_date(rs.getString("hire_date"));
				emp.setJob_id(rs.getString("job_id"));
				emp.setSalary(rs.getString("salary"));
				emp.setCommission_pct(rs.getString("commission_pct"));
				emp.setManager_id(rs.getString("manager_id"));
				emp.setDepartment_id(rs.getString("department_id"));
				datas.add(emp); //dto를 리스트에 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//연결해제
			ConnectionManager.close(conn);
		}
		return datas; 
	}
}

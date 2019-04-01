package emp;

import java.io.*;
import java.sql.*;
import java.util.*;

public class EmpDAO implements Serializable {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 싱글톤 : static 필드
	static EmpDAO instance;

	public static EmpDAO getInstance() {
		if (instance == null)
			instance = new EmpDAO();
		return instance;
	}

	// 등록
	public int insert(EmpDTO dto) {
		int r = 0;
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 트랜잭션 처리
			conn.setAutoCommit(false);
			// 2. sql구문 준비(삽입)
			String sql = "insert into employees (employee_id, last_name, email, "
					+ "hire_date, job_id) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// 3. 실행
			pstmt.setString(1, dto.getEmployee_id());
			pstmt.setString(2, dto.getLast_name());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getHire_date());
			pstmt.setString(5, dto.getJob_id());
			r = pstmt.executeUpdate();
			conn.commit();
			// 4. 결과처리
			System.out.println(r + " 건이 등록됨");
		} catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}

	// 수정
	public int update(EmpDTO dto) {
		int r = 0;

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. sql구문 준비(수정)
			String sql = "update employees set last_name = ?, email = ?, "
					+ "hire_date = ?, job_id = ? where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			// 3. 실행
			pstmt.setString(1, dto.getLast_name());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getHire_date());
			pstmt.setString(4, dto.getJob_id());
			pstmt.setString(5, dto.getEmployee_id());
			r = pstmt.executeUpdate();
			// 4. 결과처리
			System.out.println(r + " 건이 수정됨");
		} catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}

	// 삭제
	public int delete(EmpDTO dto) {
		int r = 0;

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. sql구문 준비(삭제)
			String sql = "delete employees where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			// 3. 실행
			pstmt.setString(1, dto.getEmployee_id());
			r = pstmt.executeUpdate();
			// 4. 결과처리
			System.out.println(r + " 건이 삭제됨");
		} catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}

	// 부서별 급여합계 부서번호, 부서명, 급여합계 List<Map>
	public List<Map<String, Object>> selectDeptSal() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select a.department_id, department_name, sum(salary) salary, count(*) cnt, avg(salary) avg "
					+ "from departments a, employees b " + "where a.department_id = b.department_id "
					+ "group by a.department_id, department_name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("department_id", rs.getString("department_id"));
				map.put("department_name", rs.getString("department_name"));
				map.put("salary", rs.getString("salary"));
				map.put("cnt", rs.getString("cnt"));
				map.put("avg", rs.getString("avg"));
				list.add(map);
			}
		} catch (SQLException e) {
			System.out.println("조회실패");
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}

		return list;
	}

	// 단건조회
	public EmpDTO selectOne(EmpDTO dto) {
		EmpDTO emp = new EmpDTO();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from employees where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployee_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 연결해제
			ConnectionManager.close(conn);
		}
		return emp;
	}

	// 전체조회
	public List<EmpDTO> selectAll() {
		List<EmpDTO> datas = new ArrayList<EmpDTO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from employees order by employee_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
				datas.add(emp); // dto를 리스트에 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 연결해제
			ConnectionManager.close(conn);
		}
		return datas;
	}

	//전체 건수 조회
	public int count() {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select count(*) from employees";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			ConnectionManager.close(conn);
		}
		return cnt;
	}

	// 검색조회
	public List<EmpDTO> selectPage(int first, int last) {
		List<EmpDTO> datas = new ArrayList<EmpDTO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from( select rownum rn, a.* from( "
					+ " select * from employees order by employee_id " + ") a ) b where rn between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
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
				datas.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return datas;
	}
	//부서별 사원 수 조회
	public List<Map<String, Object>> selectDeptEmp() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select d.department_name, count(*) cnt " + 
					"from employees e, departments d " + 
					"where e.department_id = d.department_id " + 
					"group by d.department_name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("department_name", rs.getString("department_name"));
				map.put("cnt", rs.getString("cnt"));
				list.add(map);
			}
		} catch (SQLException e) {
			System.out.println("조회실패");
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return list;
	}
}

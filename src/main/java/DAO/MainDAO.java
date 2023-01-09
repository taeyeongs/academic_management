package DAO;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Classroom;
import DTO.Curriculum;
import DTO.Login;
import DTO.Professor;
import DTO.Staff;
import DTO.Student;
import DTO.Subject;

public class MainDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private final static String mkey = "풀수없는암호화academic~~!";
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public Connection open() throws Exception {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"academic","academic1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void login(HttpServletRequest request, HttpSession session) throws Exception {
		
		conn = open();
		String id = request.getParameter("id");
		String pw = encodeSha256(request.getParameter("pw"));
		
		System.out.println("pw : " + pw);
		
		String sql = "SELECT * FROM login WHERE login_id = ? AND login_pw = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		rs = ps.executeQuery();
		
//		System.out.println("rs.next()" + rs.next());
		if (!rs.next()) {
			System.out.println("rs.next() : false");
//			return "redirect:/index";
		} else {
//			HttpSession session = request.getSession();
			System.out.println("rs.next() : true");
			session.setAttribute("id", id);
			
			String ids = (String) session.getAttribute("id"); 
		    System.out.println("ids : " + ids);
		    
//			session.invalidate();//세션초기화

		}
	}
	
	
	
	//sha256 복호화
	public static String encodeSha256(String source) {
		String result = "";
		
		byte[] a = source.getBytes(); // 소스를 바이트로 변경
		byte[] salt = mkey.getBytes();
		byte[] bytes = new byte[a.length + salt.length];
		

        System.arraycopy(a, 0, bytes, 0, a.length);
        System.arraycopy(salt, 0, bytes, a.length, salt.length);
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
            
            byte[] byteData = md.digest();
            
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
            }
            
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
	}
	
	//
	public int loginExec( Connection conn, Login l, String t) throws Exception {
//		conn = open();
		
		ps = conn.prepareStatement("INSERT INTO login(login_id, login_pw, login_type, status) VALUES(?, ?, ?, 'n')");
		ps.setString(1, l.getId());
		ps.setString(2, encodeSha256(l.getPw()));
		ps.setString(3, t);
		int log_rs = ps.executeUpdate();
		return log_rs;
	}
	
	
	//학생 목록
	public ArrayList<Student> studentList() throws Exception {
		conn = open();

		ArrayList<Student> list = new ArrayList<>();
		String sql ="SELECT student_no, student_name, student_class, student_year, student_birth, student_phone FROM student";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		System.out.println("studentList : ") ;
//		try(conn; ps; rs;){
			while(rs.next()) {
				Student s = new Student();
				s.setStudentNo(rs.getInt(1));
				s.setStudentName(rs.getString(2));
				s.setStudentClass(rs.getString(3));
				s.setStudentYear(rs.getString(4));
				s.setStudentBirth(rs.getString(5));
				s.setStudentPhone(rs.getString(6));
				System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
				list.add(s);
			}
//		}
		conn.close();
		ps.close();
		rs.close();
		
		return list;
	}
	
	//학생 상세
	public Student studentDetail(int studentNo) throws Exception {
		conn = open();

//		ArrayList<Student> list = new ArrayList<>();
		String sql ="SELECT student_no, student_name, student_class, student_year, student_birth, student_phone FROM student WHERE student_no = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, studentNo);
		rs = ps.executeQuery();
		
		System.out.println("studentList : ") ;

		rs.next();
		
		Student s = new Student();
		s.setStudentNo(rs.getInt(1));
		s.setStudentName(rs.getString(2));
		s.setStudentClass(rs.getString(3));
		s.setStudentYear(rs.getString(4));
		s.setStudentBirth(rs.getString(5));
		s.setStudentPhone(rs.getString(6));

		conn.close();
		ps.close();
		rs.close();
		
		return s;
	}
	
	//학생 등록
	public void studentInsert(Student s, Login l){
		try {
			conn = open();
			conn.setAutoCommit(false);
			int log_rs = this.loginExec(conn, l, "s");
//			ps = conn.prepareStatement("insert into login(login_id, login_pw, login_type, status) values(?, ?, ?, 'n')");
//			ps.setString(1, l.getId());
//			ps.setString(2, encodeSha256(l.getPw()));
//			ps.setString(3, "s");
//			int log_rs = ps.executeUpdate();
//		
			ps = conn.prepareStatement("SELECT NVL(MAX(student_no),0)+1 FROM student");
			rs = ps.executeQuery();
			rs.next();
			int studentNo = rs.getInt(1);
			
			String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, studentNo);
			ps.setString(2, s.getStudentName());
			ps.setString(3, s.getStudentClass());
			ps.setString(4, s.getStudentYear());
			ps.setString(5, s.getStudentBirth());
			ps.setString(6, s.getStudentPhone());
			ps.executeUpdate();
			System.out.println(log_rs +":"+studentNo);
			
			conn.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	
	
	//교수 목록
	public ArrayList<Professor> professorList() throws Exception {
		conn = open();

		ArrayList<Professor> list = new ArrayList<>();
		String sql ="SELECT professor_no, professor_name, professor_birth, professor_history FROM professor";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Professor p = new Professor();
			p.setProfessorNo(rs.getInt(1));
			p.setProfessorName(rs.getString(2));
			p.setProfessorBirth(rs.getString(3));
			p.setProfessorHistory(rs.getString(4));
			list.add(p);
		}
		
		return list;
	}
	
	
	//교수 등록
	public void professorInsert(Professor s, Login l) throws Exception {
		try {
			conn = open();
	
			int log_rs = this.loginExec(conn, l, "p");
			
			ps = conn.prepareStatement("SELECT NVL(MAX(professor_no),0) + 1 FROM professor");
			rs = ps.executeQuery();
			rs.next();
			int professorNo = rs.getInt(1);
			
			String sql = "INSERT INTO professor(professor_no, professor_name, professor_birth, professor_history) VALUES(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, professorNo);
			ps.setString(2, s.getProfessorName());
			ps.setString(3, s.getProfessorBirth());
			ps.setString(4, s.getProfessorHistory());
			int result = ps.executeUpdate();
			conn.commit();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	
	
	//직원 목록
	public ArrayList<Staff> staffList() throws Exception {
		conn = open();

		ArrayList<Staff> list = new ArrayList<>();
		String sql ="SELECT staff_no, staff_name, staff_rank FROM staff";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		System.out.println("studentList : ") ;

		while(rs.next()) {
			Staff s = new Staff();
			s.setStaffNo(rs.getInt(1));
			s.setStaffName(rs.getString(2));
			s.setStaffRank(rs.getString(3));
			System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
			list.add(s);
		}
		
		conn.close();
		ps.close();
		rs.close();
		
		return list;
	}
		
	//직원 상세
	public Staff staffDetail(int staffNo) throws Exception {
		conn = open();

//			ArrayList<Student> list = new ArrayList<>();
		String sql ="SELECT staff_no, staff_name, staff_rank FROM student WHERE student_no = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, staffNo);
		rs = ps.executeQuery();
		
		System.out.println("staff : ") ;

		rs.next();
		
		Staff s = new Staff();
		s.setStaffNo(rs.getInt(1));
		s.setStaffName(rs.getString(2));
		s.setStaffRank(rs.getString(3));

		conn.close();
		ps.close();
		rs.close();
		
		return s;
	}
	
	//직원 등록
	public void staffInsert(Staff s, Login l){
		try {
			conn = open();
			conn.setAutoCommit(false);
			int log_rs = this.loginExec(conn, l, "s");
//				ps = conn.prepareStatement("insert into login(login_id, login_pw, login_type, status) values(?, ?, ?, 'n')");
//				ps.setString(1, l.getId());
//				ps.setString(2, encodeSha256(l.getPw()));
//				ps.setString(3, "s");
//				int log_rs = ps.executeUpdate();
//			
			ps = conn.prepareStatement("SELECT NVL(MAX(staff_no),0)+1 FROM staff");
			rs = ps.executeQuery();
			rs.next();
			int staffNo = rs.getInt(1);
			
			String sql = "INSERT INTO staff VALUES(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, staffNo);
			ps.setString(2, s.getStaffName());
			ps.setString(3, s.getStaffRank());
			ps.executeUpdate();
			System.out.println(log_rs +":"+staffNo);
			
			conn.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	

	//////////////////////////////////////////////////////////////////////////


	//과목목록
	public ArrayList<Subject> subjectList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Subject> list = new ArrayList<>();
		try {
			conn = open();
			String sql = "SELECT subject_no, subject_name, subject_state FROM subject";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Subject s = new Subject();
				s.setSubjectNo(rs.getInt(1));
				s.setSubjectName(rs.getString(2));
				s.setSubjectState(rs.getString(3));
				list.add(s);
			}
			conn.close();
			ps.close();
			rs.close();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		for(Subject s : list) {
			System.out.println("subjectList: " + s.getSubjectNo() + ":" + s.getSubjectName() + ":" + s.getSubjectState()); 
			
		}
		return list;
	}
	
	//과목상세
	public Subject subjectDetail(int subjectNo) {
		Subject subject = new Subject();
		try {
			conn = open();
			String sql = "SELECT subject_no, subject_name, subject_state FROM subject WHERE subject_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, subjectNo);
			rs = ps.executeQuery();
			rs.next();
			subject.setSubjectNo(rs.getInt(1));
			subject.setSubjectName(rs.getString(2));
			subject.setSubjectState(rs.getString(3));
			
			System.out.println("dao subjectDetail :" + rs.getInt(1) +":"+rs.getString(2)+":"+rs.getString(3));
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subject;
	}
	
	//과목 수정
	public void subjectUpdate(Subject s) {
		try {
			conn = open();
			String sql = "UPDATE subject SET subject_name= ?, subject_state=? WHERE subject_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getSubjectName());
			ps.setString(2, s.getSubjectState());
			ps.setInt(3, s.getSubjectNo());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//과목등록
	public void subjectInsert(Subject s) {
		try {
			conn = open();
			ps = conn.prepareStatement("SELECT NVL(MAX(subject_no),0) + 1 FROM subject");
			rs = ps.executeQuery();
			rs.next();
			int subjectNo = rs.getInt(1);
			String sql = "INSERT INTO subject(subject_no, subject_name) VALUES(?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, subjectNo);
			ps.setString(2, s.getSubjectName());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//////////////////////////////////////////////////////////////////////////


	
	//강의실목록
	public ArrayList<Classroom> classroomList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Classroom> list = new ArrayList<>();
		try {
			conn = open();
			String sql = "SELECT classroom_no, classroom_name, classroom_personnel FROM classroom";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Classroom s = new Classroom();
				s.setClassroomNo(rs.getInt(1));
				s.setClassroomName(rs.getString(2));
				s.setClassroomPersonnel(rs.getInt(3));
				System.out.println("classroomList: " + rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3));
				list.add(s);
			}
			conn.close();
			ps.close();
			rs.close();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		for(Classroom s : list) {
			System.out.println("classroomList: " + s.getClassroomNo() + ":" + s.getClassroomName() + ":" + s.getClassroomPersonnel()); 
			
		}
		return list;
	}
	
	//강의실상세
	public Classroom classroomDetail(int classroomNo) {
		Classroom classroom = new Classroom();
		try {
			conn = open();
			String sql = "SELECT classroom_no, classroom_name, classroom_personnel FROM classroom WHERE classroom_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, classroomNo);
			rs = ps.executeQuery();
			rs.next();
			classroom.setClassroomNo(rs.getInt(1));
			classroom.setClassroomName(rs.getString(2));
			classroom.setClassroomPersonnel(rs.getInt(3));
			
			System.out.println("dao subjectDetail :" + rs.getInt(1) +":"+rs.getString(2)+":"+rs.getString(3));
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classroom;
	}
	
	//강의실 수정
	public void classroomUpdate(Classroom c) {
		try {
			conn = open();
			String sql = "UPDATE classroom SET classroom_name = ?, classroom_personnel = ? WHERE classroom_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getClassroomName());
			ps.setInt(2, c.getClassroomPersonnel());
			ps.setInt(3, c.getClassroomNo());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//강의실등록
	public void classroomInsert(Classroom c) {
		try {
			conn = open();
			ps = conn.prepareStatement("SELECT NVL(MAX(classroom_no),0) + 1 FROM classroom");
			rs = ps.executeQuery();
			rs.next();
			int classroomNo = rs.getInt(1);
			String sql = "INSERT INTO classroom(classroom_no, classroom_name, classroom_personnel) VALUES(?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, classroomNo);
			ps.setString(2, c.getClassroomName());
			ps.setInt(3, c.getClassroomPersonnel());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////

	
	
	//교육목록
	public ArrayList<Curriculum> curriculumList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Curriculum> list = new ArrayList<>();
		try {
			conn = open();
			String sql = "SELECT curriculum_no, professor_no, subject_no FROM curriculum";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Curriculum c = new Curriculum();
				c.setCurriculumNo(rs.getInt(1));
				c.setProfessorNo(rs.getInt(2));
				c.setSubjectNo(rs.getInt(3));
				list.add(c);
			}
			conn.close();
			ps.close();
			rs.close();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		for(Curriculum s : list) {
			System.out.println("curriculumList: " + s.getCurriculumNo() + ":" + s.getProfessorNo() + ":" + s.getSubjectNo()); 
			
		}
		return list;
	}
	
	//교육상세
	public Curriculum curriculumDetail(int curriculumNo) {
		Curriculum curriculum = new Curriculum();
		try {
			conn = open();
			String sql = "SELECT curriculum_no, professor_no, subject_no FROM curriculum WHERE curriculum_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, curriculumNo);
			rs = ps.executeQuery();
			rs.next();
			curriculum.setCurriculumNo(rs.getInt(1));
			curriculum.setProfessorNo(rs.getInt(2));
			curriculum.setSubjectNo(rs.getInt(3));
			
			System.out.println("dao subjectDetail :" + rs.getInt(1) +":"+rs.getString(2)+":"+rs.getString(3));
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return curriculum;
	}
	
	//교육수정
	public void curriculumUpdate(Curriculum c) {
		try {
			conn = open();
			String sql = "UPDATE curriculum SET professor_no= ?, subject_no=? WHERE subject_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getProfessorNo());
			ps.setInt(2, c.getSubjectNo());
			ps.setInt(3, c.getCurriculumNo());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//교육등록
	public void curriculumInsert(Curriculum s) {
		try {
			conn = open();
			ps = conn.prepareStatement("SELECT NVL(MAX(curriculum_no),0) + 1 FROM curriculum");
			rs = ps.executeQuery();
			rs.next();
			int curriculumNo = rs.getInt(1);
			String sql = "INSERT INTO curriculum(curriculum_no, professor_no, subject_no) VALUES(?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, curriculumNo);
			ps.setInt(2, s.getProfessorNo());
			ps.setInt(2, s.getSubjectNo());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//수강신청교육목록
	public ArrayList<Curriculum> applyCurriculumList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Curriculum> list = new ArrayList<>();
		try {
			conn = open();
			String sql = "SELECT curriculum_no, professor_no, subject_no FROM curriculum";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Curriculum c = new Curriculum();
				c.setCurriculumNo(rs.getInt(1));
				c.setProfessorNo(rs.getInt(2));
				c.setSubjectNo(rs.getInt(3));
				list.add(c);
			}
			conn.close();
			ps.close();
			rs.close();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		for(Curriculum s : list) {
			System.out.println("curriculumList: " + s.getCurriculumNo() + ":" + s.getProfessorNo() + ":" + s.getSubjectNo()); 
			
		}
		return list;
	}

}

package DAO;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Login;
import DTO.Student;

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
		
		String sql = "select * from login where login_id = ? and login_pw = ?";
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
	
	
	public ArrayList<Student> studentList() throws Exception {
		conn = open();

		ArrayList<Student> list = new ArrayList<>();
		String sql ="select student_no, student_name, student_class, student_year, student_birth, student_phone from student";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Student s = new Student();
			s.setStudentNo(rs.getInt(1));
			s.setStudentName(rs.getString(2));
			s.setStudentClass(rs.getString(3));
			s.setStudentYear(rs.getString(4));
			s.setStudentBirth(rs.getString(5));
			s.setStudentPhone(rs.getString(6));
			list.add(s);
		}
		
		return list;
	}
	
	
	//학생 등록
	public void studentInsert(Student s, Login l) throws Exception {
		conn = open();
		
		ps = conn.prepareStatement("insert into login values(?, ?)");
		ps.setString(1, l.getId());
		ps.setString(2, encodeSha256(l.getPw()));
		int log_rs = ps.executeUpdate();
	
		ps = conn.prepareStatement("select max(student_no)  + 1 from student");
		rs = ps.executeQuery();
		rs.next();
		int studentNo = rs.getInt(1);
		
		String sql = "insert into student values(?, ?, ?, ?, ?, ?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, studentNo);
		ps.setString(2, s.getStudentName());
		ps.setString(2, s.getStudentClass());
		ps.setString(2, s.getStudentYear());
		ps.setString(2, s.getStudentBirth());
		ps.setString(2, s.getStudentPhone());
		int result = ps.executeUpdate();
		
		rs.absolute(studentNo);
		if (log_rs == 1 && rs != null && result == 1) { //
			conn.commit();
		} else {
			conn.rollback();
		}
	}
}

package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MainDAO;
import DTO.Login;
import DTO.Professor;
import DTO.Staff;
import DTO.Student;
import DTO.Subject;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MainDAO main;
	private ServletContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		main = new MainDAO();
		ctx = getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getContextPath();
		String command = request.getServletPath();
		String site = "";
		
		MainDAO main = new MainDAO();
//		HttpSession session = null;
		
		 // 세션생성
	    HttpSession session = request.getSession();
	   // HttpSession session1 = request.getSession(true);
	   // HttpSession session2 = request.getSession(false);
	    
	 // 새로운세션 생성여부
	    boolean sNew = session.isNew();
	    System.out.println("sNew : " + sNew);
	    // 세션 유지시간 설정(초단위로)
	    // 60*60 = 1시간
	    int sTime = 60*60; 
	    session.setMaxInactiveInterval(sTime);

	    // 무한대설정
	    session.setMaxInactiveInterval(-1);

	    // 세션Id 값 가져오기
	    String sId = session.getId();
	    System.out.println("sId : " + sId);
//	    String hello = "Hello session!!";

	    // 세션에 값 저장하기
//	    session.setAttribute("session_hello", hello);
//	    session.invalidate();
	    // 세션에서 값 가져오기
	    String login = (String) session.getAttribute("id"); 
	    System.out.println("word : " + login);

	    switch(command) {
		    case "/":
	    	case "/login":
	    	case "/index":
				site = "login.jsp";break;
			case "/login_check":
				System.out.println("login_check");
	//				session = request.getSession();
				try { 
					site = login(request, session);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				break;
			case "/logout_check":
				session.invalidate();
				site = "redirect:/index";
				break;	
		}
	    if(login != null) {
	    	System.out.println("controller : / - session");
			switch(command) {
				case "/":
				case "/index":
				case "/dashboard":
	//				session = request.getSession(false);
					site = "dashboard.jsp";
					break;
				
				case "/student":
				case "/student_list":
					site = studentList(request, response);
					break;
				case "/student_add":
					site = "student_add.jsp";
					break;
				case "/student_insert":
					site = studentInsert(request, response);
					break;
				case "/student_detail":
					site = studentDetail(request, response);
					break;
					
					
				case "/professor_list":
					site = "professor_list.jsp";
					break;
				case "/professor_add":
					site = "professor_add.jsp";
					break;
				case "/professor_insert":
					site = "dashboard.jsp";
					break;
					
					
				case "/staff_list":
					site = "staff_list.jsp";
					break;
				case "/staff_add":
					site = "staff_add.jsp";
					break;
				case "/staff_insert":
					site = "dashboard.jsp";
					break;
					
					
				case "/subject_list":
					site = subjectList(request, response);
					break;
				case "/subject_add":
					site = "subject_add.jsp";
					break;
				case "/subject_insert":
					site = subjectInsert(request, response);
					break;
					
				
				case "/classroom_list":
					site = "classroom_list.jsp";
					break;
				case "/classroom_add":
					site = "classroom_add.jsp";
					break;
				case "/classroom_insert":
					site = "dashboard.jsp";
					break;
					
					
				case "/curriculum_list":
					site = "curriculum_list.jsp";
					break;
				case "/curriculum_add":
					site = "curriculum_add.jsp";
					break;
				case "/curriculum_insert":
					site = "dashboard.jsp";
					break;
					
					
				case "/logout_check":
					session.invalidate();
					site = "redirect:/index";
					break;
			}
	    } else {
	    	
	    	System.out.println("controller : / - nosession");
	    }
		
		if	(site.startsWith("redirect:/")) {
			System.out.println("redirect : " + site);
			String rview = site.substring("redirect:/".length());
			System.out.println(rview);
			response.sendRedirect(rview);
		} else {
			System.out.println("forward : " + site);
			ctx.getRequestDispatcher("/" + site).forward(request, response);
		}
	}
	
	public String login(HttpServletRequest request, HttpSession session) {
		try {
			main.login(request, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ctx.log("오류");
			request.setAttribute("errorMsg", "login 오류");
		}
		return "redirect:/dashboard";
	}

	
	//학생 목록
	public String studentList(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Student> list = main.studentList();
			System.out.println(list.toString());
			for(Student c : list) {
				System.out.println(c.getStudentNo() +":"+c.getStudentName());
			}
			request.setAttribute("student_list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student_list.jsp";
	}
	
	//학생 상세
	public String studentDetail(HttpServletRequest request, HttpServletResponse response) {
		try {
			Student student = main.studentDetail(Integer.parseInt(request.getParameter("studentNo")));
			request.setAttribute("student",student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student_detail.jsp";
	}
	
	//학생 등록
	public String studentInsert(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Login l = new Login();
			l.setId(request.getParameter("id"));
			l.setPw(request.getParameter("pw"));
			
			Student s = new Student();
//		    SimpleDateFormat format = new SimpleDateFormat("yyMM");
//		    Date current =new Date();
//		    System.out.println(format.format(current));
//			s.setStudentNo();
			s.setStudentName(request.getParameter("student_name"));
			s.setStudentClass(request.getParameter("student_class"));
			s.setStudentYear(request.getParameter("student_year"));
			s.setStudentBirth(request.getParameter("student_birth"));
			s.setStudentPhone(request.getParameter("student_phone"));
			main.studentInsert(s, l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ctx.log("학생 등록 오류");
			request.setAttribute("error", "정상적으로 저장되지않았습니다.");
		}
		return "redirect:/student_list";
	}

	
	//교수 목록
	public String professorList(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Professor> list = main.professorList();
			request.setAttribute("professor_list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student_list.jsp";
	}
	
	//교수 등록
	public String professorInsert(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Login l = new Login();
			l.setId(request.getParameter("id"));
			l.setPw(request.getParameter("pw"));
			
			Student s = new Student();
//		    SimpleDateFormat format = new SimpleDateFormat("yyMM");
//		    Date current =new Date();
//		    System.out.println(format.format(current));
//			s.setStudentNo();
			s.setStudentName(request.getParameter("student_name"));
			s.setStudentClass(request.getParameter("student_class"));
			s.setStudentYear(request.getParameter("student_year"));
			s.setStudentBirth(request.getParameter("student_birth"));
			s.setStudentPhone(request.getParameter("student_phone"));
			main.studentInsert(s, l);
			return "redirect:/student_list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ctx.log("학생 등록 오류");
			request.setAttribute("error", "정상적으로 저장되지않았습니다.");
			return "student_add";
		}
	}
	
	
	////////--------------------------------------------------------------------
	
	
	//직원목록
	public String staffList(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Staff> list = main.staffList();
			System.out.println(list.toString());
			for(Staff s : list) {
				System.out.println(s.getStaffNo() +":"+s.getStaffName());
			}
			request.setAttribute("student_list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student_list.jsp";
	}
	//직원상세
	public String staff(HttpServletRequest request, HttpServletResponse response) {
		try {
			Staff student = main.staffDetail(Integer.parseInt(request.getParameter("studentNo")));
			request.setAttribute("student",student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student_detail.jsp";
	}
	//직원등록
	public String staffInsert(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Login l = new Login();
			l.setId(request.getParameter("id"));
			l.setPw(request.getParameter("pw"));
			
			Staff s = new Staff();
//		    SimpleDateFormat format = new SimpleDateFormat("yyMM");
//		    Date current =new Date();
//		    System.out.println(format.format(current));
//			s.setStudentNo();
			s.setStaffName(request.getParameter("staff_name"));
			s.setStaffRank(request.getParameter("staff_rank"));
			main.staffInsert(s, l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ctx.log("학생 등록 오류");
			request.setAttribute("error", "정상적으로 저장되지않았습니다.");
		}
		return "redirect:/student_list";
	}
	
	
	
////////--------------------------------------------------------------------
	
	
	
	//교육목록
	//교육상세
	//교육등록
	
	
	
////////--------------------------------------------------------------------
	
	
	
	//과목목록
	public String subjectList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Subject> list = main.subjectList(request, response); 
		request.setAttribute("subject_list", list);
		return "subject_list";
	}
	//과목상세
	//과목등록
	public String subjectInsert(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Subject s = new Subject();
			s.setSubjectName(request.getParameter("subject_name"));
			main.subjectInsert(s);
		
			return"redirect:/subject_list";
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			ctx.log("과목등록오류");
			request.setAttribute("error", "과목등록이 정상적으로 저장되지않았습니다.");
			return"redirect:/subject_add";
		}
	}
	
	
////////--------------------------------------------------------------------
	
	
	
	//강의실목록
	//강의실상세
	//강의실등록
}

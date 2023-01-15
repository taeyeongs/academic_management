package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import DAO.MainDAO;
import DTO.Classroom;
import DTO.Curriculum;
import DTO.Login;
import DTO.Professor;
import DTO.ReservationRoom;
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
//	    session.setMaxInactiveInterval(-1);

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
				site = "redirect:/";
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
					
					
				case "/professor":
				case "/professor_list":
					site = professorList(request, response);
					break;
				case "/professor_add":
					site = professorAdd(request, response);
//					site = "professor_add.jsp";
					break;
				case "/professor_insert":
					site = professorInsert(request, response);
					break;
					
					
				case "/staff":
				case "/staff_list":
					site = staffList(request, response);
					break;
				case "/staff_add":
					site = "staff_add.jsp";
					break;
				case "/staff_insert":
					site = staffInsert(request, response);
					break;
					
					
				case "/subject":
				case "/subject_list":
					site = subjectList(request, response);
					break;
				case "/subject_add":
					site = "subject_add.jsp";
					break;
				case "/subject_insert":
					site = subjectInsert(request, response);
					break;
				case "/subject_detail":
					site = subjectDetail(request, response);
					break;
				case "/subject_update":
					site = subjectUpdate(request, response);
					break;
					
					
				case "/classroom":
				case "/classroom_list":
					site = classroomList(request, response);
					break;
				case "/classroom_add":
					site = "classroom_add.jsp";
					break;
				case "/classroom_insert":
					site = classroomInsert(request, response);
					break;
				case "/classroom_detail":
					site = classroomDetail(request, response);
					break;
				case "/classroom_update":
					site = classroomUpdate(request, response);
					break;
					
					
				case "/curriculum":
				case "/curriculum_list":
					site = curriculumList(request, response);
//					site = "curriculum_list.jsp";
					break;
				case "/curriculum_add":
					site = curriculumAdd(request, response);
//					site = "curriculum_add.jsp";
					break;
				case "/curriculum_insert":
					site = curriculumInsert(request, response);
//					site = "dashboard.jsp";
					break;
					
					
				case "/logout_check":
					session.invalidate();
					site = "redirect:/";
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

	
	
	//////////////////////////////////////////////////////////////////
	
	
	
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
	

	
	//////////////////////////////////////////////////////////////////
	
	
	
	//교수 목록
	public String professorList(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Professor> list = main.professorList();
			request.setAttribute("professor_list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "professor_list.jsp";
	}
	
	//교수등록페이
	public String professorAdd(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Subject> subjectList = main.subjectList(); 
		request.setAttribute("subject_list", subjectList);
		return "professor_add.jsp";
	}
	//교수 등록
	public String professorInsert(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Login l = new Login();
			l.setId(request.getParameter("id"));
			l.setPw(request.getParameter("pw"));
			
			Professor p = new Professor();
//		    SimpleDateFormat format = new SimpleDateFormat("yyMM");
//		    Date current =new Date();
//		    System.out.println(format.format(current));
//			s.setStudentNo();
			p.setProfessorName(request.getParameter("professor_name"));
			p.setProfessorBirth(request.getParameter("professor_birth"));
			p.setProfessorHistory(request.getParameter("professor_history"));
			p.setSubjectNo(Integer.parseInt(request.getParameter("subject_no")));
			main.professorInsert(p, l);
			return "redirect:/professor_list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ctx.log("교수 등록 오류");
			request.setAttribute("error", "정상적으로 저장되지않았습니다.");
			return "professor_add";
		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////	
	
	
	
	//직원목록
	public String staffList(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Staff> list = main.staffList();
			System.out.println(list.toString());
			for(Staff s : list) {
				System.out.println(s.getStaffNo() +":"+s.getStaffName());
			}
			request.setAttribute("staff_list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "staff_list.jsp";
	}
	//직원상세
	public String staff(HttpServletRequest request, HttpServletResponse response) {
		try {
			Staff staff = main.staffDetail(Integer.parseInt(request.getParameter("studentNo")));
			request.setAttribute("staff", staff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "staff_detail.jsp";
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
		return "redirect:/staff_list";
	}
	
	
	
	//////////////////////////////////////////////////////////////////
	
	
	
	//과목목록
	public String subjectList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Subject> list = main.subjectAllList(request, response); 
		request.setAttribute("subject_list", list);
		return "subject_list.jsp";
	}
	
	//과목상세
	public String subjectDetail(HttpServletRequest request, HttpServletResponse response) {
		int subjectNo = Integer.parseInt(request.getParameter("subjectNo"));
		Subject subject = main.subjectDetail(subjectNo); 
		request.setAttribute("subject", subject);
		return "subject_modify.jsp";
	}
	
	//과목 수정
	public String subjectUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Subject s = new Subject();
			s.setSubjectNo(Integer.parseInt(request.getParameter("subject_no")));
			s.setSubjectName(request.getParameter("subject_name"));
			s.setSubjectState(request.getParameter("subject_state"));
			
			System.out.println("controller_subjectUpdate");
			main.subjectUpdate(s);	
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			ctx.log("과목등록오류");
			request.setAttribute("error", "과목등록이 정상적으로 저장되지않았습니다.");
//			return"redirect:/subject_add";
		}
		return "redirect:/subject_list";
	}
	//과목등록
	public String subjectInsert(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Subject s = new Subject();
			s.setSubjectName(request.getParameter("subject_name"));
			
			System.out.println("controller_subjectInsert");
			main.subjectInsert(s);	
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			ctx.log("과목등록오류");
			request.setAttribute("error", "과목등록이 정상적으로 저장되지않았습니다.");
//			return"redirect:/subject_add";
		}
		return "redirect:/subject_list";
	}
	
	
	
	//////////////////////////////////////////////////////////////////
	
	
	
	//강의실목록
	public String classroomList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Classroom> list = main.classroomList(); 
		request.setAttribute("classroom_list", list);
		return "classroom_list.jsp";
	}
	
	//강의실상세
	public String classroomDetail(HttpServletRequest request, HttpServletResponse response) {
		int subjectNo = Integer.parseInt(request.getParameter("classroomNo"));
		Classroom classroom = main.classroomDetail(subjectNo); 
		request.setAttribute("classroom", classroom);
		return "classroom_modify.jsp";
	}
	
	//강의실수정
	public String classroomUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Classroom c = new Classroom();
			c.setClassroomNo(Integer.parseInt(request.getParameter("classroom_no")));
			c.setClassroomName(request.getParameter("classroom_name"));
			c.setClassroomPersonnel(Integer.parseInt(request.getParameter("classroom_personnel")));
			
			System.out.println("controller_classroomUpdate");
			main.classroomUpdate(c);	
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			ctx.log("강의실수정오류");
			request.setAttribute("error", "강의실수정이 정상적으로 저장되지않았습니다.");
//			return"redirect:/subject_add";
		}
		return "redirect:/classroom_list";
	}
	
	//강의실등록
	public String classroomInsert(HttpServletRequest request, HttpServletResponse response) {
		try {
			Classroom s = new Classroom();
			s.setClassroomName(request.getParameter("classroom_name"));
			s.setClassroomPersonnel(Integer.parseInt(request.getParameter("classroom_personnel")));
			
			System.out.println("controller_classroomInsert");
			main.classroomInsert(s);	
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			ctx.log("강의실등록오류");
			request.setAttribute("error", "강의실등록이 정상적으로 저장되지않았습니다.");
//			return"redirect:/subject_add";
		}
		return "redirect:/classroom_list";
	}
	


	//////////////////////////////////////////////////////////////////


	
	//교육목록
	public String curriculumList(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Curriculum> list = main.curriculumList(request, response);
			System.out.println(list.toString());
			for(Curriculum c : list) {
				System.out.println(c.getCurriculumNo() +":"+c.getProfessorNo());
			}
			request.setAttribute("curriculum_list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "curriculum_list.jsp";
	}
	
	//교육상세
	public String curriculumDetail(HttpServletRequest request, HttpServletResponse response) {
		try {
			Curriculum curriculum = main.curriculumDetail(Integer.parseInt(request.getParameter("curriculumNo")));
			request.setAttribute("curriculum",curriculum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "curriculum_detail.jsp";
	}
	
	//교육등록페이지
	public String curriculumAdd(HttpServletRequest request, HttpServletResponse response) {
		try {
			
		    HttpSession session = request.getSession();
			   // HttpSession session1 = request.getSession(true);
			   // HttpSession session2 = request.getSession(false);
			    
			 // 새로운세션 생성여부
			boolean sNew = session.isNew();
			    
			
			
			
			ArrayList<Professor> professorList = new ArrayList<>();
			ArrayList<Subject> subjectList = new ArrayList<>();
			ArrayList<Classroom> classroomList = new ArrayList<>();
			
			String loginType = (String)session.getAttribute("login_type");
			if(loginType.equals("P")) {
				int loginTypeNo = (Integer)session.getAttribute("login_type_no");
				Professor loginProfessor = main.professorDetail(loginTypeNo);
				request.setAttribute("login_professor", loginProfessor);
			}
			
//			System.out.println("controller curriculumAdd - curriculumDetail before  -- curriculumNo:" + Integer.parseInt(request.getParameter("curriculumNo")));
//			Curriculum curriculum = main.curriculumDetail(Integer.parseInt(request.getParameter("curriculumNo")));
//			request.setAttribute("curriculum",curriculum);
			
			classroomList = main.classroomList();
			request.setAttribute("classroom_list",classroomList);
			
			System.out.println("controller curriculumAdd - professorList before");
			professorList = main.professorList();
			request.setAttribute("professor_list", professorList);
			
			System.out.println("controller curriculumAdd - subjectList before");
			subjectList = main.subjectList();
			request.setAttribute("subject_list", subjectList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "curriculum_add.jsp";
	}
	
	//교육등록
	public String curriculumInsert(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			Curriculum s = new Curriculum();
		//    SimpleDateFormat format = new SimpleDateFormat("yyMM");
		//    Date current =new Date();
		//    System.out.println(format.format(current));
		//	s.setStudentNo();
			s.setProfessorNo(Integer.parseInt(request.getParameter("professor_no")));
			s.setSubjectNo(Integer.parseInt(request.getParameter("subject_no")));
			
			String classStart = request.getParameter("class_start");
			String classEnd = request.getParameter("class_end");
			String classStartTime = request.getParameter("class_start_time");
			String classEndTime = request.getParameter("class_end_time");
			int classroomNo = Integer.parseInt(request.getParameter("classroom_no"));
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat mdData = new SimpleDateFormat("MM-dd");
			
			Date convertedStartDate = df.parse(classStart);
			Date convertedEndDate = df.parse(classEnd);
//			ReservationRoom r =  new ReservationRoom();//강의실 사용등록
			
			Calendar start = Calendar.getInstance();
			start.setTime(convertedStartDate);
			Calendar end = Calendar.getInstance();
			end.setTime(convertedEndDate);
			
			int curriculumNo = (int) main.curriculumInsert(s);
			System.out.println("curriculumNo : " + curriculumNo);
			if ( curriculumNo == 0) {
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				out.print("<script>alert('curriculumNo없음');history.back();</script></body>");
				out.close();
				return "";
			}
			ArrayList<ReservationRoom> params = new ArrayList<>();
			for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
				ReservationRoom ss = new ReservationRoom();
				
				Calendar dt = Calendar.getInstance();
				dt.setTime(date);
				String weekText = dt.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
				String weekTextKR = dt.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.KOREAN);
				String nationHoliday= mdData.format(date);
				if (weekText.equals("Saturday") 
					|| weekText.equals("Sunday") 
					|| nationHoliday.equals("3-1")
					|| nationHoliday.equals("7-17") 
					|| nationHoliday.equals("8-5") 
					|| nationHoliday.equals("10-3") 
					|| nationHoliday.equals("10-9")
					|| nationHoliday.equals("12-25") 
					) {
					continue;
				}
				
				ss.setClassDate(df.format(date));
				ss.setClassWeek(weekTextKR);
				ss.setClassStartTime(classStartTime);
				ss.setClassEndTime(classEndTime);
				ss.setClassroomNo(classroomNo);
				ss.setCurriculumNo(curriculumNo);
				ArrayList<ReservationRoom> c = main.ReservationRoomList(ss);
				
				System.out.println("date : " + date + ":" + df.format(convertedStartDate) +": weekText = " + weekText);
				if (!c.isEmpty()) {
					PrintWriter out = response.getWriter();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=UTF-8");
					out.print("<script>alert('이미시용중인 시간대가 있습니다.');history.back();</script></body>");
					out.close();
//					request.setAttribute("error", "이미 사용중입니다.");
					System.out.println("c != null" + c.toString());
					return "";
				}
				
				params.add(ss);
				
			}
			
			main.ReservationRoomInsert(params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ctx.log("교육과정 등록 오류");
			request.setAttribute("error", "정상적으로 저장되지않았습니다.");
		}
		return "redirect:/curriculum_list";
	}

	
	
	//////////////////////////////////////////////////////////////////
	
	
	
	private void SetCharacterEncodingFilter(String string) {
		// TODO Auto-generated method stub
		
	}

	//수강신청
	public String applySubjectList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Curriculum> curriculumlist = main.applyCurriculumList(request, response);
		
//		ArrayList<Curriculum> applySubjectlist = main.applySubjectList(request, response);
		request.setAttribute("curriculumList", curriculumlist);
//		request.setAttribute("applySubjectlist", applySubjectlist);
		/*
		 * 과정리스트 표시후 
		 * 
		 * */
		return "";
	}
	//점수
	//출석
	

}

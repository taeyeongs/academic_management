package DTO;

//교수
public class Professor {
	int professor_no;
	String professor_name;
	String professor_birth;
	Long professor_history;
	public int getProfessor_no() {
		return professor_no;
	}
	public void setProfessor_no(int professor_no) {
		this.professor_no = professor_no;
	}
	public String getProfessor_name() {
		return professor_name;
	}
	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}
	public String getProfessor_birth() {
		return professor_birth;
	}
	public void setProfessor_birth(String professor_birth) {
		this.professor_birth = professor_birth;
	}
	public Long getProfessor_history() {
		return professor_history;
	}
	public void setProfessor_history(Long professor_history) {
		this.professor_history = professor_history;
	}
}

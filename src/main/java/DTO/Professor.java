package DTO;

//교수
public class Professor {
	int professorNo;
	String professorName;
	String professorBirth;
	Long professorHistory;
	public int getProfessorNo() {
		return professorNo;
	}
	public void setProfessorNo(int professorNo) {
		this.professorNo = professorNo;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getProfessorBirth() {
		return professorBirth;
	}
	public void setProfessorBirth(String professorBirth) {
		this.professorBirth = professorBirth;
	}
	public Long getProfessorHistory() {
		return professorHistory;
	}
	public void setProfessorHistory(Long professorHistory) {
		this.professorHistory = professorHistory;
	}
}

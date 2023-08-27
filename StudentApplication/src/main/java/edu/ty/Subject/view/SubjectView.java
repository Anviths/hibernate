package edu.ty.Subject.view;

import edu.ty.Subject.controller.DAO;

public class SubjectView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DAO dao=new DAO();
//		dao.addSubject();
//		dao.updateSubjectNumberofDays(1001, 85);
		dao.deleteStudent(10001);
	}

}

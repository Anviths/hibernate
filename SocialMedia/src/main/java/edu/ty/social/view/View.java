package edu.ty.social.view;

import edu.ty.socialmedia.controller.DAO;

public class View {

	public static void main(String[] args) {

		DAO dao=new DAO();
//		dao.addUser();
		dao.deleteUserBySocialName();
	}

}

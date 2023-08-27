package edu.ty.author.view;

import edu.ty.author.controller.DAO;

public class DaoView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DAO dao=new DAO();
//		dao.addBook();
//		dao.updateAuthorNameByBookId(103, "shivram karanta");
//		dao.findBookByAuthorName("shivram karanta");
//		dao.totalPrice();
		dao.allBooks();
	}

}

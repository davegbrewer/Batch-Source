package com.revature.ers.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.revature.ers.jsonifiers.ParseJSON;
import com.revature.ers.reimbursements.Reimbursement;
import com.revature.ers.reimbursements.ReimbursementServices;

/**
 * Servlet implementation class CreateReimbursement
 */
public class CreateReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parse the object into JSON
		Logger log = Logger.getRootLogger();
		ReimbursementServices rs = new ReimbursementServices();
		JSONObject employee = ParseJSON.parsePost(request);
		Integer u_ID = (Integer) request.getSession(false).getAttribute("userID");
		Reimbursement reim = new Reimbursement();
		double amount = (Double) employee.get("amount");
		Integer selection = (Integer) employee.get("selection");
		System.out.println("POST");
		
		reim.setU_ID_Author(u_ID.intValue());
		reim.setR_amount(amount);
		reim.setR_description((String) employee.get("description"));
		reim.setRt_Type(selection.intValue());
		
		try {
			rs.addReimbursement(reim);
		} catch (SQLException e) {
			log.error("Unable to contact the database.");
		}		
	}
}

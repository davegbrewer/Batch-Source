package com.ers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ManagerDashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerRequests managerRequests;
    public ManagerDashServlet() {
        super();
        managerRequests = new ManagerRequests(DatabaseConnection.getDatabaseConnection());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			int pendingRequests = managerRequests.getNumberOfPendingRequests();
			int approvedRequests = managerRequests.getNumberOfApprovedRequests();
			int totalRequests = managerRequests.getTotalNumberOfRequests();
			ResponseToClient responseToClient = new ResponseToClient(pendingRequests, approvedRequests, totalRequests);
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String json = gson.toJson(responseToClient);
	        response.getWriter().write(json);
		}
		else {
			response.sendRedirect("login.html");
		}
	}

	//inner class to make JSON-ifying easier
	class ResponseToClient {
		int pending;
		int approved;
		int total;
		
		ResponseToClient(int pending, int approved, int total) {
			this.pending = pending;
			this.approved = approved;
			this.total = total;
		}
	}

}

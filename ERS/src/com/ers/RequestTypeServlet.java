package com.ers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class RequestTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestType requestType;
  
	public RequestTypeServlet() {
        super();
        requestType = new RequestType(DatabaseConnection.getDatabaseConnection());
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestTypes = requestType.getRequestTypes();
		response.getWriter().write(requestTypes);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> fileItems = null;
		String requestTypeString = "";
		String amountRequested = "";
		String description = "";
		byte[] receiptUpload = null;
		HttpSession session = request.getSession(false);
		int employeeId = (int) session.getAttribute("userid"); //get userid from session to save in DB with request
		try	{
			fileItems = upload.parseRequest(request);
	        for (FileItem item : fileItems) {
	            if (item.isFormField()) {
	            	//process all other form fields
	                String fieldName = item.getFieldName();
	                String fieldValue = item.getString();
	                
	                switch (fieldName) {
					case "amountRequested":
						amountRequested = fieldValue;
						break;
					case "description":
						description = fieldValue;
						break;
					case "requestType":
						requestTypeString = fieldValue;
						break;
					default:
						break;
					}
	            } else {
	                // Process file
	                receiptUpload = item.get();
	            }
	        }	
		} catch (FileUploadException e)	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get ID for request TYpe to store in DB
		int requestTypeId = requestType.getRequestTypeId(requestTypeString);


		//convert amount to number
		float amount = Float.parseFloat(amountRequested);
		requestType.addReimbursment(amount, description, receiptUpload, requestTypeId, employeeId);
		
		response.sendRedirect("empDash.html");
	}

}

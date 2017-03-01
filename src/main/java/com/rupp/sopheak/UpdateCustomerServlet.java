package com.rupp.sopheak;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.EmailValidator;

import com.fasterxml.jackson.databind.ObjectMapper;


import dao.CustomerDao;
import model.Customer;
import model.Message;

/**
 * Servlet implementation class Login
 */
@WebServlet("/update-customer")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Message m = new Message();
		boolean valid = EmailValidator.getInstance().isValid(request.getParameter("email"));
		if(!valid){
			m.setStatus(0);
			m.setMessage("Invalid email format");
		}
		
		if(valid){
			//System.out.println("zzz" + request.getParameter("firstname"));
			if(request.getParameter("firstname").isEmpty() || 
				request.getParameter("lastname").isEmpty() || 
				request.getParameter("phone_number").isEmpty() ||
				request.getParameter("dob").isEmpty() ){
				valid = false;
				m.setStatus(0);
				m.setMessage("Please fill all require field");
			}	
		}
		
		if(valid){
			Customer customer = new Customer();
			customer.setFirstname(request.getParameter("firstname"));
			customer.setLastname(request.getParameter("lastname"));
			customer.setGender(request.getParameter("gender"));
			customer.setEmail(request.getParameter("email"));
			customer.setAddress(request.getParameter("address"));
			customer.setPhone(request.getParameter("phone_number"));
			customer.setDobFromString(request.getParameter("dob"));
			customer.setUpdatedDate(new Date());
			int id = Integer.parseInt(request.getParameter("id"));
		
			CustomerDao c = new CustomerDao();
			if(c.update(id, customer)){
				m.setStatus(1);
				m.setMessage("Customer is updated successfully");
			}else{
				m.setStatus(0);
				m.setMessage("Updating customer error");
			}
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        mapper.writeValue(out, m);

	}
	

}

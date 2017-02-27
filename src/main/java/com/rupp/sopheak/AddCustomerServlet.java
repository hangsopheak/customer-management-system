package com.rupp.sopheak;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


import dao.CustomerDao;
import model.BootstrapTableCustomerFormatter;
import model.Customer;
import model.Message;

/**
 * Servlet implementation class Login
 */
@WebServlet("/add-customer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
		Customer customer = new Customer();
		customer.setFirstname(request.getParameter("firstname"));
		customer.setLastname(request.getParameter("lastname"));
		customer.setGender(request.getParameter("gender"));
		customer.setEmail(request.getParameter("email"));
		customer.setAddress(request.getParameter("address"));
		customer.setPhone(request.getParameter("phone_number"));

		try {
			customer.setDobFromString(request.getParameter("dob"));
			customer.setCreatedDate(new Date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Message m = new Message();
		CustomerDao c = new CustomerDao();
		if(c.insert(customer)){
			m.setStatus(1);
			m.setMessage("Customer is added successfully");
		}else{
			m.setStatus(0);
			m.setMessage("Adding customer error");
		}
		
		ObjectMapper mapper = new ObjectMapper();
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        mapper.writeValue(out, m);

	}
	

}

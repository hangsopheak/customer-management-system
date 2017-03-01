package com.rupp.sopheak;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


import dao.CustomerDao;
import model.BootstrapTableCustomerFormatter;
import model.Customer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/getCustomers")
public class GetCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 
		CustomerDao c = new CustomerDao();
		Integer offset = Integer.parseInt(request.getParameter("offset"));
		Integer limit = Integer.parseInt(request.getParameter("limit"));
		String search = request.getParameter("search");
		List<Customer> customers = c.getAll(limit, offset, search);
        try {
            ObjectMapper mapper = new ObjectMapper();
            BootstrapTableCustomerFormatter bsCustomerMapper = new BootstrapTableCustomerFormatter();
            bsCustomerMapper.setTotal(c.getFoundRows());
            bsCustomerMapper.setRows(customers);
            // Set response content type
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            mapper.writeValue(out, bsCustomerMapper);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("something is wrong with server " + e.getMessage());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

}

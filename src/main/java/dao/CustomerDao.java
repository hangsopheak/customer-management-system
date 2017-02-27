package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



import model.Customer;
import util.DBCP2DataSourceUtils;

public class CustomerDao {

	private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DBCP2DataSourceUtils.getDataSource());

	public CustomerDao() {}

	public Customer getById(Integer id) throws SQLException {
		if (id == 0) {
			return null;
		}
		System.out.println(jdbcTemplate.toString());
		Customer customer = null;
        customer = jdbcTemplate.queryForObject(
                "SELECT * FROM td_customer WHERE cus_id = ?",
                new Object[]{id},
               new CustomerMapper());
         
		return customer;
	}

	public void insert(Customer customer) {
		jdbcTemplate.update(
		        "INSERT INTO "
		        + "td_customer ("
		        + "cus_firstname, "
		        + "cus_lastname, "
		        + "cus_gender, "
		        + "cus_email_address, "
		        + "cus_DOB, "
		        + "cus_address, "
		        + "cus_phoneNumber, "
		        + "date_created ) values (?, ?, ?, ?, ?, ?, ?, ?)",
		        customer.getFirstname(), 
		        customer.getLastname(), 
		        customer.getGender(), 
		        customer.getEmail(), 
		        customer.getDob(),
		        customer.getAddress(),
		        customer.getPhone(),
		        customer.getCreatedDateToString()
		);	
	}

	public void update(final int id, Customer customer) {

	}

	
	
	public static void main(String[] args) throws Exception {
		
  
		CustomerDao c = new CustomerDao();
		Customer cc = c.getById(1);
		Customer c2 = new Customer();
		c2.setFirstname("Chea");
		c2.setLastname("An");
		c2.setCreatedDateFromString("2017-02-27 11:11:11");
		
		c.insert(c2);
	}

}

  final class CustomerMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setFirstname(rs.getString("cus_firstname"));
		customer.setLastname(rs.getString("cus_lastname"));
		customer.setGender(rs.getString("cus_gender"));
		customer.setEmail(rs.getString("cus_email_address"));
		customer.setAddress(rs.getString("cus_address"));
		customer.setPhone(rs.getString("cus_phoneNumber"));
		try {
			customer.setDobFromString(rs.getString("cus_DOB"));
			customer.setCreatedDateFromString(rs.getString("date_created"));
			customer.setUpdatedDateFromString(rs.getString("date_updated"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
}
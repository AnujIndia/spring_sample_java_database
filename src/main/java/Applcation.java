import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.pularsight.service.CustomerService;


public class Applcation {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerService service = appContext.getBean("customerService", CustomerService.class);
		System.out.println("Service Object 1 - :" +  service.getClass().getName());
		
		/*CustomerService service2 = appContext.getBean("customerService", CustomerService.class);
		System.out.println("Service Object 1 - :" +  service2);
		*/
		
		System.out.print(service.findAll().get(0).getFirstName());
		System.out.println(service.findAll().get(0).getLastName());
		
		DataSource jt =  appContext.getBean("datasource", DataSource.class);
		JdbcTemplate objT = appContext.getBean("jdbctemplete", JdbcTemplate.class);
		
		//insert
		int rows=objT.update("insert into myemp(empID, name, salary) values(10, 'Scott', 35000)");
		System.out.println("Rows inserted: " + rows);
		
		//Update
		objT.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement pst = conn.prepareStatement("insert into myemp(empID, name, salary) values(?,?,?)");
						pst.setInt(1, 11);
					pst.setString(2, "Anuj");
					pst.setDouble(3, 3000);
						return pst;
			}
		});
		
		//Read
		objT.query("select * from myemp", new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				System.out.println(rs.getInt("empID"));
				
			}
			
			
		});
		

		
	
		

	}

}

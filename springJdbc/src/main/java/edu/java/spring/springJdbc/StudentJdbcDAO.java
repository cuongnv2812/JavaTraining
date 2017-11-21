package edu.java.spring.springJdbc;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.derby.iapi.sql.dictionary.TupleDescriptor;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;

public class StudentJdbcDAO {
	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String insertQuery;
    private static Logger LOGGER=Logger.getLogger(StudentJdbcDAO.class);
    private String updateAgeByNameSQL="Update Student set age=? where name=?";
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		
	}
	public void setInsertQuery(String insertQuery) {
		this.insertQuery=insertQuery;
	}
	public void createTableIfNotExist() throws SQLException {
		DatabaseMetaData dbmd=dataSource.getConnection().getMetaData();
		ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
		if(rs.next()) {
			LOGGER.info("Table " + rs.getString("TABLE_NAME")+ " already exists !");
		}
		
		jdbcTemplate.execute("CREATE TABLE STUDENT("
				+ "ID BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1,INCREMENT BY 1),"
				+ "name VARCHAR(1000),"
				+ "age INTEGER)");
	}
	public void insert(String name,int age) {
		jdbcTemplate.update(insertQuery,name,age);
		LOGGER.info("Create record name: " + name + " age: " + age);
	}
	public int totalRecord() {
		/*return jdbcTemplate.execute(new StatementCallback<Integer>() {

			public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
				ResultSet rs=statement.executeQuery("select count(*) from student");
				return rs.next() ? rs.getInt(1):0;
			}
		});*/
		return jdbcTemplate.execute((Statement statement)->{
			ResultSet rs = statement.executeQuery("select count(*) from student");
			return rs.next() ? rs.getInt(1):0;
		});
	}
	private final static class StudentRowMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int i) throws SQLException {
			try {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				return student;
			} catch (Exception e) {
				LOGGER.error(e);
				return null;
			}
			
		}
	}
	public List<Student> loadStudent(String name){
		return jdbcTemplate.query("SELECT * FROM STUDENT WHERE NAME LIKE '%" + name +"%'", new StudentRowMapper());
	}
	public void updateAgeByName(int age,String name) {
		jdbcTemplate.update(updateAgeByNameSQL,age,name);
		LOGGER.info("Update name " + name + " Age " + age);
	}
	public int[] add(List<Student> students) {
		List<Object[]> batch= new ArrayList<Object[]>();
		students.forEach(student->batch.add(new Object[] {student.getName(),student.getAge()}));
		return jdbcTemplate.batchUpdate(insertQuery,batch);

	}
}

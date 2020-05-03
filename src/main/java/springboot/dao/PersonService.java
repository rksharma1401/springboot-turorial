/**
 * 
 */
package springboot.dao;

/**
 * @author ravikant.sharma
 * 12-Jan-2017
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import springboot.model.Person;

@Service
public class PersonService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public int addPerson(Person person){
    String sql = "INSERT INTO person(first_name, last_name, age, place) VALUES(?,?,?,?)";
    int result=1;
    try{
    	result= jdbcTemplate.update(sql, person.getFirstName(),
        person.getLastName(), person.getAge(), person.getPlace());
    }catch(org.springframework.dao.DuplicateKeyException ex){
    	result=-1;
    }
    
    return result;
    
  }

  public List<Person> getAllPerson(){
    return jdbcTemplate.query("SELECT * FROM person", new RowMapper<Person>(){

      public Person mapRow(ResultSet rs, int arg1) throws SQLException {
        Person p = new Person();
        p.setAge(rs.getInt("age"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        p.setPlace(rs.getString("place"));
        return p;
      }

    });
  }
  
  
  public List<Person> getPersonByName(String fname,String lname){
	    return jdbcTemplate.query("SELECT * FROM person where first_name='"+fname+"' and last_name='"+ lname+"'", new RowMapper<Person>(){

	      public Person mapRow(ResultSet rs, int arg1) throws SQLException {
	        Person p = new Person();
	        p.setAge(rs.getInt("age"));
	        p.setFirstName(rs.getString("first_name"));
	        p.setLastName(rs.getString("last_name"));
	        p.setPlace(rs.getString("place"));
	        return p;
	      }

	    });
	  }
  
  public int addTask(String toDoTask) {
		String sql = "INSERT INTO person(todo_task) VALUES(?)";
		int result = 1;
		if(jdbcTemplate==null) {
			System.out.println("jdbcTemplate is null  ??????????????????????????????????????????");
		}
		try {
			result = jdbcTemplate.update(sql,toDoTask);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			result = -1;
		}

		return result;

	}

	public List<String> getAllTask() {
		return jdbcTemplate.query("SELECT todo_task FROM todo_list", new RowMapper<String>() {

			public String mapRow(ResultSet rs, int arg1) throws SQLException {
			 
				String s=rs.getString("todo_task");
				return s;
			}

		});
	}
}
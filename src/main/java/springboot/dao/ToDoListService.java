package springboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addTask(String toDoTask) {
		String sql = "INSERT INTO todo_list(todo_task) VALUES(?)";
		int result = 1;
		 
		try {
			result = jdbcTemplate.update(sql,toDoTask);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			result = -1;
		}

		return result;

	}
	
	public int deleteTask(String toDoTask) {
		String sql = "delete from  todo_list where todo_task = ?";
		int result = 1;
		 
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

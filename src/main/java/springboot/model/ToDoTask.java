package springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "todo_list", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class ToDoTask implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	public ToDoTask() {
		super();
	}
	
	public ToDoTask(String todoTask) {
		super();
		this.todoTask = todoTask;
	}
	public ToDoTask(int id, String todoTask) {
		super();
		this.id = id;
		this.todoTask = todoTask;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, length = 11)
	private int id;
	@Column(name = "todo_task", length = 450, nullable = false)
	private String todoTask;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodoTask() {
		return todoTask;
	}
	public void setTodoTask(String todoTask) {
		this.todoTask = todoTask;
	}

}

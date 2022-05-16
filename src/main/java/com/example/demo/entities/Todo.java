package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "todo")
public class Todo {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "date_start_task")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date dateStartTask;

	@Column(name = "date_end_task")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date dateEndTask;

//	@ManyToOne(fetch = FetchType.EAGER, optional = false)
//	@JoinColumn(name = "status_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private Status status;
	@Column(name = "status_name")
	private String statusName;

	public Todo() {
		super();
	}

	public Todo(long id, String taskName, Date dateStartTask, Date dateEndTask, String statusName) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.dateStartTask = dateStartTask;
		this.dateEndTask = dateEndTask;
		this.statusName = statusName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getDateStartTask() {
		return dateStartTask;
	}

	public void setDateStartTask(Date dateStartTask) {
		this.dateStartTask = dateStartTask;
	}

	public Date getDateEndTask() {
		return dateEndTask;
	}

	public void setDateEndTask(Date dateEndTask) {
		this.dateEndTask = dateEndTask;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", taskName=" + taskName + ", dateStartTask=" + dateStartTask + ", dateEndTask="
				+ dateEndTask + ", status=" + statusName + "]";
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}

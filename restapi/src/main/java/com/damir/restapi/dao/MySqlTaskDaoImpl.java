package com.damir.restapi.dao;

import com.damir.restapi.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
@Qualifier("MySqlData")
public class MySqlTaskDaoImpl implements TaskDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class TaskRowMapper implements RowMapper<Task>{

        @Override
        public Task mapRow(ResultSet resultSet, int i) throws SQLException {
                    Task task = new Task();
                    task.setId(resultSet.getInt("id"));
                    task.setName(resultSet.getString("name"));
                    task.setTask(resultSet.getString("task"));
                    task.setCompleted(resultSet.getBoolean("complete"));
                    return task;
        }
    }

    @Override
    public Collection <Task> getAllTasks() {

        final String sql = "SELECT * FROM tasks";

        return jdbcTemplate.query(sql, new TaskRowMapper());
    }

    @Override
    public Task getTaskById(int id) {
        final String sql = "SELECT * FROM tasks where id=?";
        Task task = jdbcTemplate.queryForObject(sql, new TaskRowMapper(), id);

        return task;
    }

    @Override
    public void deleteTaskById(int id) {
        final String sql = "DELETE FROM tasks WHERE id = ?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public void updateTask(Task task) {
        final String sql = "UPDATE tasks SET name = ?, task = ?, complete = ? WHERE id=?";
        int id= task.getId();
        final String taskName = task.getName();
        final String taskTask = task.getTask();
        final Boolean taskComplete= task.getCompleted();
        jdbcTemplate.update(sql, taskName,taskTask,taskComplete,id);

    }

    @Override
    public void insertTask(Task task) {

        final String sql = "INSERT INTO tasks (name,task) VALUES(?,?)";
        final String taskName = task.getName();
        final String taskTask = task.getTask();
        jdbcTemplate.update(sql, taskName,taskTask);

    }

}

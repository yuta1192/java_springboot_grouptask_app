package com.example.search.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.search.domains.Task;

@Mapper
public interface TaskMapper {
	List<Task> all();
    List<Task> findByMemberTask(int memberId);
    void add(Task task);
    void compliteTask(int id);
    List<Task> allMember();
    List<Task> findNotComplite();
}

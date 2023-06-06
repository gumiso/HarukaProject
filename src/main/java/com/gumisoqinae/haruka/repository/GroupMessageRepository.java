package com.gumisoqinae.haruka.repository;

import com.gumisoqinae.haruka.entity.GroupMessage;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;

@Table
public interface GroupMessageRepository extends CrudRepository<GroupMessage, String> {
}

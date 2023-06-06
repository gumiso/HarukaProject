package com.gumisoqinae.haruka.repository;

import com.gumisoqinae.haruka.entity.PrivateMessage;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Table;

@Table
public interface PrivateMessageRepository extends CrudRepository<PrivateMessage, String> {
}

package com.cdc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdc.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
package com.example.rest_company.repository;

import com.example.rest_company.entity.Group;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group,Long> {
}

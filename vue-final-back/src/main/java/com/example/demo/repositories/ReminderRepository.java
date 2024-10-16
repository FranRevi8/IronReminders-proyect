package com.example.demo.repositories;

import com.example.demo.models.Reminder;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByUser(User user);
}

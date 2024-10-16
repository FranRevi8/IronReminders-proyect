package com.example.demo.services.impl;

import com.example.demo.models.Reminder;
import com.example.demo.models.User;
import com.example.demo.repositories.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public List<Reminder> findAll() {
        return reminderRepository.findAll();
    }

    public Reminder findById(Long id) {
        Optional<Reminder> reminder = reminderRepository.findById(id);
        return reminder.orElse(null);
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public Reminder updateReminder(Long id, Reminder reminder) {
        Optional<Reminder> existingReminderOptional = reminderRepository.findById(id);
        if (existingReminderOptional.isPresent()) {
            Reminder existingReminder = existingReminderOptional.get();

            reminder.setUser(existingReminder.getUser());
            reminder.setId(id);

            return reminderRepository.save(reminder);
        } else {
            return null;
        }
    }

    public void deleteReminder(Long id) {
        if (reminderRepository.existsById(id)) {
            reminderRepository.deleteById(id);
        }
    }

    public List<Reminder> findByUser(User user) {
        return reminderRepository.findByUser(user);
    }
}

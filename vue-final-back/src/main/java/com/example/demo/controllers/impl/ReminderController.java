package com.example.demo.controllers.impl;

import com.example.demo.models.Reminder;
import com.example.demo.models.User;
import com.example.demo.services.impl.ReminderService;
import com.example.demo.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Reminder> getAllReminders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);

        return reminderService.findByUser(user);
    }

    @GetMapping("/{id}")
    public Reminder getReminderById(@PathVariable Long id) {
        return reminderService.findById(id);
    }

    @PostMapping
    public Reminder createReminder(@RequestBody Reminder reminder) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);

        reminder.setUser(user);
        return reminderService.createReminder(reminder);
    }

    @PutMapping("/{id}")
    public Reminder updateReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        return reminderService.updateReminder(id, reminder);
    }

    @DeleteMapping("/{id}")
    public void deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
    }
}

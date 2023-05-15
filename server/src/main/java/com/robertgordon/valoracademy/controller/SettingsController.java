package com.robertgordon.valoracademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.robertgordon.valoracademy.model.Settings;
import com.robertgordon.valoracademy.service.SettingsService;

@RestController
@RequestMapping("/api/v1/")
public class SettingsController {

    @Autowired
    private SettingsService SettingsService;

    @PostMapping("settings")
    public Settings saveSettings(Settings settings) {
        return this.SettingsService.saveSettings(settings);
    }

    @GetMapping("settings")
    public List<Settings> getAllSettings() {
        return this.SettingsService.getAllSettings();
    }

    @GetMapping("settings/{id}")
    public ResponseEntity<Settings> getSettingsById(@PathVariable("id") Long id) {
        Settings settings = this.SettingsService.getSettingsById(id);
        return ResponseEntity.ok(settings);
    }

    @PutMapping("settings/{id}")
    public ResponseEntity<Settings> updateSettings(@PathVariable("id") Long id, @RequestBody Settings settings) {

        Settings updatedSettings = this.SettingsService.updateSettings(id, settings);
        return ResponseEntity.ok(updatedSettings);
    }

    @DeleteMapping("settings/{id}")
    public ResponseEntity<String> deleteSettings(@PathVariable("id") Long id) {

        this.SettingsService.deleteSettings(id);
        return ResponseEntity.ok("Settings with ID: " + id + " has been deleted.");
    }
}

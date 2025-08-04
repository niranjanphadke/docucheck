package com.samichinam.docucheck.controller;

import com.samichinam.docucheck.model.Capa;
import com.samichinam.docucheck.model.ValidationResponse;
import com.samichinam.docucheck.service.CapaService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Minimal admin endpoints for report review and approval.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final Map<Integer, ValidationResponse> reports = new ConcurrentHashMap<>();
    private final AtomicInteger idGen = new AtomicInteger();
    private final CapaService capaService;

    public AdminController(CapaService capaService) {
        this.capaService = capaService;
    }

    @PostMapping("/reports")
    public int submitReport(@RequestBody ValidationResponse response) {
        int id = idGen.incrementAndGet();
        reports.put(id, response);
        return id;
    }

    @GetMapping("/reports")
    public Map<Integer, ValidationResponse> listReports() {
        return reports;
    }

    @PostMapping("/reports/{id}/approve")
    public void approve(@PathVariable int id) {
        ValidationResponse response = reports.get(id);
        if (response != null) {
            response.setValidationStatus("Approved");
        }
    }

    @PostMapping("/reports/{id}/link-capa/{capaId}")
    public void linkCapa(@PathVariable int id, @PathVariable String capaId) {
        capaService.link(String.valueOf(id), capaId);
    }

    @GetMapping("/capas")
    public java.util.List<Capa> capas() {
        return capaService.all();
    }

    @PostMapping("/capas/{id}/effective")
    public void setEffective(@PathVariable String id, @RequestParam boolean value) {
        capaService.setEffective(id, value);
    }
}

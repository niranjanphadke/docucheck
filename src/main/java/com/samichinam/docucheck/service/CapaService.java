package com.samichinam.docucheck.service;

import com.samichinam.docucheck.model.Capa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Manages linking of reports to CAPAs and tracks their effectiveness.
 */
@Service
public class CapaService {

    private final Map<String, Capa> capas = new ConcurrentHashMap<>();

    public void link(String reportId, String capaId) {
        capas.computeIfAbsent(capaId, id -> new Capa(id, reportId, false));
    }

    public void setEffective(String capaId, boolean effective) {
        Capa capa = capas.get(capaId);
        if (capa != null) {
            capa.setEffective(effective);
        }
    }

    public List<Capa> all() {
        return new ArrayList<>(capas.values());
    }
}

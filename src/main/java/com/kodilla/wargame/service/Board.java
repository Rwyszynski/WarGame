package com.kodilla.wargame.service;

import com.kodilla.wargame.domain.Status;
import com.kodilla.wargame.model.Unit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope("singleton")
public class Battlefield {
    private int width;
    private int height;

    private Map<Long, Unit> units = new ConcurrentHashMap<>();

    public synchronized boolean isOccupied(int x, int y) {
        return units.values().stream()
                .anyMatch(u -> u.getX() == x && u.getY() == y && u.getStatus() == Status.OK);
    }

    public Optional<Unit> getUnitAt(int x, int y) {
        return units.values().stream()
                .filter(u -> u.getX() == x && u.getY() == y && u.getStatus() == Status.OK)
                .findFirst();
    }

}

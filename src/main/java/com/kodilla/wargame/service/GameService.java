package com.kodilla.wargame.service;

import com.kodilla.wargame.DTO.UnitDto;
import com.kodilla.wargame.domain.Color;
import com.kodilla.wargame.domain.Where;
import com.kodilla.wargame.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private Board board;

    public void moveUnit(Long unitId, Where where){

    }

    public void shoot(Long unitId, Where where, int distance) {

    }

    public List<UnitDto> getUnitsForPlayer(Color player) {
        return board.getAllUnits().stream()
                .filter(u -> u.getPlayer() == player)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private UnitDto mapToDto(Unit unit) {
        UnitDto dto = new UnitDto();
        dto.setId(unit.getId());
        dto.setX(unit.getX());
        dto.setY(unit.getY());
        dto.setType(unit.getType());
        dto.setStatus(unit.getStatus());
        dto.setMoveCount(unit.getMoveCount());
        return dto;
    }
}

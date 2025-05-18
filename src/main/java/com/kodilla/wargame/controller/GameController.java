package com.kodilla.wargame.controller;

import com.kodilla.wargame.DTO.Move;
import com.kodilla.wargame.DTO.UnitDto;
import com.kodilla.wargame.domain.Color;
import com.kodilla.wargame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/units")
    public List<UnitDto> listUnits(@RequestParam("player") Color player) {
        return gameService.getUnitsForPlayer(player);
    }

    @PostMapping("/command/move")
    public ResponseEntity<Void> moveUnit(@RequestBody Move command) {
        gameService.moveUnit(command.getUnitId(), command.getWhere());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
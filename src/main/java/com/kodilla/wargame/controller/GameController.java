package com.kodilla.wargame.controller;

import com.kodilla.wargame.DTO.Move;
import com.kodilla.wargame.DTO.UnitDto;
import com.kodilla.wargame.domain.Color;
import com.kodilla.wargame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
    public String choosePlayerForm() {
        return "choose-player";
    }

    @PostMapping("/game")
    public String showGame(@RequestParam("player") Color player, Model model) {
        List<UnitDto> units = gameService.getUnitsForPlayer(player);
        model.addAttribute("units", units);
        model.addAttribute("player", player);
        return "game";
    }
}
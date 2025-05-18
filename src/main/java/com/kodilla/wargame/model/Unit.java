package com.kodilla.wargame.model;

import com.kodilla.wargame.domain.Color;
import com.kodilla.wargame.domain.Fighter;
import com.kodilla.wargame.domain.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Unit {
    @Id
    @GeneratedValue
    private Long id;

    private int x;
    private int y;

    @Enumerated(EnumType.STRING)
    private Color player;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OK;

    private LocalDateTime lastCommandTime;

    private int moveCount;

    public abstract Fighter getType();
}


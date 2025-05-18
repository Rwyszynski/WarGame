package com.kodilla.wargame.DTO;

import com.kodilla.wargame.domain.Fighter;
import com.kodilla.wargame.domain.Status;


public class UnitDto {
    private Long id;
    private int x;
    private int y;
    private Fighter type;
    private Status status;
    private int moveCount;

    public Long getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Fighter getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(Fighter type) {
        this.type = type;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}

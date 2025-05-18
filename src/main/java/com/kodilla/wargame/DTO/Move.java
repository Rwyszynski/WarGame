package com.kodilla.wargame.DTO;

import com.kodilla.wargame.domain.Where;

public class Move {
    private Long unitId;
    private Where where;

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }


    public void setDirection(Where direction) {
        this.where = where;
    }

    public Where getWhere() {
        return where;
    }
}
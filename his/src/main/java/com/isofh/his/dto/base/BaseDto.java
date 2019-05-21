package com.isofh.his.dto.base;

public abstract class BaseDto {

    private Long id;

    private boolean active = true;

    public BaseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

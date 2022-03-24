package com.kms.java8study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OnlineClass {
    private int id;
    private String className;
    boolean isOpen;
    public Progress process;
    public Progress optionalProgress;

    public OnlineClass(int id, String className, boolean isOpen) {
        this.id = id;
        this.className = className;
        this.isOpen = isOpen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Progress getProcess() {
        return process;
    }

    public Optional<Progress> getOptionalProgress() {
        return Optional.ofNullable(optionalProgress);
    }

}

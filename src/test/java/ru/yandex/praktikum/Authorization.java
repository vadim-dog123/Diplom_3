package ru.yandex.praktikum;

public enum Authorization {
    PASSWORD("1234567"),
    EMAIL("1234567891@123.tu");

    private final String text;

    Authorization(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

package dev.ogabek.amazonappui.model;

public class Essential {

    private final String title;
    private final int image;

    public Essential(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}

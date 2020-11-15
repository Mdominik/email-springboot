package pl.com.mazniak.sendingmail.movie;

import java.util.UUID;

public class Movie {
    private UUID uuid;
    private String title;
    private int productionYear;
    private String producer;


    public Movie(String title, int productionYear, String producer) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.productionYear = productionYear;
        this.producer = producer;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", productionYear=" + productionYear +
                ", producer='" + producer + '\'' +
                '}';
    }
}

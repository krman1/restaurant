package pl.krman.restaurant.cuisin;

public class Cuisin {
    private Long id;
    private String name;

    public Cuisin(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name + " - press " + id;

    }
}

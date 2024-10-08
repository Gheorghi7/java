import enums.color.Color;
import enums.point.PointMarkers;

enum UsageType {
    ENTERTAINMENT, GOVERNMENT, RESIDENTIAL, SPORTS;
}

public class Building implements Mappable {
    //    geometry type of POINT
    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + "(" + usage + ")";
    }

    @Override
    public String getMarker() {
        return switch (usage) {
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarkers.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointMarkers.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointMarkers.SQUARE;
            case SPORTS -> Color.ORANGE + " " + PointMarkers.PUSH_PIN;
            default -> Color.BLACK + " " + PointMarkers.CIRCLE;
        };
    }

    @Override
    public Geometry getShare() {
        return Geometry.POINT;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON()+ """
                "name":"%s", "usage":"%s" """.formatted(name,usage);
    }
}

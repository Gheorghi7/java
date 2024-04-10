import enums.color.Color;
import enums.line.LineMarkers;

enum UtilityType {
    ELECTRICAL, FIBER_OPTIC, GAS, WATER;
}

public class UtilityLine implements Mappable{
    //    geometry type of Line
    public String name;
    public UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + "(" + type + ")";

    }

    @Override
    public String getMarker() {
        return switch(type){
            case ELECTRICAL -> Color.RED+" "+ LineMarkers.DASHED;
            case FIBER_OPTIC -> Color.GREEN+" "+ LineMarkers.DOTTED;
            case GAS -> Color.ORANGE+" "+ LineMarkers.SOLID;
            case WATER -> Color.BLUE+" "+ LineMarkers.SOLID;
            default -> Color.BLACK+" "+ LineMarkers.SOLID;

        };
    }

    @Override
    public Geometry getShare() {
        return Geometry.LINE;
    }
    @Override
    public String toJSON() {
        return Mappable.super.toJSON()+ """
                "name":"%s", "utility":"%s" """.formatted(name,type);
    }
}

enum Geometry {
    LINE, POINT, POLYGON;
}

public interface Mappable {
    String JSON_PROPERTY = """
            "properties":{%s}""";

    static void maplt(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }

    ;

    String getLabel();

    String getMarker();

    Geometry getShare();

    default String toJSON() {
        return """
                "type":"%s", "label": "%s", "marker": "%s" """.formatted(getShare(), getLabel(), getMarker());
    }
}

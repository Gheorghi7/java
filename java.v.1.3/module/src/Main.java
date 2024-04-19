public class Main {
    public static void main(String[] args) {
        var nationalUSPark = new Park[]{new Park("Yellowstone", "44.4882,-120.5762"),
                                        new Park("Grand Canyon", "36.3412, -123.3241"),
                                        new Park("Yosemite", "37.1232, -231.4145")};

        Layer<Park> parkLayer = new Layer<>(nationalUSPark);
        parkLayer.renderLayer();

        var majorUSRiver = new River[]{
                new River("Mississippi", "67.2165, -21.1414", "31.3213, -89.4321"),
                new River("Missouri", "45.7845, -111.4654", "34.2316, -77.7675")
        };

        Layer<River> riverLayer = new Layer<>(majorUSRiver);

        riverLayer.addElements( new River("Colorado", "40.2428, -75.9585", "38.3473, -87.3784"),
                                new River("Delaware", "43.1016, -75.8387", "38.4324, -76.9398"));

        riverLayer.renderLayer();
    }


}
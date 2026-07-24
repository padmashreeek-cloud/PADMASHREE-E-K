import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        int totalTime;
        int count;

        Route(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, Route> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn check = checkInMap.get(id);

        String key = check.station + "-" + stationName;
        int travelTime = t - check.time;

        Route route = travelMap.getOrDefault(key, new Route(0, 0));
        route.totalTime += travelTime;
        route.count++;

        travelMap.put(key, route);
        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        Route route = travelMap.get(key);

        return (double) route.totalTime / route.count;
    }
}

class UndergroundSystem {
    private Map<Integer,Pair>checkIns;
    private Map<String,double[]>travelData;
    public UndergroundSystem() {
        checkIns=new HashMap<>();
        travelData=new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id,new Pair(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair checkInInfo=checkIns.get(id);
        checkIns.remove(id);
        String route=checkInInfo.stationName+"-"+stationName;
        int travelTime=t-checkInInfo.time;
        travelData.putIfAbsent(route,new double[2]);
        travelData.get(route)[0]+=travelTime;
        travelData.get(route)[1]+=1;
    }
    public double getAverageTime(String startStation, String endStation) {
        String route=startStation+"-"+endStation;
        double[] data=travelData.get(route);
        return data[0]/data[1];
    }
    private static class Pair{
        String stationName;
        int time;
        Pair(String stationName,int time){
            this.stationName=stationName;
            this.time=time;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
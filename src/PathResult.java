public class PathResult {
    private String path;
    private int totalTime;

    public PathResult() {
        this.path = "";
        this.totalTime = Integer.MAX_VALUE;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public void setTotalTime(int totalTime){
        this.totalTime = totalTime;
    }

    public int getTotalTime(){
        return totalTime;
    }
}
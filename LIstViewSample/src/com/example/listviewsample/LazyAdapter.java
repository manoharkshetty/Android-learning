package com.example.listviewsample;
public class LazyAdapter {
    private int imageId;
    private int transfers;
    private int points;
    private int pos;
    private String playerName;
    private String teamName;
 
    public LazyAdapter(int imageId, String pname, String tname,int trans,int points,int pos) {
        this.imageId = imageId;
        this.playerName= pname;
        this.teamName=tname ;
        this.transfers=trans;
        this.points=points;
        this.pos=pos;
       
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getPlayerName() {
    	
        return playerName;
    }
    public void setPlayerName(String title) {
        this.playerName= title;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String tName) {
        this.teamName = tName;
    }
    public String getTrans() {
        return transfers + " transfers";
    }
    public void setTrans(int trans) {
        this.transfers = trans;
    }
    public String getPoints() {
        return "" + points;
    }
    public void setPoints(int points ) {
        this.points = points;
    }
    public String getPos() {
        return "" + pos;
    }
   
   
    @Override
    public String toString() {
        return playerName + "\n" + teamName;
    }
}

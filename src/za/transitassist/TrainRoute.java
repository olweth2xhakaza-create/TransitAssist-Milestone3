package src.za.transitassist;

public class TrainRoute extends TransportRoute {

//---Train-specific fields---
private String trainstation;
private String traintype;

//---constructor---
public TrainRoute(String routenumber, String origin,String destination,int safetyrating,
		      String intermediatestops,String depaturetime,double estimatedtraveltime,
		      boolean accessibility,double fare,String traintype,
		      String operatingstatus,String disruptionmessage,String trainstation) {

//call the transportRout superclass constructor
super(routenumber,origin,destination,intermediatestops,traintype,depaturetime,
      estimatedtraveltime,fare,accessibility,safetyrating,operatingstatus,disruptionmessage);
      
//Initialize train-spesific fields
this.trainstation = trainstation;
this.traintype=traintype;
}
//---Getters--
public String getTrainstation(){
	return trainstation;	
}
//---Setters---
public void setTrainstation(String trainstation){
	this.trainstation=trainstation;
}
//---Display Train Rout---
public void displayrout(){
	
//display common rout information
 super.displayRoute();
//Display train-specific information
System.out.println("Train station:"+trainstation);
System.out.println("Train Type:"+ traintype);

System.out.println("====================");

}
}
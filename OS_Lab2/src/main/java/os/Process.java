
package os;


public class Process {
    String name;
    int arriveTime;
    int executionTime;
    int deadlinePeriod;
    int executedPeriod;
    boolean isCompleted;
    String priority;
    int executedPre;

    public Process(String name, int arriveTime, int executionTime, int deadlinePeriod,String priority) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.executionTime = executionTime;
        this.deadlinePeriod = deadlinePeriod;
        this.priority = priority;
        executedPeriod=0;
        isCompleted=false;
        executedPre=0;
    }

    public void calcExecutedPre() {
        this.executedPre =100-(int)((long)100*(executionTime-executedPeriod)/(long)executionTime);
    }

    

    public String getName() {
        return name;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getDeadlinePeriod() {
        return deadlinePeriod;
    }

    public int getExecutedPeriod() {
        return executedPeriod;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }
    
    
    
}

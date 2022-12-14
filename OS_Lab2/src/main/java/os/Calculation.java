
package os;

import java.awt.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;



public class Calculation {
    Process[] sortedProLst;
    ArrayList<Process> readyList;
    ArrayList<Process> finishedList;
    ArrayList<Process> unfinishedList;
    int terminatedCount;
    int currentTime;
    int indexForsortedList;
    Simulator sim;
    int processExeNum;

    public Calculation(Process[] dataProcess,Simulator sim) {
        this.sim=sim;
        sortedProLst=dataProcess;
        Process temp;
        for(int i=0;i<dataProcess.length;i++){
            for(int j=0;j<dataProcess.length-1;j++){
                if(sortedProLst[j].getArriveTime()>sortedProLst[j+1].getArriveTime()){
                    temp=sortedProLst[j+1];
                    sortedProLst[j+1]=sortedProLst[j];
                    sortedProLst[j]=temp;
                }
            }
        }
        
        readyList=new ArrayList<>();
        finishedList=new ArrayList<>();
        unfinishedList=new ArrayList<>();
        terminatedCount=0;
        currentTime=0;
        indexForsortedList=0;
        processExeNum=1;
    }

    /////////////////////////////////
    
    public void setAllExePre(){
        for(Process p:sortedProLst){
            p.calcExecutedPre();
            System.out.println("Process :"+p.getName()+"presentage : "+p.executedPre);
        }
    }

    
    
    public void start(){
        Timer timer = new Timer();
        int delay = 0; // delay for 5 sec.
        int period = 2000; // repeat every sec.
        
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if(terminatedCount==sortedProLst.length){timer.cancel();}
                
                
                execution();
                //GUI Implementation Part
                setAllExePre();
                sim.FinishedProcessImplement(finishedList);
                sim.UnfinishedProcessesImplement(unfinishedList);
                sim.ReadyQueueImplement(readyList);
                sim.setTimeLabel(currentTime);
                sim.updateProcess(sortedProLst);
                //GUI over
                currentTime++;
                System.out.println("CurrentTime :"+currentTime);
                
            }
        }, delay, period);
      
        
        
        
        
    }
    
    public void execution(){
        //ading element to readyList
        while(indexForsortedList<sortedProLst.length && currentTime==sortedProLst[indexForsortedList].getArriveTime()){
            readyList.add(sortedProLst[indexForsortedList]);
            indexForsortedList++;
        }
        
        
        for (int i=0;i<readyList.size();i++){
            Process p=readyList.get(i);
            if(p.isIsCompleted()==true){
                System.out.println("Process "+p.name+" is finished");
                finishedList.add(p);
                readyList.remove(p);
                terminatedCount++;
            }
            else if(((p.getArriveTime()+p.getDeadlinePeriod()-currentTime)-(p.getExecutionTime()-p.getExecutedPeriod()))<0){
                System.out.println("Process "+p.name+" is unfinished");
                unfinishedList.add(p);
                readyList.remove(p);
                terminatedCount++;
            }
            else{}
        }
        
        if(!readyList.isEmpty()){
            Process currProcess=readyList.get(0);
            for(Process q:readyList){
                if(q.getDeadlinePeriod()<currProcess.getDeadlinePeriod()){
                    currProcess=q;
                }
                else if(q.getDeadlinePeriod()==currProcess.getDeadlinePeriod()){
                    if((q.getExecutionTime()-q.getExecutedPeriod())<(currProcess.getExecutionTime()+currProcess.getExecutedPeriod()))
                        currProcess=q;
                }
                else{}
            }
            System.out.println("Process "+currProcess.name+" has earliestdeadline "+currProcess.deadlinePeriod );
            //executing current process
            currProcess.executedPeriod++;
            //GUI Printing
            sim.ShowProcessOnExeSqnce(currProcess, processExeNum);
            processExeNum++;
            //GUI Printing
            System.out.println("Process "+currProcess.name+" executed period is "+currProcess.executedPeriod);
            if(currProcess.getExecutedPeriod()==currProcess.getExecutionTime()){
                currProcess.isCompleted=true;
                System.out.println("Process "+currProcess.name+" marked as finished");
            }
        }
        
    }
    
   
    
    
}

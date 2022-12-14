/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Simulator extends javax.swing.JFrame {
    Calculation calc;
   
    
    //My methods................................    //My methods................................    //My methods................................    //My methods................................
   
    public String GetCharToNum(int k){
        String ch="";
        switch(k){
            case 0:
                ch="A";
                break;
            case 1:
                ch="B";
                break;
            case 2:
                ch="C";
                break;
            case 3:
                ch="D";
                break;
            case 4:
                ch="E";
                break;
            case 5:
                ch="F";
                break;
            case 6:
                ch="G";
                break;
            case 7:
                ch="H";
                break;
        }
        return ch;
    }
    public void ReadyQueueImplement(ArrayList<Process> Processes){
        drawFillRect(ReadyQueueJPanel,10, 50, 220, 100,new Color(240,240,240), "",10, 100);
        
        if(Processes.size()!=0){
            for(int i=0;i<Processes.size();i++){
                drawFillRect(ReadyQueueJPanel, (10+i*25), 50, 20, 100,Color.YELLOW, Processes.get(i).name, (10+i*25+5), 100);
            }
        }
        
    }
    public void FinishedProcessImplement(ArrayList<Process> Processes){
        
        
        if(Processes.size()!=0){
            for(int i=0;i<Processes.size();i++){
                drawFillRect(FinishedProcessesJPanel, (10+i*25), 50, 20, 100, Color.GREEN, Processes.get(i).name, (10+i*25+5), 100);
            }
        }
    }
    public void UnfinishedProcessesImplement(ArrayList<Process> Processes){
        
         
        if(Processes.size()!=0){
            for(int i=0;i<Processes.size();i++){
                drawFillRect(unfinishedProcessesJPanel, (10+i*25), 50, 20, 100, Color.RED, Processes.get(i).name, (10+i*25+5), 100);
            }
        }
    }
    public void ShowProcessOnExeSqnce(Process process,int location){
        int strYAdtion=0;
        Color col=null;
        switch(process.getName()){
            case "A":
                strYAdtion=0;
                col = new Color(155, 48, 255);
                break;
            case "B":
                strYAdtion=28;
                col = new Color(255, 127, 36);
                break;
            case "C":
                strYAdtion=2*28;
                col = new Color(127, 255, 0);
                break;
            case "D":
                strYAdtion=3*28;
                col = new Color(148,0, 211);
                break;
            case "E":
                strYAdtion=4*28;
                col = new Color(127, 255, 212);
                break;
            case "F":
                strYAdtion=5*28;
                col = new Color(0, 206, 209);
                break;
            case "G":
                strYAdtion=6*28;
                col = new Color(238, 154, 0);
                break;
            case "H":
                strYAdtion=7*28;
                col = new Color(0, 201, 87);
                break;
            
        }
        drawFillRect(ProcessjPanel, 80+(location-1)*40, 28+strYAdtion, 35, 26, col,process.getName(), 80+(location-1)*40+13, 47+strYAdtion);
    }
    public void setTimeLabel(int currentTime){
        TimeLabel.setText(Integer.toString(currentTime));
    }
    public void updateProcess(Process[] processes){
        
        SetProgressBarColour(); // To set Progress Bar Colour
        
        int length=processes.length;
        if(0<length){
             jProgressBarA.setValue(processes[0].executedPre);
             jProgressBarA2.setValue(processes[0].executedPre);;
             jProgressBarA3.setValue(processes[0].executedPre);
             jProgressBarA4.setValue(processes[0].executedPre);
             jProgressBarA5.setValue(processes[0].executedPre);
             jProgressBarA6.setValue(processes[0].executedPre);   
        }
        
        if(1<length){
             jProgressBarB.setValue(processes[1].executedPre);
             jProgressBarB2.setValue(processes[1].executedPre);;
             jProgressBarB3.setValue(processes[1].executedPre);
             jProgressBarB4.setValue(processes[1].executedPre);
             jProgressBarB5.setValue(processes[1].executedPre);
             jProgressBarB6.setValue(processes[1].executedPre);   
        }
        
        if(2<length){
             jProgressBarC.setValue(processes[2].executedPre);
             jProgressBarC2.setValue(processes[2].executedPre);;
             jProgressBarC3.setValue(processes[2].executedPre);
             jProgressBarC4.setValue(processes[2].executedPre);
             jProgressBarC5.setValue(processes[2].executedPre);
             jProgressBarC6.setValue(processes[2].executedPre);   
        }
        
        if(3<length){
             jProgressBarD.setValue(processes[3].executedPre);
             jProgressBarD2.setValue(processes[3].executedPre);;
             jProgressBarD3.setValue(processes[3].executedPre);
             jProgressBarD4.setValue(processes[3].executedPre);
             //jProgressBarD5.setValue(processes[3].executedPre);
             jProgressBarD6.setValue(processes[3].executedPre);   
        }
        
        if(4<length){
             jProgressBarE.setValue(processes[4].executedPre);
             jProgressBarE2.setValue(processes[4].executedPre);;
             jProgressBarE3.setValue(processes[4].executedPre);
             jProgressBarE4.setValue(processes[4].executedPre);
             
        }
        
        if(5<length){
             jProgressBarF.setValue(processes[5].executedPre);
             jProgressBarF2.setValue(processes[5].executedPre);;
             //jProgressBarF3.setValue(processes[5].executedPre);
             jProgressBarF4.setValue(processes[5].executedPre);
             //jProgressBarF5.setValue(processes[5].executedPre);
             //jProgressBarF6.setValue(processes[5].executedPre);   
        }
        
        if(6<length){
             jProgressBarG.setValue(processes[6].executedPre);
             jProgressBarG2.setValue(processes[6].executedPre);;
                
        }
        if(7<length){
             jProgressBarH.setValue(processes[7].executedPre);
             
                
        }
    }
    
    //this method set specific colour to Progress Bar
    public void SetProgressBarColour(){
        
        Color colr;
        
        //A
        colr = new Color(155, 48, 255);
        jProgressBarA.setForeground(colr);
        jProgressBarA2.setForeground(colr);
        jProgressBarA3.setForeground(colr);
        jProgressBarA4.setForeground(colr);
        jProgressBarA5.setForeground(colr);
        jProgressBarA6.setForeground(colr);
        
        //B
        colr = new Color(255, 127, 36);
        jProgressBarB.setForeground(colr);
        jProgressBarB2.setForeground(colr);
        jProgressBarB3.setForeground(colr);
        jProgressBarB4.setForeground(colr);
        jProgressBarB5.setForeground(colr);
        jProgressBarB6.setForeground(colr);
        
        //C
        colr = new Color(127, 255, 0);
        jProgressBarC.setForeground(colr);
        jProgressBarC2.setForeground(colr);
        jProgressBarC3.setForeground(colr);
        jProgressBarC4.setForeground(colr);
        jProgressBarC5.setForeground(colr);
        jProgressBarC6.setForeground(colr);
        
        //D
        colr = new Color(148,0, 211);
        jProgressBarD.setForeground(colr);
        jProgressBarD2.setForeground(colr);
        jProgressBarD3.setForeground(colr);
        jProgressBarD4.setForeground(colr);
        jProgressBarD6.setForeground(colr);
        
        //E
        colr = new Color(127, 255, 212);
        jProgressBarE.setForeground(colr);
        jProgressBarE2.setForeground(colr);
        jProgressBarE3.setForeground(colr);
        jProgressBarE4.setForeground(colr);
        
        //F
        colr = new Color(0, 206, 209);
        jProgressBarF.setForeground(colr);
        jProgressBarF2.setForeground(colr);
        jProgressBarF4.setForeground(colr);
        
        //G
        colr = new Color(238, 154, 0);
        jProgressBarG.setForeground(colr);
        jProgressBarG2.setForeground(colr);
        
        //H
        colr = new Color(0, 201, 87);
        jProgressBarH.setForeground(colr);
        
        
    }
    //implement this further
    
    
   // .............................................

  
    public Simulator(String[][]processData,int numberOfProces) {
        initComponents();
        
        
        boolean []setV = new boolean[6];
        setV[8-numberOfProces] = true;
        
        
        ProData8varjPanel.setVisible(setV[0]);
        ProData7varjPanel.setVisible(setV[1]);
        ProData7varjPanel.setLocation(15, 253);
        ProData6varjPanel.setVisible(setV[2]);
        ProData6varjPanel.setLocation(15, 253);
        ProData5varjPanel.setVisible(setV[3]);
        ProData5varjPanel.setLocation(15, 253);
        Prodata4varjPanel.setVisible(setV[4]);
        Prodata4varjPanel.setLocation(15, 253);
        ProData3varjPanel.setVisible(setV[5]);
        ProData3varjPanel.setLocation(15, 253);
        
        
         
        
        
        ((DefaultTableModel)this.getDataTable().getModel()).setRowCount(0);
        for (int i = 0 ;  i < numberOfProces ; i ++){
            ((DefaultTableModel)(this.getDataTable().getModel())).addRow(new String[] {GetCharToNum(i),processData[i][1],processData[i][3] ,processData[i][2],processData[i][4]});
        }
        
        Process[] dataArray=new Process[processData.length];
        for(int n=0;n<processData.length;n++){
            dataArray[n]=new Process(processData[n][0], Integer.parseInt(processData[n][1]), Integer.parseInt(processData[n][3]), Integer.parseInt(processData[n][2]),processData[n][4]);
        }
        calc=new Calculation(dataArray,this);
        
        ///to be continoued
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        TimeLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        ProcessjPanel = new javax.swing.JPanel();
        ProData8varjPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBarA = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jProgressBarB = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jProgressBarC = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jProgressBarD = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jProgressBarE = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jProgressBarF = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jProgressBarG = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jProgressBarH = new javax.swing.JProgressBar();
        ProData7varjPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jProgressBarA2 = new javax.swing.JProgressBar();
        jLabel18 = new javax.swing.JLabel();
        jProgressBarB2 = new javax.swing.JProgressBar();
        jLabel19 = new javax.swing.JLabel();
        jProgressBarC2 = new javax.swing.JProgressBar();
        jLabel20 = new javax.swing.JLabel();
        jProgressBarD2 = new javax.swing.JProgressBar();
        jLabel21 = new javax.swing.JLabel();
        jProgressBarE2 = new javax.swing.JProgressBar();
        jLabel22 = new javax.swing.JLabel();
        jProgressBarF2 = new javax.swing.JProgressBar();
        jLabel23 = new javax.swing.JLabel();
        jProgressBarG2 = new javax.swing.JProgressBar();
        ProData6varjPanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jProgressBarA3 = new javax.swing.JProgressBar();
        jLabel25 = new javax.swing.JLabel();
        jProgressBarB3 = new javax.swing.JProgressBar();
        jLabel26 = new javax.swing.JLabel();
        jProgressBarC3 = new javax.swing.JProgressBar();
        jLabel27 = new javax.swing.JLabel();
        jProgressBarD3 = new javax.swing.JProgressBar();
        jLabel28 = new javax.swing.JLabel();
        jProgressBarE3 = new javax.swing.JProgressBar();
        jLabel34 = new javax.swing.JLabel();
        jProgressBarF4 = new javax.swing.JProgressBar();
        ProData5varjPanel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jProgressBarA4 = new javax.swing.JProgressBar();
        jLabel32 = new javax.swing.JLabel();
        jProgressBarB4 = new javax.swing.JProgressBar();
        jLabel33 = new javax.swing.JLabel();
        jProgressBarC4 = new javax.swing.JProgressBar();
        jProgressBarD4 = new javax.swing.JProgressBar();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jProgressBarE4 = new javax.swing.JProgressBar();
        ProData3varjPanel = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jProgressBarA5 = new javax.swing.JProgressBar();
        jLabel38 = new javax.swing.JLabel();
        jProgressBarB5 = new javax.swing.JProgressBar();
        jLabel39 = new javax.swing.JLabel();
        jProgressBarC5 = new javax.swing.JProgressBar();
        Prodata4varjPanel = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jProgressBarA6 = new javax.swing.JProgressBar();
        jLabel44 = new javax.swing.JLabel();
        jProgressBarB6 = new javax.swing.JProgressBar();
        jLabel45 = new javax.swing.JLabel();
        jProgressBarC6 = new javax.swing.JProgressBar();
        jLabel46 = new javax.swing.JLabel();
        jProgressBarD6 = new javax.swing.JProgressBar();
        ReadyQueueJPanel = new javax.swing.JPanel();
        FinishedProcessesJPanel = new javax.swing.JPanel();
        unfinishedProcessesJPanel = new javax.swing.JPanel();
        SimulateBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "TIME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        TimeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TimeLabel.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("ms");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ProcessjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Process", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout ProcessjPanelLayout = new javax.swing.GroupLayout(ProcessjPanel);
        ProcessjPanel.setLayout(ProcessjPanelLayout);
        ProcessjPanelLayout.setHorizontalGroup(
            ProcessjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ProcessjPanelLayout.setVerticalGroup(
            ProcessjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );

        ProData8varjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Prograss Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Process A:");

        jProgressBarA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarA.setStringPainted(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Process B:");

        jProgressBarB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarB.setStringPainted(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Process C:");

        jProgressBarC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarC.setStringPainted(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Process E:");

        jProgressBarD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarD.setStringPainted(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Process D:");

        jProgressBarE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarE.setStringPainted(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Process F:");

        jProgressBarF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarF.setStringPainted(true);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Process G:");

        jProgressBarG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarG.setStringPainted(true);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Process H:");

        jProgressBarH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarH.setStringPainted(true);

        javax.swing.GroupLayout ProData8varjPanelLayout = new javax.swing.GroupLayout(ProData8varjPanel);
        ProData8varjPanel.setLayout(ProData8varjPanelLayout);
        ProData8varjPanelLayout.setHorizontalGroup(
            ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData8varjPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBarG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jProgressBarF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        ProData8varjPanelLayout.setVerticalGroup(
            ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData8varjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jProgressBarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jProgressBarB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jProgressBarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jProgressBarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jProgressBarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jProgressBarF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jProgressBarG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData8varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jProgressBarH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ProData7varjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Prograss Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Process A:");

        jProgressBarA2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarA2.setStringPainted(true);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Process B:");

        jProgressBarB2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarB2.setStringPainted(true);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Process C:");

        jProgressBarC2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarC2.setStringPainted(true);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Process E:");

        jProgressBarD2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarD2.setStringPainted(true);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Process D:");

        jProgressBarE2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarE2.setStringPainted(true);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Process F:");

        jProgressBarF2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarF2.setStringPainted(true);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Process G:");

        jProgressBarG2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarG2.setStringPainted(true);

        javax.swing.GroupLayout ProData7varjPanelLayout = new javax.swing.GroupLayout(ProData7varjPanel);
        ProData7varjPanel.setLayout(ProData7varjPanelLayout);
        ProData7varjPanelLayout.setHorizontalGroup(
            ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData7varjPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17))
                .addGap(30, 30, 30)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBarG2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jProgressBarF2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarE2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarD2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarC2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarB2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarA2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        ProData7varjPanelLayout.setVerticalGroup(
            ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData7varjPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jProgressBarA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jProgressBarB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jProgressBarC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jProgressBarD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jProgressBarE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jProgressBarF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData7varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jProgressBarG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ProData6varjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Prograss Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Process A:");

        jProgressBarA3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarA3.setStringPainted(true);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Process B:");

        jProgressBarB3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarB3.setStringPainted(true);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Process C:");

        jProgressBarC3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarC3.setStringPainted(true);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Process E:");

        jProgressBarD3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarD3.setStringPainted(true);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Process D:");

        jProgressBarE3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarE3.setStringPainted(true);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Process F:");

        jProgressBarF4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarF4.setStringPainted(true);

        javax.swing.GroupLayout ProData6varjPanelLayout = new javax.swing.GroupLayout(ProData6varjPanel);
        ProData6varjPanel.setLayout(ProData6varjPanelLayout);
        ProData6varjPanelLayout.setHorizontalGroup(
            ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData6varjPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProData6varjPanelLayout.createSequentialGroup()
                        .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24))
                        .addGap(30, 30, 30)
                        .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jProgressBarE3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jProgressBarD3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBarC3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBarB3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBarA3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ProData6varjPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel34)
                        .addGap(30, 30, 30)
                        .addComponent(jProgressBarF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ProData6varjPanelLayout.setVerticalGroup(
            ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData6varjPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jProgressBarA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jProgressBarB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jProgressBarC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jProgressBarD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jProgressBarE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData6varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jProgressBarF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        ProData5varjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Prograss Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Process A:");

        jProgressBarA4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarA4.setStringPainted(true);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Process B:");

        jProgressBarB4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarB4.setStringPainted(true);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Process C:");

        jProgressBarC4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarC4.setStringPainted(true);

        jProgressBarD4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarD4.setStringPainted(true);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Process D:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Process E:");

        jProgressBarE4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarE4.setStringPainted(true);

        javax.swing.GroupLayout ProData5varjPanelLayout = new javax.swing.GroupLayout(ProData5varjPanel);
        ProData5varjPanel.setLayout(ProData5varjPanelLayout);
        ProData5varjPanelLayout.setHorizontalGroup(
            ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData5varjPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ProData5varjPanelLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(30, 30, 30)
                        .addComponent(jProgressBarE4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ProData5varjPanelLayout.createSequentialGroup()
                        .addGroup(ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel35)
                            .addComponent(jLabel33)
                            .addComponent(jLabel31))
                        .addGap(30, 30, 30)
                        .addGroup(ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jProgressBarD4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jProgressBarC4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBarB4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBarA4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        ProData5varjPanelLayout.setVerticalGroup(
            ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData5varjPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jProgressBarA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jProgressBarB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jProgressBarC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jProgressBarD4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData5varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jProgressBarE4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        ProData3varjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Prograss Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Process A:");

        jProgressBarA5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarA5.setStringPainted(true);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Process B:");

        jProgressBarB5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarB5.setStringPainted(true);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("Process C:");

        jProgressBarC5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarC5.setStringPainted(true);

        javax.swing.GroupLayout ProData3varjPanelLayout = new javax.swing.GroupLayout(ProData3varjPanel);
        ProData3varjPanel.setLayout(ProData3varjPanelLayout);
        ProData3varjPanelLayout.setHorizontalGroup(
            ProData3varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData3varjPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ProData3varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel37))
                .addGap(30, 30, 30)
                .addGroup(ProData3varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBarC5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jProgressBarB5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarA5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        ProData3varjPanelLayout.setVerticalGroup(
            ProData3varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProData3varjPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(ProData3varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jProgressBarA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData3varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jProgressBarB5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProData3varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jProgressBarC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        Prodata4varjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Prograss Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Process A:");

        jProgressBarA6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarA6.setStringPainted(true);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Process B:");

        jProgressBarB6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarB6.setStringPainted(true);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("Process C:");

        jProgressBarC6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarC6.setStringPainted(true);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Process D:");

        jProgressBarD6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarD6.setStringPainted(true);

        javax.swing.GroupLayout Prodata4varjPanelLayout = new javax.swing.GroupLayout(Prodata4varjPanel);
        Prodata4varjPanel.setLayout(Prodata4varjPanelLayout);
        Prodata4varjPanelLayout.setHorizontalGroup(
            Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prodata4varjPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Prodata4varjPanelLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(30, 30, 30)
                        .addComponent(jProgressBarD6, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                    .addGroup(Prodata4varjPanelLayout.createSequentialGroup()
                        .addGroup(Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel43))
                        .addGap(30, 30, 30)
                        .addGroup(Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jProgressBarC6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jProgressBarB6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBarA6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        Prodata4varjPanelLayout.setVerticalGroup(
            Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prodata4varjPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jProgressBarA6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jProgressBarB6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jProgressBarC6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Prodata4varjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jProgressBarD6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        ReadyQueueJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ReadyQueue", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        ReadyQueueJPanel.setName(""); // NOI18N

        javax.swing.GroupLayout ReadyQueueJPanelLayout = new javax.swing.GroupLayout(ReadyQueueJPanel);
        ReadyQueueJPanel.setLayout(ReadyQueueJPanelLayout);
        ReadyQueueJPanelLayout.setHorizontalGroup(
            ReadyQueueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        ReadyQueueJPanelLayout.setVerticalGroup(
            ReadyQueueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        FinishedProcessesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "FinishedPeocesses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        javax.swing.GroupLayout FinishedProcessesJPanelLayout = new javax.swing.GroupLayout(FinishedProcessesJPanel);
        FinishedProcessesJPanel.setLayout(FinishedProcessesJPanelLayout);
        FinishedProcessesJPanelLayout.setHorizontalGroup(
            FinishedProcessesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );
        FinishedProcessesJPanelLayout.setVerticalGroup(
            FinishedProcessesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        unfinishedProcessesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "UnfinishedProcesses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        javax.swing.GroupLayout unfinishedProcessesJPanelLayout = new javax.swing.GroupLayout(unfinishedProcessesJPanel);
        unfinishedProcessesJPanel.setLayout(unfinishedProcessesJPanelLayout);
        unfinishedProcessesJPanelLayout.setHorizontalGroup(
            unfinishedProcessesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        unfinishedProcessesJPanelLayout.setVerticalGroup(
            unfinishedProcessesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        SimulateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SimulateBtn.setText("Simulate");
        SimulateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulateBtnActionPerformed(evt);
            }
        });

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Process Number", "Arrival Time", "Service Time", "Dead Line", "Process Weight"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(dataTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ProData8varjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ProData7varjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProData6varjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProData5varjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProData3varjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Prodata4varjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ReadyQueueJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FinishedProcessesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unfinishedProcessesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(336, 336, 336)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(SimulateBtn)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ProcessjPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(SimulateBtn))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProData8varjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProData7varjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProData6varjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProData5varjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProData3varjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FinishedProcessesJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReadyQueueJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Prodata4varjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unfinishedProcessesJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProcessjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(462, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SimulateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulateBtnActionPerformed
        
        setImage();
        calc.start();
       
    }//GEN-LAST:event_SimulateBtnActionPerformed

    
    
    
    public Graphics2D drawFillRect(JPanel plan, int x, int y, int width, int height, Color c, String str, int strX, int strY){
        
        Graphics2D abc = (Graphics2D)plan.getGraphics();
        //abc.setFont(new Font("TimesRoman", Font.BOLD, 12));
        
        Font currentFont = abc.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
        
        //draw Rectangle 
        abc.setColor(c);
        abc.fillRect(x, y, width, height);
        
        //draw String
        abc.setFont(newFont);
        abc.setColor(Color.BLACK);
        abc.drawString(str, strX, strY);
        
        return abc;
    }
    
    public void setImage(){
        
        Graphics2D gr = (Graphics2D) ProcessjPanel.getGraphics();
        BufferedImage i=null;
        
        try {
            i = ImageIO.read(new File("image\\Process Image.png"));
        } catch (IOException ex) {
            Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gr.drawImage(i, 5, 20, this);
        gr.dispose();
        
    }


    public JTable getDataTable() {
        return dataTable;
    }
    
    public void pro(){
        
        jProgressBarA.setValue(50);
        jProgressBarA4.setValue(33);
    
    
    
    
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Simulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FinishedProcessesJPanel;
    private javax.swing.JPanel ProData3varjPanel;
    private javax.swing.JPanel ProData5varjPanel;
    private javax.swing.JPanel ProData6varjPanel;
    private javax.swing.JPanel ProData7varjPanel;
    private javax.swing.JPanel ProData8varjPanel;
    private javax.swing.JPanel ProcessjPanel;
    private javax.swing.JPanel Prodata4varjPanel;
    private javax.swing.JPanel ReadyQueueJPanel;
    private javax.swing.JButton SimulateBtn;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBarA;
    private javax.swing.JProgressBar jProgressBarA2;
    private javax.swing.JProgressBar jProgressBarA3;
    private javax.swing.JProgressBar jProgressBarA4;
    private javax.swing.JProgressBar jProgressBarA5;
    private javax.swing.JProgressBar jProgressBarA6;
    private javax.swing.JProgressBar jProgressBarB;
    private javax.swing.JProgressBar jProgressBarB2;
    private javax.swing.JProgressBar jProgressBarB3;
    private javax.swing.JProgressBar jProgressBarB4;
    private javax.swing.JProgressBar jProgressBarB5;
    private javax.swing.JProgressBar jProgressBarB6;
    private javax.swing.JProgressBar jProgressBarC;
    private javax.swing.JProgressBar jProgressBarC2;
    private javax.swing.JProgressBar jProgressBarC3;
    private javax.swing.JProgressBar jProgressBarC4;
    private javax.swing.JProgressBar jProgressBarC5;
    private javax.swing.JProgressBar jProgressBarC6;
    private javax.swing.JProgressBar jProgressBarD;
    private javax.swing.JProgressBar jProgressBarD2;
    private javax.swing.JProgressBar jProgressBarD3;
    private javax.swing.JProgressBar jProgressBarD4;
    private javax.swing.JProgressBar jProgressBarD6;
    private javax.swing.JProgressBar jProgressBarE;
    private javax.swing.JProgressBar jProgressBarE2;
    private javax.swing.JProgressBar jProgressBarE3;
    private javax.swing.JProgressBar jProgressBarE4;
    private javax.swing.JProgressBar jProgressBarF;
    private javax.swing.JProgressBar jProgressBarF2;
    private javax.swing.JProgressBar jProgressBarF4;
    private javax.swing.JProgressBar jProgressBarG;
    private javax.swing.JProgressBar jProgressBarG2;
    private javax.swing.JProgressBar jProgressBarH;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel unfinishedProcessesJPanel;
    // End of variables declaration//GEN-END:variables
}

package com.lab5.a;

public class Main {
        public static void main(String[] args){
            Recruits recruits = new Recruits(160);
            recruits.printRecruits();

            ThreadManager manager = new ThreadManager(recruits, 50);
        }
    }

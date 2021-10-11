package edu.neu.coe.info6205.union_find;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Assignment {


    static boolean isCompletelyConnected(int n,UF_HWQUPC uf){ //this function checks whether all the nodes are completely connected
        int temp=uf.find(0);
        int tempCount=n;
        for(int i=1;i<n;i++){
            if(uf.find(i)!=temp){
                break;
            }else{
                tempCount--;
            }
        }
        return tempCount==1;

    }
    static int count(int n){
        int count=0;
        UF_HWQUPC uf=new UF_HWQUPC(n);
        while(!isCompletelyConnected(uf.size(),uf)){
            int p= (int) (Math.random()*n);
            int q= (int) (Math.random()*n);
            if(!uf.connected(p,q)){
//                System.out.println("p="+p+" q="+q);
                uf.connect(p,q);
                count++;
            }
        }
//        System.out.println("Root is: "+uf.find(0));
        return count;
    }
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter number of sites: ");
//        int n=sc.nextInt();
        int n=0;
        try(PrintWriter writer = new PrintWriter(new File("test.csv"))){
            StringBuilder sbh = new StringBuilder();
            sbh.append("i,n,m\n");
            writer.write(sbh.toString());
            for(int i=0;i<1000;i++){
                n = ((int)(Math.random()*1000))+1;
                System.out.println("number of sites (n) = "+n);
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(i));
                sb.append(",");
                sb.append(String.valueOf(n));
                sb.append(",");
                sb.append(String.valueOf(count(n)));
                System.out.println("number of pairs generated (m) = "+count(n));
                System.out.println();
                sb.append("\n");
                writer.write(sb.toString());
//                System.out.println("Number of pairs generated: "+ count(n));
//                System.out.println();

//                if(n-1!=count(n)) System.out.println("n = "+n+"count(n) = "+count(n));
//                else System.out.println("Not found");
            }
            System.out.println("Successfully saved values to csv file");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}

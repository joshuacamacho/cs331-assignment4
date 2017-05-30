/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs331.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Josh
 */


public class Cs331Assignment4 {

    private static boolean exitOrNot() {
        System.out.println("Enter 1 to move to the next List or Enter 0 to finish making Lists");
        Scanner scan = new Scanner(System.in);
        return !(scan.next().charAt(0)=='0');
    }

    
    //Node for storing test
    public static class Node{
        String name;
        int cost;
        float prob;
        int totalcost;
        int totalprob;
        float ratio;
        Node(){
            name = "";
            cost = 0;
            prob = 0;
            totalcost=0;
            totalprob=0;
            ratio=0.0f;
        }
        
        Node(String n, int c, float p){
            name = n;
            cost = c;
            prob = p;
            totalcost=0;
            totalprob=0;
            ratio=0.0f;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<LinkedList> a = new ArrayList<LinkedList>();
        boolean CONTINUE=true;
        while(CONTINUE){
            LinkedList<Node> l = new LinkedList<Node>();
            boolean FILL=true;
            while(FILL){
                Node n = new Node();
                FILL = askUser(n);
                if(FILL) {
                    l.add(n);
                    display(l);
                }
                
            }
            
            if(l.size()>0) a.add(l);
            display(a);
            CONTINUE = exitOrNot();
            
        }
        
        
    }
    
    public static void display(ArrayList a){
        System.out.print("------------------- LISTS ------------------ \n");
        int j=0;
        int longest=0;
        for(int i=0; i<a.size();i++){
            LinkedList l = (LinkedList)a.get(i);
            if(longest<l.size()) longest=l.size();
        }
        while(j<longest){
            for(int i=0; i<a.size(); i++){
                LinkedList l = (LinkedList)a.get(i);
                    Node n =null;
                    if(j<l.size()) n = (Node)l.get(j);
                    if(n != null){
                        System.out.printf("X - %s %d %.2f       ", n.name, n.cost, n.prob );
                    }

            }
            System.out.print("\n\n");
            j++;
        }
    }
    
    public static void display(LinkedList l){
        for(int i=0; i<l.size(); i++){
            Node o = (Node)l.get(i);
            System.out.printf("X - %s %d %.2f \n\n\n", o.name, o.cost, o.prob );
        }
    }
    private static boolean askUser(Node n) {
        System.out.printf(
                "Enter test name (String) (Or enter 0 to finish this list) ");
        Scanner scan = new Scanner(System.in);
        
        String input = scan.next();
        if(input.charAt(0)=='0') return false;
        n.name=input;
        System.out.printf(
                "Enter test cost (int) ");
        
        n.cost= scan.nextInt();
        
        System.out.printf(
                "Enter test probability (float) ");
        
        n.prob = scan.nextFloat();
        
        return true;
    }
}

//Anatoly Brevnov
//Advanced Computer Science
//December 17, 2015
//Darby Thompson
//Sudoku Solve: 9 by 9 board



import java.io.*;
import java.util.Scanner;

public class sudoku_toly {
    
    static int size=9;
    static int [][] temp=new int[size][size];
    static int count=0;

    
    public static void main(String[] args) {

        int[][] board = new int[size][size];
        
        readpuzzle(board);
        print(board);
        System.out.println(solve(board));
        
        
        System.out.println("solved:");
        print(board);
    }
    
    public static boolean solve(int[][] board) {
        //i make a copy of the board which
        int[][] tme=copy(board);
        //i wnat to change board later so i call the helperfunction which calls my real solve that i call recursively
        helperFunction(tme);
        //returns false if board returned is not full
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                board[i][j]=temp[i][j];
                if (temp[i][j]==0){
                    
                    return false;
                }
            }
            
        }
        
        
        
        
        
        return true;
    }
    
    public static boolean cellSolve(int[][] board, int r, int c) {
        
        //print(board);
        
        //base case that is kind of useless
        
        if (r==size-1&&c==size-1) {
            return true;
        }
        
        
        //System.out.println("q");
        //find next empty space and check if there are no left
        int a=-2;
        int b=-2;
        boolean done=false;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j]==0&&done==false&&(i!=r||j!=c)) {
                    a=i;
                    b=j;
                    
                    done=true;
                }
                
            }
        }
        //reall base case
        if (a==-2){
            
            temp=board;
            if (count>0){
                
                return true;
            }
            count++;

            
            //return true;
        }
        
        
        
        //System.out.println(""+a+b);
        //put all possible values in each space that are legal and call them recursively

        for (int i=1; i<10; i++) {
                //System.out.println(""+r+c+i);
               // if (moveIsGood)
            int[][] copy=copy(board);

            if (moveIsGood(board, r, c, i)) {
                
                copy[r][c] = i;
                
                
                
                //System.out.println("as"+i);
                cellSolve(copy, a, b);
                
                //if (!(cellSolve(copy,a, b))){
                  //copy[r][c] = 0;
                
                //}
            }
        }
        return false;
    }
    
    
    private static void helperFunction(int[][] board) {
        
        //call cellSolve on next empty cell
        int a=0;
        int b=0;
        if (board[a][b]!=0) {
        toly_loope2:
            for (int i=0; i<size; i++) {
                for (int j=0; j<size; j++) {
                    if (board[i][j]==0) {
                        a=i;
                        b=j;
                        
                        break toly_loope2;
                    }
                }
            }
        }
        
        cellSolve(board, a, b);
        //print(temp);
        board=copy(temp);
    }
    
    
    private static boolean moveIsGood(int[][] board, int x, int y, int value) {
        
        //check if there is something there
        if (board[x][y]!=0) {
            
            return false;
        }
        //loop through board
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                
                
                if (Math.abs(y-j)<3&&Math.abs(x-i)<3&&value==board[i][j]) {
                    //System.out.println(
                    //see if it is in the board
                    if (y/3!=j/3) {
                    }
                    else if (x/3!=i/3) {
                    
                    }
                    else {
                       // System.out.print("asdf");

                        return false;
                    }
                }
                
                if (y==j&&value==board[i][j]) {
                    //check columns
                    if (x==1&&y==2){
                        //System.out.println("asdf");
                    }
                    return false;
                }
                if (x==i&&value==board[i][j]) {
                    //check rows
                   
                    return false;
                }
            }
        }
        
        
        return true;
    }
    
    public static void readpuzzle(int[][] board) {
        Scanner s = new Scanner(System.in);
        for (int i=0; i<size; i++) {
            String line = s.nextLine();
            for (int j=0; j<size; j++) {
                char c = line.charAt(j);
                if (c!=' ') {
                    board[i][j]=Integer.valueOf(c+"");
                }
            }
        }
    }
    
    
    
    public static int[][] copy(int[][] input) {
        
        int[][] output = new int[input[0].length][input[0].length];
        for (int i=0; i<input[0].length; i++) {
            for (int j=0; j<input[0].length; j++) {
                output[i][j]=input[i][j];
            }
        }
        return output;
    }
    
    
    public static void print(int[][] input) {
        for (int i=0; i<input[0].length; i++) {
            for (int j=0; j<input[0].length; j++) {
                System.out.print(input[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

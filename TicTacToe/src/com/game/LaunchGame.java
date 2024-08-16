package com.game;

import java.util.Random;
import java.util.Scanner;
 class TicTacToe{
	static char[][] board;
	
	public TicTacToe() {
		board=new char[3][3];
		initBoard();
	}
	
	 void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
	}
	static void displayBoard() {
		System.out.println("---------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j] + " |  ");
			}
			System.out.println();
			System.out.println("---------------");
	}
		
}
	static void placeMark(int row,int col,char mark) {
		if(row>=0 && row<=2 && col>=0 && col<=2) {
				board[row][col]=mark;
		}else {
			System.out.println("invalid position");
		}
	}
	
	static boolean checkColWin() {
		for(int j=0;j<=2;j++) {
			if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
				return true;
			}
		}
	return false;
	}
	static boolean checkRowWin() {
		for(int i=0;i<=2;i++) {
			if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
				return true;
			}
		}
	return false;
	}
	
	static boolean checkDiagnlWin() {
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
			return true;
		}
	return false;
	}
	
	static boolean gamedraw() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}return true;
		
	}
}
	
 abstract class play{
	 String name;
	 char mark;
	 abstract void makeMove();
	  boolean isValid(int row, int col) {
		  if(row>=0 && row<=2 && col>=0 && col<=2) {  
			if(TicTacToe.board[row][col]==' ') {
				return true;
           }
		  }
		  return false;
}
	
 }

class HumanPlay extends play
{
	public HumanPlay(String name, char mark) {

		this.name = name;
		this.mark = mark;
	}

	@Override
	void makeMove() {
		int row,col;
		do {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the row and col ");
		row=sc.nextInt();
		col=sc.nextInt();
		}while(!isValid(row,col));
		TicTacToe.placeMark(row,col,mark);// TODO Auto-generated method stub

    }
}

class RandomPlay extends play{
	public RandomPlay(String name, char mark) {
	
		this.name = name;
		this.mark = mark;
	}

@Override
void makeMove() {
	int row,col;
	do {
	Random r=new Random();
	row=r.nextInt(3);
	col=r.nextInt(3);
	System.out.println("enter the row and col ");
	}while(!isValid(row,col));
	TicTacToe.placeMark(row,col,mark);
	
}
}



public class LaunchGame {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	TicTacToe t=new TicTacToe();
	HumanPlay p1=new HumanPlay("pavan", 'X');
//	HumanPlay p2=new HumanPlay("pavan", 'X');
	RandomPlay p2=new RandomPlay("seenu", 'O');
	play cp;
	cp=p1;
	
	while(true){
		System.out.println(cp.name+ " turns");
		cp.makeMove();
		TicTacToe.displayBoard();
		if(TicTacToe.checkColWin() ||TicTacToe.checkDiagnlWin() || TicTacToe.checkRowWin()) {
			System.out.println(cp.name+ " won");
			break;
		}
		else if(TicTacToe.gamedraw()) {
			System.out.println("game is draw");
		}
		else {
			if(cp==p1) {
				cp=p2;
			}
			else {
				cp=p1;
			}
	}
	}
	}
}
import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int theSize = 5;
int dieX = 0;
int dieY = theSize/2;
int total = 0;

Die[] diceArray = new Die[17419];
int diceCount = 0;


boolean drawStart = false;
public class Die{
	int diceSize;
	int side;
	int xPos;
	int yPos;
	Die(int side, int xPos, int yPos){
		this.diceSize = 5;
		this.side = side;
		this.xPos = xPos;
		this.yPos = yPos;
	}
}
public void draw(){
	if(total == 0){
		textSize(30);
		fill(255,255,255);
		text("Click to spawn "+ diceArray.length+ " dice!", width/3, height/2);	
	}
}

public void setup() {
  size(995, 635);
  background(0,0,0);
  frameRate(500000);
  noStroke();
 
}


public void mousePressed() {
	background(0,0,0);
	diceCount = 0;
	total = 0;
	int dieX = -theSize/2;
	int dieY = theSize/2;
	for(int i = 0; i<diceArray.length-1; i++){
		if(dieX + theSize < 990){
			dieX +=  theSize + 1;
		} else {
			dieX =  -theSize/2;
			dieY += theSize + 1;
		}
		diceArray[diceCount] =  new Die((int) (Math.random() * 6 + 1), dieX, dieY);
		diceCount++;
	}
	drawDice();
	drawText();
}

public void drawDice(){
	for(int i = 0; i<diceArray.length-1; i++){
		fill(255,255,255);
		rectMode(CENTER);
		rect(diceArray[i].xPos, diceArray[i].yPos, diceArray[i].diceSize, diceArray[i].diceSize);
		total += diceArray[i].side;
		fill(0xff000000);
		if (diceArray[i].side == 1 || diceArray[i].side == 3 || diceArray[i].side == 5){
			rect(diceArray[i].xPos, diceArray[i].yPos, 1, 1);
		}
		if (diceArray[i].side == 2 || diceArray[i].side == 3 || diceArray[i].side == 4 || diceArray[i].side == 5 || diceArray[i].side == 6) {
			rect(diceArray[i].xPos - diceArray[i].diceSize/4, diceArray[i].yPos - diceArray[i].diceSize/4, 1, 1);
			rect(diceArray[i].xPos + diceArray[i].diceSize/4, diceArray[i].yPos + diceArray[i].diceSize/4, 1, 1);
		}
		if (diceArray[i].side == 4 || diceArray[i].side == 5 || diceArray[i].side == 6) {
			rect(diceArray[i].xPos - diceArray[i].diceSize/4, diceArray[i].yPos + diceArray[i].diceSize/4, 1, 1);
			rect(diceArray[i].xPos + diceArray[i].diceSize/4, diceArray[i].yPos - diceArray[i].diceSize/4, 1, 1);
		}
		if (diceArray[i].side == 6) {
			rect(diceArray[i].xPos, diceArray[i].yPos - diceArray[i].diceSize/4, 1, 1);
			rect(diceArray[i].xPos, diceArray[i].yPos + diceArray[i].diceSize/4, 1, 1);
		} 
	}
}

public void drawText(){

	textSize(10);
	fill(255,255,255);
	text("Sum: " +  total, width*11.2f/12, height);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

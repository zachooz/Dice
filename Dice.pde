int theSize = 4;
int dieX = 0;
int dieY = theSize/2;
int total = 0;

Die[] diceArray = new Die[38937];
int diceCount = 0;


boolean drawStart = false;
public class Die{
	int diceSize;
	int side;
	int xPos;
	int yPos;
	Die(int side, int xPos, int yPos){
		this.diceSize = 4;
		this.side = side;
		this.xPos = xPos;
		this.yPos = yPos;
	}
}
void draw(){
	if(total == 0){
		textSize(30);
		fill(255,255,255);
		text("Click to spawn " + diceArray.length +" dice!", width/3, height/2);	
	}
}

void setup() {
  size(990, 630);
  background(0,0,0);
  frameRate(500000);
  noStroke();
 
}


void mousePressed() {
	background(0,0,0);
	diceCount = 0;
	total = 0;
	int dieX = -theSize/2;
	int dieY = theSize/2;
	for(int i = 0; i<diceArray.length; i++){
		if(dieX + theSize < 990){
			dieX +=  theSize;
		} else {
			dieX =  -theSize/2;
			dieY += theSize;
		}
		diceArray[diceCount] =  new Die((int) (Math.random() * 6 + 1), dieX, dieY);
		diceCount++;
	}
	drawDice();
	drawText();
}

void drawDice(){
	for(int i = 0; i<diceArray.length-1; i++){
		fill((int)(Math.random()*40+100),(int)(Math.random()*40+100),(int)(Math.random()*40+100));
		rectMode(CENTER);
		rect(diceArray[i].xPos, diceArray[i].yPos, diceArray[i].diceSize, diceArray[i].diceSize);
		total += diceArray[i].side;
		fill(#000000);
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

void drawText(){

	textSize(10);
	fill(255,255,255);
	text("Total: " + total, width*10/12, height);
	text("DicenNum: " +  diceArray.length, width*10.8/12, height);
}

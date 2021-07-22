import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static void start(){
        char[][] field = initializeField();

        drawField(field);

        while (true){
            doPlayerMove(field);
            if (isGameOver(field,'X',4)) break;
            doAIMove(field);
            if (isGameOver(field,'O',4)) break;
        }
    }

    static char[][] initializeField(){
        return new char[][]{
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'}

        };
    }

    static void drawField(char[][] field){
        for (int i =0;i<field.length;i++) {
            for (int j=0;j<field.length;j++){
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    static void doPlayerMove(char[][] field){
        int h;
        int v;
        System.out.println("Your move!");
        do {
            h = getCoordinate(field, 'h');
            v = getCoordinate(field, 'v');
        }
        while (isNotEmptyCell(field,h,v));
        field[h][v] = 'X';
        drawField(field);
    }
    static void doAIMove(char[][] field){
        int h;
        int v;
        Random random = new Random();
        do{
            h= random.nextInt(field.length);
            v = random.nextInt(field.length);
        }
        while (isNotEmptyCell(field,h,v));
        field[h][v] = 'O';
        drawField(field);
    }
    static int getCoordinate(char[][]field, char coordinateSymbol){
        Scanner scanner = new Scanner(System.in);
        int coordinate;
        do {
            System.out.printf("Enter %s-coordinate",coordinateSymbol);
            coordinate=scanner.nextInt()-1;
        }
        while (coordinate<0&&coordinate>field.length);
        return coordinate;
    }
    static boolean isNotEmptyCell(char[][]field,int h,int v){
        return !isEmptyCell(field,h,v);
    }
    static boolean isEmptyCell(char[][]field,int h,int v){
        return field[h][v]=='-';
    }
    static boolean isGameOver(char[][] field,char symbol, int seriaForWin){
        if (isWin(field,symbol,seriaForWin)||isDraw(field)) return true;
        return false;
    }
    static boolean isWin(char[][] field,char symbol,int seriaForWin){
        int seria = 0;
        //horizontal check
        for (int i = 0;i<field.length;i++){
            seria = 0;
            for (int j=0;j<field.length;j++){
                if (field[i][j] == symbol) seria++; else seria=0;
                if (checkSeria(seria,seriaForWin,symbol)) return true;
            }
        }
        //vertical check
        for (int i = 0;i<field.length;i++){
            seria=0;
            for (int j=0;j<field.length;j++){
                if (field[j][i] == symbol) seria++; else seria=0;
                if (checkSeria(seria,seriaForWin,symbol)) return true;
            }
        }
        //diagonal check
        seria=0;
        for (int i=0;i<field.length;i++){
            if (field[i][i] == symbol||field[field.length-i-1][i]==symbol) seria++; else seria=0;
            if (checkSeria(seria,seriaForWin,symbol)) return true;
        }
        return false;
    }
    static boolean checkSeria(int seria,int seriaForWin,char symbol){
        if (seria==seriaForWin){
            System.out.printf("Player ''%s'' win!",symbol);
            return true;
        }
        return false;
    }
    static boolean isDraw(char[][] field){
        for (int h=0;h<field.length;h++){
            for (int v=0;v<field.length;v++){
                if (isEmptyCell(field,h,v))  return false;
            }
        }
        System.out.println("Draw! Game over.");
        return true;
    }
}

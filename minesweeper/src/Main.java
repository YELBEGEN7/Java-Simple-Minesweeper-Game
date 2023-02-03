import java.util.Scanner;

public class Main {
    static int[][] mine_location = {{3, 2}, {2, 4}, {5, 4}, {4, 5}};
    static String [][] table0={{" "," "," "," "," "},{" "," "," "," "," ",},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
    static String table1="  1  2  3  4  5";
    static String table2=" ---------------";
    static String table3="-";
    static int score;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        score=0;
        draw(score);
        for (int i=0;i<21;i++){
            System.out.println("Line=");
            int line = scan.nextInt();
            System.out.println("column=");
            int column = scan.nextInt();
            boolean minedetected=minedetect(line,column);
            if(minedetected){
                table0[column-1][line-1]="X";
                System.out.println("BOOM");
                i=21;
            }
            else{
                System.out.println(Value(line,column));
                table0[column-1][line-1]= Integer.toString(Value(line,column));
                score++;
            }

            draw(score);
        }

    }

    public static void draw(int score) {
        System.out.println("Score="+score);
        System.out.println(table1);
        for(int i=0;i<5;i++){
            System.out.println(table2);
            System.out.print(i+1);
            for(int j=0;j<5;j++){
                System.out.print(table3+table0[i][j]+table3);
            }
            System.out.println();
        }
        System.out.println(table2);
    }

    public static boolean minedetect(int user_line, int user_column) {

        boolean detect = false;
        for (int i = 0; i < 4; i++) {
            if(user_line==mine_location[i][0]){
                if(user_column==mine_location[i][1]){
                    detect=true;
                    i=4;
                }
                else
                    detect=false;
            }
            else
                detect=false;
        }
        return detect;
    }

    public static int Value(int user_line, int user_column) {
        int value=0;
        double k;
        for (int i = 0; i < 4; i++) {
            int j = ((user_line - mine_location[i][0]) * (user_line - mine_location[i][0]) + (user_column - mine_location[i][1]) * (user_column - mine_location[i][1]));
            k = Math.sqrt(j);
            if(k<0){
                k=k*(-1);
            }
            if(k<2){
                value++;
            }
        }
        return value;
    }
}
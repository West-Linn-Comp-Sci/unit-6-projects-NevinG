import java.util.Scanner;

class FrequencyChart
{
    public static void main(String[] args) {
        int[] answers = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers from 1-100, and type Stop when done");

        while(true)
        {
            String input = scanner.nextLine();
            if(input.equals("stop"))
            break;
            answers[(Integer.parseInt(input)-1)/10]++;
        }
        for(int i = 0; i < answers.length; i++)
        {
            System.out.print((i)*10 + 1 + "-"+ (i+1)*10+":" );
            for(int j =0; j < answers[i]; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
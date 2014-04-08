package CodeForces;
import java.io.*;
import java.util.*;

public class Temp
{
    private static int m;
    private static int answer;

    public static void main(String[] args) throws IOException
    {
        init();
        run();
        output();
        System.exit(0);
    }

    private static void run()
    {
        int enumeration = m + 1;
        while (!isRunroundNumber(enumeration))
        {
            enumeration++;
        }
        answer = enumeration;
    }

    private static boolean isRunroundNumber(int value)
    {
        int length = Integer.toString(value).length();
        int[] digits = new int[length];

        int index = length;
        while (value > 0)
        {
            index--;
            digits[index] = value % 10;
            value = value / 10;
        }

        boolean[] repeated = new boolean[10];
        for (int i = 0; i < length; i++)
        {
            if (repeated[digits[i]])
            {
                return false;
            }
            else
            {
                repeated[digits[i]] = true;
            }
        }

        int pointer = 0;
        boolean[] isTouched = new boolean[length];
        for (int i = 0; i < length; i++)
        {
            pointer = (pointer + digits[pointer]) % length;
            if (isTouched[pointer])
            {
                return false;
            }
            else
            {
                isTouched[pointer] = true;
            }
        }
        return true;
    }

    private static void init() throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("C:/ride.in"));
        m = Integer.parseInt(f.readLine());
        f.close();
    }

    private static void output() throws IOException
    {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
        System.out.println(answer);
        out.close();
    }
}
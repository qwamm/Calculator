package calculator;

import java.util.*;
import java.lang.*;

public class main
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		in.close();
		System.out.println("Result: " + calculate(str));
	}

	public static Double calculate(String str)
	{
		Double res = 0.0;
		String num = "";
		Character operation = Character.MIN_VALUE;

		int ascii_num = (int)str.charAt(0);

                        if ((ascii_num < 49 || ascii_num > 57) && ascii_num != 40 && ascii_num != 45)
                        {
                                return Double.NaN;
                        }

		for (int i = 0; i < str.length();)
		{
                        ascii_num = (int)str.charAt(i);

			if (ascii_num >= 49 && ascii_num <=57 || ascii_num == 46 || ascii_num == 45)
			{
				num += String.valueOf(str.charAt(i));
			}
			else if (ascii_num == 45 || ascii_num == 43 || ascii_num == 42 || ascii_num == 47)
			{
				if (operation == Character.MIN_VALUE)
				{
					res = Double.valueOf(num);
					num = "";
				}
				operation = (char)ascii_num;
				if (num != "")
				{
                                if (operation == '+')
                                {
                                        res += Double.valueOf(num);
                                }
				else if (operation == '-')
				{
					res -= Double.valueOf(num);
				}
				else if (operation == '*')
				{
					res *= Double.valueOf(num);
				}
				else if (operation == '/')
				{
					res /= Double.valueOf(num);
				}
				}
				num = "";
				//System.out.println(operation);
			}

			if (i == str.length() - 1)
			{
                                if (num != "")
                                {
                                if (operation == '+')
                                {
                                        res += Double.valueOf(num);
                                }
                                else if (operation == '-')
                                {
                                        res -= Double.valueOf(num);
                                }
                                else if (operation == '*')
                                {
                                        res *= Double.valueOf(num);
                                }
                                else if (operation == '/')
                                {
                                        res /= Double.valueOf(num);
                                }
                                }
			}

			i++;
		}
		return res;
	}
}

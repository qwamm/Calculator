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

	public static void string_parse (String str, int ascii_num, ArrayList<Double> num_list, ArrayList<Character> char_list,
	ArrayList<Integer> first_index_list	)
	{
		String num = "";
		for (int i = 0; i < str.length();)
		{
                       	while ( i < str.length() && ascii_num >= 49 && ascii_num <=57 || ascii_num == 46 ||
				 ascii_num == 45)
                        {
                                num += String.valueOf(str.charAt(i));
				i++;
								if (i < str.length())
										ascii_num = (int)str.charAt(i);
                        }

			num_list.add(Double.valueOf(num));
			num ="";
			if (i < str.length() && (ascii_num == 45 || ascii_num == 43 || ascii_num == 42 ||
			 ascii_num == 47))
			{
				char_list.add(Character.valueOf((char)ascii_num));
				first_index_list.add(Integer.valueOf(num_list.size()-1));
				i++;
				ascii_num = (int)str.charAt(i);
			}
		}
	}

	public static Double calculate(String str)
	{
		Double res = 0.0, temp;
		Character operation = Character.MIN_VALUE;

		int ascii_num = (int)str.charAt(0);

                if ((ascii_num < 49 || ascii_num > 57) && ascii_num != 40 && ascii_num != 45)
                {
                                return Double.NaN;
                }

		ArrayList<Double> num_list = new ArrayList<>();
		ArrayList<Character> char_list = new ArrayList<>();
		ArrayList<Integer> first_index_list = new ArrayList<>();

		string_parse(str, ascii_num, num_list, char_list, first_index_list);

		for (int i = 0; i < char_list.size();)
		{
			int ind = (int)first_index_list.get(i);
			if (char_list.get(i) == '*')
			{
				res = Double.valueOf(num_list.get(ind)) * Double.valueOf(num_list.get(ind + 1));
				num_list.remove(ind);
				num_list.remove(ind);
				num_list.add(ind, res);
				char_list.remove(i);
			}
			else if (char_list.get(i) == '/')
			{
				res = Double.valueOf(num_list.get(ind)) / Double.valueOf(num_list.get(ind + 1));
				num_list.remove(ind);
				num_list.remove(ind);
				num_list.add(ind, res);
				char_list.remove(i);
			}
			else
			{
				i++;
			}
		}

		for (int i = 0; i < char_list.size();)
		{
			int ind = (int)first_index_list.get(i);
			if (char_list.get(i) == '+')
			{
				res = Double.valueOf(num_list.get(ind)) + Double.valueOf(num_list.get(ind + 1));
				num_list.remove(ind);
				num_list.remove(ind);
				num_list.add(ind, res);
				char_list.remove(i);
			}
			else
			{
				i++;
			}
		}
		return res;
	}
}

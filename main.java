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
		Double res = 0.0, temp;
		String num = "";
		Character operation = Character.MIN_VALUE;

		int ascii_num = (int)str.charAt(0);

                if ((ascii_num < 49 || ascii_num > 57) && ascii_num != 40 && ascii_num != 45)
                {
                                return Double.NaN;
                }

		ArrayList<Double> num_list = new ArrayList<>();
		ArrayList<Character> char_list = new ArrayList<>();

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
                        //System.out.println(num);
			num_list.add(Double.valueOf(num));
			num="";
			if (i < str.length() && (ascii_num == 45 || ascii_num == 43 || ascii_num == 42 ||
			 ascii_num == 47))
			{
				char_list.add(Character.valueOf((char)ascii_num));
				i++;
				ascii_num = (int)str.charAt(i);
			}
		}

		for (int i = 0; i < char_list.size();)
		{
			if (char_list.get(i) == '*')
			{
				//System.out.println(num_list.size());
				int ind = 2*i + 1 >= num_list.size() ? 2*i-1 : 2*i;
				res = Double.valueOf(num_list.get(ind)) * Double.valueOf(num_list.get(ind+1));
							num_list.remove(ind);
							num_list.remove(ind);
							num_list.add(ind, res);
							char_list.remove(i);
			}
			else if (char_list.get(i) == '/')
			{
				res = Double.valueOf(num_list.get(2*i)) / Double.valueOf(num_list.get(2*i + 1));
							num_list.remove(2*i);
							num_list.remove(2*i);
							num_list.add(2*i, res);
							char_list.remove(i);
			}
			else
			{
				i++;
			}
		}


		for (int i = 0; i < char_list.size();)
		{
			if (char_list.get(i) == '+')
			{
				res = Double.valueOf(num_list.get(2*i)) + Double.valueOf(num_list.get(2*i + 1));
				num_list.remove(2*i);
				num_list.remove(2*i);
				num_list.add(2*i, res);
				char_list.remove(i);
			}
			else
			{
				i++;
			}
			/*else if (char_list.get(i) == '/')
			{
				res = Double.valueOf(num_list.get(2*i)) / Double.valueOf(num_list.get(2*i + 1));
			}*/
		}

		/*for (int i = 0; i < str.length();)
		//{
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
				operation = (char)ascii_num;
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
		}*/
		return res;
	}
}

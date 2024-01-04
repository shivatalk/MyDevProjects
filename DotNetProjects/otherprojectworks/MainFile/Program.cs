using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CrudOpearations;

namespace MainFile
{
    class Program
    {
		static void Main(string[] args)
		{

			CustomerCrudOperation obj = new CustomerCrudOperation();

			while (true)
			{
				int choice = 0;
				Console.Write(" \nEnter Your Choice : ");
				Console.Write(" \n1. Add New Customer: ");
				Console.Write(" \n2. Search Customer by Id : ");
				Console.Write(" \n3. Remove Customer by Id : ");
				Console.Write(" \n4. List of All Agent : ");
				Console.Write(" \n5. Exit : \n");

				choice = Convert.ToInt32(Console.ReadLine());

				switch (choice)
				{
					case 1: obj.AddCustomer(); break;

					case 2: obj.SearchCustomerById(); break;

					case 3: obj.RemoveCustomerById(); break;

					case 4: obj.PrintCustomerList(); break;

					case 5: Environment.Exit(0); break;

					default: Console.WriteLine("\nInvalid Choice...."); break;
				}
			}
		}

	}
}

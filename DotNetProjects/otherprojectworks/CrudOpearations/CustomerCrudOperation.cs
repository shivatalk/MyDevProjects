using System;
using System.Text;
using System.Collections.Generic;
using CustomerEntity;
using ExceptionsDll;
using ValidationsDll;

namespace CrudOpearations
{
    public class CustomerCrudOperation
    {

		static List<Customer> customerlist;

		static CustomerCrudOperation()
		{
			customerlist = new List<Customer>();
		}

		public void AddCustomer()
		{

			Customer dummy = new Customer();

			while (true)
			{
				try
				{
					Console.WriteLine("Enter Customer Id :");
					dummy.customerId = Convert.ToInt32(Console.ReadLine());
					Validations.ValidateCustomerId(dummy.customerId);
					break;
				}
				catch (InvalidCustomerIdException e)
				{
					Console.WriteLine(e.Message);
					Console.WriteLine("Try Again..\n");

				}
			}


			while (true)
			{
				try
				{
					Console.WriteLine("Enter Customer Name :");
					dummy.customerName = Console.ReadLine();
					Validations.ValidateCustomerName(dummy.customerName);
					break;
				}
				catch (InvalidCustomerNameException e)
				{
					Console.WriteLine(e.Message);
					Console.WriteLine("Try Again..\n");

				}
			}

			while (true)
			{
				try
				{
					Console.WriteLine("Enter Order Item :");
					dummy.orderItem = Convert.ToDouble(Console.ReadLine());
					Validations.ValidateOrderItem(dummy.orderItem);
					break;
				}
				catch (InvalidOrderItemException e)
				{
					Console.WriteLine(e.Message);
					Console.WriteLine("Try Again..\n");

				}
			}

			while (true)
			{
				try
				{
					Console.WriteLine("Enter Quantity :");
					dummy.quantity = Convert.ToInt32(Console.ReadLine());
					Validations.ValidateItemQuantity(dummy.quantity);
					break;
				}
				catch (InvalidQuantityException e)
				{
					Console.WriteLine(e.Message);
					Console.WriteLine("Try Again..\n");

				}
			}

			while (true)
			{
				try
				{
					Console.WriteLine("Enter price  :");
					dummy.price = Convert.ToDouble(Console.ReadLine());
					Validations.ValidateItemPrice(dummy.price);
					break;
				}
				catch (InvalidPriceException e)
				{
					Console.WriteLine(e.Message);
					Console.WriteLine("Try Again..\n");

				}
			}


			dummy.billAmount = (dummy.quantity) * (dummy.price);

			customerlist.Add(dummy);
			Console.WriteLine(" Customer Added Succefully...");

		}

		public void UpdateCustomer()
		{


		}

		public void RemoveCustomerById()
		{
			Console.WriteLine("Enter Customer Id to Remove :");
			int id = Convert.ToInt32(Console.ReadLine());
			Customer temp = null;

			if (id > 0)
			{
				foreach (Customer c in customerlist)
				{
					if (c.customerId == id)
					{
						temp = c;
						break;
					}
				}


				if (temp == null)
				{
					Console.WriteLine(" Customer with Id {0} is Not Available ", id);
				}
				else
				{
					customerlist.Remove(temp);
					Console.WriteLine(" Customer with Id {0} Removed Succesfully... ", id);
				}

			}
			else
			{
				Console.WriteLine("Enter Valid Customer Id :");
			}

		}

		public void SearchCustomerById()
		{
			Console.WriteLine("Enter Customer Id to Search :");
			int id = Convert.ToInt32(Console.ReadLine());
			Customer temp = null;

			if (id > 0)
			{
				foreach (Customer c in customerlist)
				{
					if (c.customerId == id)
					{
						c.Show();
						temp = c;
						break;
					}
				}


				if (temp == null)
				{
					Console.WriteLine(" Customer with Id {0} is Not Available ", id);
				}

			}
			else
			{
				Console.WriteLine("Enter Valid Customer Id :");
			}

		}

		public void PrintCustomerList()
		{
			if (customerlist.Count == 0)
				Console.WriteLine("No Customer Data Available..");
			else
			{

				foreach (Customer c in customerlist)
				{
					c.Show();
				}
			}
		}


	}
}

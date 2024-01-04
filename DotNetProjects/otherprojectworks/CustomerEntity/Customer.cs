using System;

namespace CustomerEntity
{
    public class Customer
    {

		public int customerId = 0;
		public string customerName = "";
		public double orderItem = 0.0;
		public int quantity = 0;
		public double billAmount = 0;
		public double price = 0;


		public void Show()
		{
			Console.WriteLine("\nCustomer Id  :{0}  Customer Name : {1}  Order Item : {2}  Quanity :{3}  Bill Amount : {4}  Price : {5}" +
				" ", this.customerId, this.customerName, this.orderItem, this.quantity, this.billAmount, this.price);
		}

	}
}

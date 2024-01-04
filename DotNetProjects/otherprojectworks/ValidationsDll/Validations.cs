using System;
using ExceptionsDll;

namespace ValidationsDll
{
    public class Validations
    {


		public static void ValidateCustomerId(int id)
		{

			if (id <= 0)
				throw new InvalidCustomerIdException("Id Cannot Be Negative....");
		}


		public static void ValidateCustomerName(string Name)
		{
			if (Name.Length < 5)
			{
				throw new InvalidCustomerNameException("Name Should Contain Atleast 5 Character....");
			}

		}


		public static void ValidateOrderItem(double order_item)
		{
			if (order_item < 0)
			{
				throw new InvalidOrderItemException("Quantity Cannot be Negative \n ");
			}
		}


		public static void ValidateItemQuantity(int quantity)
		{

			if (quantity < 0)
				throw new InvalidQuantityException("Quantity cannot be Negative...");
		}


		public static void ValidateItemPrice(double price)
		{
			if (price < 0)
				throw new InvalidPriceException("Price Cannot Be Negative ..");
		}
	

}
}

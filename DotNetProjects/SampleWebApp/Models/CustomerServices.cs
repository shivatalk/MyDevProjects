using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CustomerModuleProject.Models
{
    public class CustomerServices
    {

        public static List<Customer> customerlist;

        static CustomerServices()
        {
            customerlist = new List<Customer>();
            customerlist.Add(new Customer {CustomerId=1,CustomerName="Shivam",OrderId=1,OrderItem="Shirt",Quantity=4,Price=400,BillAmount=4*400 });
            customerlist.Add(new Customer { CustomerId = 2, CustomerName = "Vikash", OrderId = 2, OrderItem = "Oil", Quantity = 2, Price = 20, BillAmount = 2 * 20 });

        }

        public static List<Customer> GetAllCustomer()
        { 
            return customerlist;
        }

        public static Customer SearchCustomer(int customerId)
        {
            Customer find = null;

            if (customerlist.Count == 0)
                return find;
            else 
            {

                foreach (Customer cs in customerlist)
                {

                    if (cs.CustomerId == customerId)
                        find = cs;
                }

                return find;
            }

        }
    }
}
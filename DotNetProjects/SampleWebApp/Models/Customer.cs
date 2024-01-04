using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CustomerModuleProject.Models
{
    public class Customer
    {
        public int CustomerId { get; set; }

        public string CustomerName { get; set; }

        public int OrderId { get; set; }

        public string OrderItem { get; set; }

        public int Quantity { get; set; }

        public double Price { get; set; }

        public double BillAmount { get; set; }


    }
}
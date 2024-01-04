using System;
using System.Collections.Generic;
using System.Text;

namespace ExceptionsDll
{
    public class InvalidCustomerNameException:Exception
    {

        public InvalidCustomerNameException()
        { }

        public InvalidCustomerNameException(string name) : base(name)
        { }
    }
}

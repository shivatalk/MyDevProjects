using System;

namespace ExceptionsDll
{
    public class InvalidCustomerIdException:Exception
    {
        public InvalidCustomerIdException()
        {

        }

        public InvalidCustomerIdException(string name) : base(name)
        {

        }
    }



}

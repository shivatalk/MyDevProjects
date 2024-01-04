using System;
using System.Collections.Generic;
using System.Text;

namespace ExceptionsDll
{
   public class InvalidOrderItemException:Exception
    {
        public InvalidOrderItemException()
        { }

        public InvalidOrderItemException(string name) : base(name)
        { }

    }
}

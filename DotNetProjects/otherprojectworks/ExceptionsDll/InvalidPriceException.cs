using System;
using System.Collections.Generic;
using System.Text;

namespace ExceptionsDll
{
   public class InvalidPriceException:Exception
    {
        public InvalidPriceException()
        { }

        public InvalidPriceException(string name) : base(name)
        { }

    }
}

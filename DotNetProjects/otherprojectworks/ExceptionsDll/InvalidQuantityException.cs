using System;
using System.Collections.Generic;
using System.Text;

namespace ExceptionsDll
{
   public class InvalidQuantityException:Exception
    {
        public InvalidQuantityException()
        { }
        public InvalidQuantityException(string name) : base(name)
        { }
    }
}

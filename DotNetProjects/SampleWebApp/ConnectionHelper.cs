using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Configuration;
using System.Data.SqlClient;

namespace CustomerModuleProject
{
    public class ConnectionHelper
    {


        public static SqlConnection Connect()
        {
            string constring = ConfigurationManager.ConnectionStrings["employeesConnection"].ConnectionString;
            SqlConnection conn = new SqlConnection(constring);
            return conn;
        }

    }
}
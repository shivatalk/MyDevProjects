using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using CustomerModuleProject.Models;

namespace CustomerModuleProject
{
    public class EmployeeCRUD
    {

        public static Employee Search(int employeeId)
        {
            Employee emp = null;
            SqlCommand cmd = null;
            SqlConnection con = null;
            SqlDataReader reader = null;

            try
            {
                con = ConnectionHelper.Connect();
                con.Open();
                cmd = new SqlCommand("searchByemployeeid", con);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@EmployeeId", employeeId);
                reader = cmd.ExecuteReader();

            }
            catch (SqlException e)
            {
                System.Diagnostics.Debug.WriteLine(" SQL Exception Occured ::");
                return emp;
            }
          

            
            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    emp = new Employee();
                    emp.EmployeeId = Convert.ToInt32(reader[0]);
                    emp.Name = reader[1].ToString();
                    emp.DateOfBirth = Convert.ToDateTime(reader[2]);
                    emp.Gender = reader[3].ToString();
                    emp.Address = reader[4].ToString();
                    emp.MobileNo = Convert.ToInt64(reader[5]);
                    emp.DateOfJoining = Convert.ToDateTime(reader[6]);
                    emp.Designation = reader[7].ToString();
                    emp.Location = reader[8].ToString();
                    break;
                }
            }
            reader.Close();
            con.Close();

            return emp;

        }

        public static bool Create(Employee temp)
        {

            SqlConnection con = ConnectionHelper.Connect();
            con.Open();
            SqlCommand cmd = new SqlCommand("AddnewEmployee", con);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@Name", temp.Name);
            cmd.Parameters.AddWithValue("@DateOfBirth", temp.DateOfBirth);
            cmd.Parameters.AddWithValue("@Gender", temp.Gender);
            cmd.Parameters.AddWithValue("@Address", temp.Address);
            cmd.Parameters.AddWithValue("@MobileNo", temp.MobileNo);
            cmd.Parameters.AddWithValue("@DateOfJoining", temp.DateOfJoining);
            cmd.Parameters.AddWithValue("@Designation", temp.Designation);
            cmd.Parameters.AddWithValue("@Location", temp.Location);

            cmd.Parameters.Add("@result", SqlDbType.Int);
            cmd.Parameters["@result"].Direction = ParameterDirection.Output;

            cmd.ExecuteNonQuery();

            int res = Convert.ToInt32(cmd.Parameters["@result"].Value);

            if (res == 1)
            {
                con.Close();
                return true;
            }

            con.Close();
            return false;

        }

        public static bool Update(Employee updated)
        {
            SqlConnection con = ConnectionHelper.Connect();
            con.Open();
            SqlCommand cmd = new SqlCommand("UpdateByemployeeid", con);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@EmployeeId", updated.EmployeeId);
            cmd.Parameters.AddWithValue("@Name", updated.Name);
            cmd.Parameters.AddWithValue("@DateOfBirth", updated.DateOfBirth);
            cmd.Parameters.AddWithValue("@Gender", updated.Gender);
            cmd.Parameters.AddWithValue("@Address", updated.Address);
            cmd.Parameters.AddWithValue("@MobileNo", updated.MobileNo);
            cmd.Parameters.AddWithValue("@DateOfJoining", updated.DateOfJoining);
            cmd.Parameters.AddWithValue("@Designation", updated.Designation);
            cmd.Parameters.AddWithValue("@Location", updated.Location);
            cmd.Parameters.Add("@result", SqlDbType.Int);
            cmd.Parameters["@result"].Direction = ParameterDirection.Output;

            cmd.ExecuteNonQuery();

            int res = Convert.ToInt32(cmd.Parameters["@result"].Value);

            if (res == 1)
            {
                con.Close();
                return true;
            }

            con.Close();
            return false;
        }

        public static bool Delete(int EmployeeId)
        {
            SqlConnection con = ConnectionHelper.Connect();
            con.Open();
            SqlCommand cmd = new SqlCommand("DeleteEmployee", con);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@EmployeeId", EmployeeId);

            cmd.Parameters.Add("@result", SqlDbType.Int);
            cmd.Parameters["@result"].Direction = ParameterDirection.Output;

            cmd.ExecuteNonQuery();

            int res = Convert.ToInt32(cmd.Parameters["@result"].Value);

            con.Close();
            if (res == 1)
                return true;
            else
                return false;
        }


        public static List<Employee> GetAllEmployee()
        {
            SqlConnection con = ConnectionHelper.Connect();
            con.Open();
            SqlCommand cmd = new SqlCommand("SELECTALLEMPLOYEE", con);
            cmd.CommandType = CommandType.StoredProcedure;
            SqlDataReader reader = cmd.ExecuteReader();

            List<Employee>emplist=null;

            if (reader.HasRows)
            {
                emplist = new List<Employee>();

                while (reader.Read())
                {
                    Employee emp = new Employee();
                    // Console.WriteLine("{0}: {1:C}", reader[0], reader[1]);
                    emp.EmployeeId = Convert.ToInt32(reader[0]);
                    emp.Name = reader[1].ToString();
                    emp.DateOfBirth = Convert.ToDateTime(reader[2]);
                    emp.Gender = reader[3].ToString();
                    emp.Address = reader[4].ToString();
                    emp.MobileNo = Convert.ToInt64(reader[5]);
                    emp.DateOfJoining = Convert.ToDateTime(reader[6]);
                    emp.Designation = reader[7].ToString();
                    emp.Location = reader[8].ToString();

                    emplist.Add(emp);
                }
            }
            reader.Close();
            con.Close();

            return emplist;
        }



        public static List<Employee> GetAllEmployee(string sortBy)
        {
            SqlConnection con = ConnectionHelper.Connect();
            con.Open();
            SqlCommand cmd=null;
            if (sortBy == "Name")
            { cmd = new SqlCommand("orderByName", con); }
            else if (sortBy == "DateOfBirth")
            {
                cmd = new SqlCommand("orderByDateofbirth", con);
            }
            else if (sortBy == "DateofJoining")
            {
                cmd = new SqlCommand("orderByDateofjoining", con);
            }
            else
            {
                cmd = new SqlCommand("orderByempeeid", con);
            }

            cmd.CommandType = CommandType.StoredProcedure;
            SqlDataReader reader = cmd.ExecuteReader();

            List<Employee> emplist = null;

            if (reader.HasRows)
            {
                emplist = new List<Employee>();

                while (reader.Read())
                {
                    Employee emp = new Employee();
                    // Console.WriteLine("{0}: {1:C}", reader[0], reader[1]);
                    emp.EmployeeId = Convert.ToInt32(reader[0]);
                    emp.Name = reader[1].ToString();
                    emp.DateOfBirth = Convert.ToDateTime(reader[2]);
                    emp.Gender = reader[3].ToString();
                    emp.Address = reader[4].ToString();
                    emp.MobileNo = Convert.ToInt64(reader[5]);
                    emp.DateOfJoining = Convert.ToDateTime(reader[6]);
                    emp.Designation = reader[7].ToString();
                    emp.Location = reader[8].ToString();

                    emplist.Add(emp);
                }
            }
            reader.Close();
            con.Close();

            return emplist;
        }
    }
}
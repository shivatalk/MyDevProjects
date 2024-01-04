using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using PagedList;
using PagedList.Mvc;
using CustomerModuleProject.Models;

namespace CustomerModuleProject.Controllers
{
    public class CustomerController : Controller
    {
        // GET: Customer
        public ActionResult Index(int? pageNumber ,string sortBy, string FilterBy)
        {
            Console.WriteLine(sortBy);
            Console.WriteLine(FilterBy);
            IPagedList<Employee> list = EmployeeCRUD.GetAllEmployee(sortBy).ToPagedList<Employee>(pageNumber ??1,5);
            
            return View(list);
        }

        [HttpGet]
        public ActionResult Add()
        {
            return View();
        }

        [HttpPost]
        public ActionResult AddNew()
        {
           

             Employee emp = new Employee();

            try
            {
                emp.Name = Request.Form["employeename"].ToString();
                emp.DateOfBirth = Convert.ToDateTime(Request.Form["dateofbirth"]);
                emp.Gender = Request.Form["gender"].ToString();
                emp.Address = Request.Form["address"].ToString();
                emp.MobileNo = Convert.ToInt64(Request.Form["mobileno"]);
                emp.DateOfJoining = Convert.ToDateTime(Request.Form["dateofjoining"]);
                emp.Designation = Request.Form["designation"].ToString();
                emp.Location = Request.Form["location"].ToString();
            }
            catch (FormatException e)
            {
                return RedirectToAction("Add"); //form
            }
            catch (NullReferenceException e)
            {
                return RedirectToAction("Add"); //form
            }

            if (EmployeeCRUD.Create(emp))
                return RedirectToAction("Add"); //list
            else
                return RedirectToAction("Index","Home"); //welcome



        }


        public ActionResult Edit(int id)
        {

            Employee find = null;
            find = EmployeeCRUD.Search(id);

            if(find!=null)
                return View(find);

            return RedirectToAction("Index");


        }

        public ActionResult Delete(int id)
        {

            if(EmployeeCRUD.Delete(id))
                return RedirectToAction("Index");

            return RedirectToAction("Index","Home");


        }


        public ActionResult Update(int id)
        {

            Employee emp = new Employee();

            try
            { 
                emp.EmployeeId = id;
                emp.Name = Request.Form["employeename"].ToString();
                emp.DateOfBirth = Convert.ToDateTime(Request.Form["dateofbirth"]);
                emp.Gender = Request.Form["gender"].ToString();
                emp.Address = Request.Form["address"].ToString();
                emp.MobileNo = Convert.ToInt64(Request.Form["mobileno"]);
                emp.DateOfJoining = Convert.ToDateTime(Request.Form["dateofjoining"]);
                emp.Designation = Request.Form["designation"].ToString();
                emp.Location = Request.Form["location"].ToString();
            }
            catch (FormatException e)
            {
                return RedirectToAction("Index");
            }
            catch (NullReferenceException e)
            {
                return RedirectToAction("Index");
            }


            if (EmployeeCRUD.Update(emp))
                return RedirectToAction("Index");
            else
                return RedirectToAction("Index", "Home");

        }
    }
}
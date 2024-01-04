using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CustomerModuleProject.Models;

namespace CustomerModuleProject.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Search()
        {
            Employee find = null;
            try
            {
                int id = Convert.ToInt32(Request.Form["employeeid"]);
                find = EmployeeCRUD.Search(id);
                if (find != null)
                    return View(find);
                else
                {
                    find = new Employee();
                    find.EmployeeId = -1;
                    return View(find);
                }
            }
            catch (FormatException e)
            {

                System.Diagnostics.Debug.WriteLine("Exception Occured ::" + "Enter valid Emloyee Id");
            }

            return RedirectToAction("Index","Home");
        }
    }
}
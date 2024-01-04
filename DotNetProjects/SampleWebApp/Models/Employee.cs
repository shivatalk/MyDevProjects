using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace CustomerModuleProject.Models
{
    public class Employee
    {

        [Key]
        public int EmployeeId { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public DateTime DateOfBirth { get; set; }

        [Required]
        public string Gender { get; set; }

        [Required]
        public string Address { get; set; }

        [Required]
        public long MobileNo { get; set; }

        [Required]
        public DateTime DateOfJoining { get; set; }

        [Required]
        public string Designation { get; set; }

        [Required]
        public string Location { get; set; }


    }
}
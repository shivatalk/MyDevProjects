
    function Message() {
            document.getElementById("msg").style.display = "block";
            setTimeout(() => { document.getElementById("msg").style.display = "none"; }, 3000);
            }


    function Validate() {
            var txtbox = document.getElementById("employeeid");
            if (txtbox.value == "") {
                document.getElementById("idrequired").innerHTML = "Employee Id is Required";
                document.getElementById("searchbtn").disabled = true;
            }
            else {
                document.getElementById("idrequired").innerHTML = "";
                document.getElementById("searchbtn").disabled = false;
                }
    }


    function ValidateName() {
        var txtbox = document.getElementById("employeename");
        var msg = document.getElementById("employeenamerequired");
        if (txtbox.value == "") {msg.innerHTML = "Employee Name is Required"; return false; }
        else {msg.innerHTML = ""; return true; };

    }

    function ValidateDesignation() {
        var dropdown = document.getElementById("sel1");
        var msg = document.getElementById("sel1required");
        if (dropdown.value == "") {msg.innerHTML = "Designation is Required"; return false; }
        else {msg.innerHTML = ""; return true;};
    }

    function ValidateDateOfBirth() {
        var dob = document.getElementById("dateofbirth");
        var msg = document.getElementById("dateofbirthrequired");
        if (dob.value == "") {msg.innerHTML = "Date Of Birth is Required"; return false; }
        else {msg.innerHTML = ""; return true; };
    }

    function ValidateMobileNumber() {
        var mobno = document.getElementById("mobileno");
        var msg = document.getElementById("mobilenorequired");

        if (mobno.value == "") {msg.innerHTML = "Mobile No is Required"; return false; }
        else if (mobno.value.length != 10){msg.innerHTML = " Mobile No Should be 10 Digit"; return false;}
        else{msg.innerHTML = ""; return true; };
    }

    function ValidateDateofJoining() {
        var txtbox = document.getElementById("dateofjoining");
        var msg = document.getElementById("dateofjoiningrequired");
        if (txtbox.value == "") {msg.innerHTML = "Date Of Joining is Required"; return false;}
        else {msg.innerHTML = ""; return true; };
    }

    function ValidateLocation() {
        var txtbox = document.getElementById("location");
        var msg = document.getElementById("locationrequired");
        if (txtbox.value == "") {msg.innerHTML = "Location is Required"; return false; }
        else {msg.innerHTML = ""; return true; };
    }

    function ValidateAddress() {
        var txtbox = document.getElementById("address");
        var msg = document.getElementById("addressrequired");
        if (txtbox.value == "") {msg.innerHTML = "Address is Required"; return false}
        else {msg.innerHTML = ""; return true; };
    }


    function FormValidation() {

        var submitbtn = true;
        var msg = "";

        if (!ValidateName()) {submitbtn = false; msg = msg + "Name ,"; }
        if (!ValidateDesignation()) {submitbtn = false; msg = msg + "Designation ,"; }
        if (!ValidateDateOfBirth()) {submitbtn = false; msg = msg + "Date Of Birth ,";}
        if (!ValidateMobileNumber()) {submitbtn = false; msg = msg + "Mobile Number ,";}
        if (!ValidateDateofJoining()) {submitbtn = false; msg = msg + "Date Of Joining ,";}
        if (!ValidateLocation()) {submitbtn = false; msg = msg + "Location ,";}
        if (!ValidateAddress()) {submitbtn = false; msg = msg + "Address ,"; }

        msg = msg + "is Required";

        var invalidform = document.getElementById("invalidpopup");
        var successform = document.getElementById("successpopup");

        if (submitbtn) {
        successform.style.display = "block";
            invalidform.style.display = "none";
           // successform.innerHTML = "Record Inserted Successfully";

            setTimeout(() => {document.getElementById("successpopup").style.display = "none";},3000);
        }
        else {

        invalidform.style.display = "block";
            successform.style.display = "none";
            invalidform.innerHTML = msg;
            setTimeout(() => {document.getElementById("invalidpopup").style.display = "none"; }, 3000);
        }
       // alert(" form validation ");

        return submitbtn;
    }

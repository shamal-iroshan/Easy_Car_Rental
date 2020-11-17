$('#btnRegister').click(function () {
    let name = $("#txtName").val();
    let contact = $('#txtContactNo').val();
    let email = $('#txtEm').val();
    let Address = $('#txtAddress').val();
    let drivinglNo  = $('#txtDNo').val();
    let nicNo = $('#txtNicNo').val();
    let userName = $('#txtUserName').val();
    let password = $('#txtPassword').val();


    $.ajax({
        method: "POST",
        url: 'http://localhost:8080/carRental/api/v1/customer',
        data:JSON.stringify({
            "customerID":"",
            "name":name,
            "contact":contact,
            "email":email,
            "address":Address,
            "drivingLicenceNo":drivinglNo,
            "nicNo":nicNo,
            "userName":userName,
            "password":password
        }),
        dataType:'Json',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if(res.message=='Success'){
                alert('Registration Successful');
            }
        },
        error: function (ob, textStatus, error) {
            console.log("error from : " + ob + " " + textStatus + " " + error);
            if(res.message!='Success'){
                alert('Registration UnSuccessful! Try again');
            }
        }
    });
});

$('#btnLogin').click(function () {
    let userName = $('#txtUserName').val();
    let password = $('#txtPassword').val();

    $.ajax({
        method: "GET",
        url: 'http://localhost:8080/carRental/api/v1/customer',
        data:JSON.stringify({
            "userName":userName,
            "password":password
        }),
        dataType:'Json',
        contentType: "application/json; charset=utf-8",
        success:function (res) {
            console.log(res);
        }
    });
});

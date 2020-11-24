function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

$('#user-name').text(getCookie('user'));

$('#btnUploadNIC').click(function () {

    let formData = new FormData()

    $.ajax({
        url: 'http://localhost:8080/carRental/api/v1/car',
        type: 'POST',

    });
});

$('#sign-out').click(function () {
    if (confirm("Are you sure to Sign-out")) {
        window.location.replace("index.html");
    } else {

    }
});

$('#but_upload').click(function () {
    var frmdata = new FormData();
    frmdata.append('file[]', $('#fileNicF')[0].files[0]);
    frmdata.append('file[]', $('#fileNicB')[0].files[0]);
    frmdata.append('file[]', $('#fileLicF')[0].files[0]);
    frmdata.append('file[]', $('#fileLicB')[0].files[0]);
    frmdata.append('nic', $('#userNic').val());
    $.ajax({
        url: "http://localhost:8080/carRental/api/v1/customer/upload",
        type: "post",
        data: frmdata,
        contentType: false,
        processData: false,
        success: function (resp) {
            if (resp.state === true) {
                alert(resp.message);
                $('#fileUpload').css('display', 'none');
                $('#signupMessage').css('display', 'block');
            } else {
                alert(resp.message);
            }
        }
    });
});

$('#cusUpdateProfile').click(function () {
    let user = getCookie('user');
    let split = user.split("-");
    let userID = split[0];

    let userName = $('#txtCusUpdateUserName').val();
    let password = $('#txtCusUpdatePassword').val();

    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/carRental/api/v1/customer',
        headers: JSON.stringify({
            "customerID": "",
            "name": "retrt",
            "contact": "rtr",
            "email": "rt",
            "address": "wswws",
            "drivingLicenceNo": "iuiu",
            "nicNo": "we",
            "userName": "iloili",
            "password": "dfdt"
        }),
        dataType: 'Json',
        contentType: "application/json; charset=utf-8",
        success: function () {

        }
    });

});

$('#btnCusCarSearch').click(function () {

    let val = $('#cmbCusCarSelect').val();

    if (val == 'Choose...') {
        $('#tblCusCar').empty();

        $.ajax({
            method: 'GET',
            url: 'http://localhost:8080/carRental/api/v1/car',
            success: function (res) {
                loadTable(res);
            }
        });
    } else {
        console.log(val);
        $('#tblCusCar').empty();
        $.ajax({
            method: 'GET',
            url: 'http://localhost:8080/carRental/api/v1/car/type/'+val,
            success: function (res) {
                loadTable(res);
            }
        });

    }

});

function loadTable(res){
    let values = res.data;
    for (i in values) {
        let id = values[i].carID;
        let brand = values[i].brand;
        let noOfPassengers = values[i].numberOfPassengers;
        let transmission = values[i].transmissionType;
        let fuel = values[i].fuelType;
        let dailyRate = values[i].dailyRate;
        let monthlyRate = values[i].monthlyRate;
        let lossDamage = values[i].lossDamageWaiver;

        $('#tblCusCar').append(`<tr><th>${id}</th><td>${brand}</td><td>${noOfPassengers}</td><td>${transmission}</td><td>${fuel}</td><td>${dailyRate}</td><td>${monthlyRate}</td><td>${lossDamage}</td></tr>`);

        $('#tblCusCar > tr').off('click');

        $('#tblCusCar > tr').click(function () {
            let id = $($(this).children().get(0)).text();

            $('#txtCarID').val(id);

        });
    }
}

$('#cmbDriverNeed').click(function () {
    $('#txtDriverID').val($('#cmbDriverNeed').val());
});

$('#btnPlaceOrder').click(function () {

    let val = getCookie('user');
    let split = val.split('-');

    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();
    today = mm + '-' + dd + '-' + yyyy;

    let pickupDate = $('#pickupDate').val();
    let returnDate = $('#ReturnDate').val();
    let cusID = split[0];
    let carID = $('#txtCarID').val();
    let driver = $('#txtDriverID').val();

    $.ajax({
        method: 'POST',
        url: 'http://localhost:8080/carRental/api/v1/book',
        data: JSON.stringify({
            "bookingID": "",
            "date": today,
            "pickupDate": pickupDate,
            "status": "Ordered",
            "note": "normal",
            "returnDate": returnDate,
            "customerDto": cusID,
            "carDto": carID,
            "driverDto": 'D001'
        }),
        dataType: 'Json',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            console.log(res);
        }
    });
});


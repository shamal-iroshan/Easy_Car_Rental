function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

$('#user-name').text(getCookie('user'));

function loadAllCars(){
    $('#tblCar').empty();

    $.ajax({
        url: 'http://localhost:8080/carRental/api/v1/car',
        method: 'GET',
        success: function (res) {
            let values = res.data;
            for (i in values) {
                    let id = values[i].carID;
                    let registrationNo = values[i].registrationNumber;
                    let NoOfpassengers = values[i].numberOfPassengers;
                    let transmission = values[i].transmissionType;
                    let carType = values[i].type;

                    $('#tblCar').append(`<tr><th>${id}</th><td>${registrationNo}</td><td>${NoOfpassengers}</td><td>${transmission}</td><td>${carType}</td></tr>`);
            }
        }
    });
}


$('#txtCarSearch').keypress(function (e) {
    if(e.key == 'Enter'){
        let id = $('#txtCarSearch').val();
        console.log(id);
        if (id == ""){
            alert('Enter id and try again..!');
        }else{
            $('#tblCar').empty();

            $.ajax({
                method: 'GET',
                url:  'http://localhost:8080/carRental/api/v1/car/'+id,
                success: function (res) {
                    let values = res.data;

                    let id = values.carID;
                    let brand = values.Brand;
                    let carType = values.Type;
                    let NoOfpassengers = values.numberOfPassengers;
                    let transmission = values.transmissionType;
                    let fuelType = values.fuelType;
                    let priceForExtraKM = values.priceForExtraKM;
                    let registrationNo = values.registrationNumber;
                    let colour = values.colour;
                    let lossDamageWaiver = values.lossDamageWaiver;
                    let dailyRate = values.dailyRate;
                    let monthlyRate = values.monthlyRate;
                    let freeMillagePrice = values.freeMillagePrice;
                    let freeMillageDuration = values.freeMillageDuration;

                    $('#tblCar').append(`<tr><th>${id}</th><td>${registrationNo}</td><td>${NoOfpassengers}</td><td>${transmission}</td><td>${carType}</td></tr>`);

                    $('#txtBrand').val(brand);
                    $('#carType').val(carType);//
                    $('#txtNoPassengers').val(NoOfpassengers);
                    $('#transmissionType').val(transmission);//
                    $('#fuelType').val(fuelType);//
                    $('#txtPriceForExtraKM').val(priceForExtraKM);
                    $('#txtRegistrationNo').val(registrationNo);
                    $('#txtColour').val(colour);
                    $('#txtLossDamage').val(lossDamageWaiver);
                    $('#txtDailyRate').val(dailyRate);
                    $('#txtMonthlyRate').val(monthlyRate);
                    $('#txtPrice').val(freeMillagePrice);
                    $('#txtDuration').val(freeMillageDuration);
                }
            });
        }
    }
});


$('#btnSaveCar').click(function () {
    let carID = "";
    let Brand = $('#txtBrand').val();
    let Type = $('#carType').val();//
    let numberOfPassengers = $('#txtNoPassengers').val();
    let transmissionType = $('#transmissionType').val();//
    let fuelType = $('#fuelType').val();//
    let priceForExtraKM = $('#txtPriceForExtraKM').val();
    let registrationNumber = $('#txtRegistrationNo').val();
    let colour = $('#txtColour').val();
    let lossDamageWaiver = $('#txtLossDamage').val();
    let dailyRate = $('#txtDailyRate').val();
    let monthlyRate = $('#txtMonthlyRate').val();
    let freeMillagePrice = $('#txtPrice').val();
    let freeMillageDuration = $('#txtDuration').val();

    $.ajax({
        method: "POST",
        url: 'http://localhost:8080/carRental/api/v1/car',
        data: JSON.stringify({
            "carID": carID,
            "brand": Brand,
            "type": Type,
            "numberOfPassengers": numberOfPassengers,
            "transmissionType": transmissionType,
            "fuelType": fuelType,
            "priceForExtraKM": priceForExtraKM,
            "registrationNumber": registrationNumber,
            "colour": colour,
            "lossDamageWaiver": lossDamageWaiver,
            "dailyRate": dailyRate,
            "monthlyRate": monthlyRate,
            "freeMillagePrice": freeMillagePrice,
            "freeMillageDuration": freeMillageDuration
        }),
        dataType: 'Json',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.message == 'Success') {
                alert('Registration Successful');
            }
        },
        error: function (ob, textStatus, error) {
            console.log("error from : " + ob + " " + textStatus + " " + error);
            if (res.message != 'Success') {
                alert('Registration UnSuccessful! Try again');
            }
        }
    });

});

$('#btnUpdateCar').click(function () {

    let carID = $('#tblCar tr th').text();
    let Brand = $('#txtBrand').val();
    let Type = $('#carType').val();//
    let numberOfPassengers = $('#txtNoPassengers').val();
    let transmissionType = $('#transmissionType').val();//
    let fuelType = $('#fuelType').val();//
    let priceForExtraKM = $('#txtPriceForExtraKM').val();
    let registrationNumber = $('#txtRegistrationNo').val();
    let colour = $('#txtColour').val();
    let lossDamageWaiver = $('#txtLossDamage').val();
    let dailyRate = $('#txtDailyRate').val();
    let monthlyRate = $('#txtMonthlyRate').val();
    let freeMillagePrice = $('#txtPrice').val();
    let freeMillageDuration = $('#txtDuration').val();

    $.ajax({
        method: "PUT",
        url: 'http://localhost:8080/carRental/api/v1/car',
        data: JSON.stringify({
            "carID": carID,
            "Brand": Brand,
            "Type": Type,
            "numberOfPassengers": numberOfPassengers,
            "transmissionType": transmissionType,
            "fuelType": fuelType,
            "priceForExtraKM": priceForExtraKM,
            "registrationNumber": registrationNumber,
            "colour": colour,
            "lossDamageWaiver": lossDamageWaiver,
            "dailyRate": dailyRate,
            "monthlyRate": monthlyRate,
            "freeMillagePrice": freeMillagePrice,
            "freeMillageDuration": freeMillageDuration
        }),
        dataType: 'Json',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            console.log(res);
        },
        error: function (ob, textStatus, error) {
            console.log("error from : " + ob + " " + textStatus + " " + error);
            if (res.message != 'Success') {
                alert('Registration UnSuccessful! Try again');
            }
        }
    });

});

$('#btnDeleteCar').click(function () {
    let carid = $('#txtCarDeleteID').val();

    if (carid == ''){
        alert('Enter ID');
    }else{
        $.ajax({
            method: 'DELETE',
            url: 'http://localhost:8080/carRental/api/v1/car?id='+carid,
            success: function (res) {
                if (res.message == 'Success'){
                    alert('Car Deleted');
                }else{
                    alert('Try again');
                }
            }
        });
    }

});

$('#btnCarClear').click(function () {
    $('#txtBrand').val('');
    $('#carType').val('');//
    $('#txtNoPassengers').val('');
    $('#transmissionType').val('');//
    $('#fuelType').val('');//
    $('#txtPriceForExtraKM').val('');
    $('#txtRegistrationNo').val('');
    $('#txtColour').val('');
    $('#txtLossDamage').val('');
    $('#txtDailyRate').val('');
    $('#txtMonthlyRate').val('');
    $('#txtPrice').val('');
    $('#txtDuration').val('');

    loadAllCars();
});

function loadAllUnverifiedCustomers() {
    $('#tblCusBody').empty();
    $.ajax({
        url: 'http://localhost:8080/carRental/api/v1/customer',
        method: 'GET',
        success: function (res) {
            let values = res.data;
            for (i in values) {
                if (values[i].verified == false) {
                    let id = values[i].customerID;
                    let name = values[i].name;
                    let nic = values[i].nicNo;
                    let licence = values[i].drivingLicenceNo;

                    $('#tblCusBody').append(`<tr><th>${id}</th><td>${name}</td><td>${nic}</td><td>${licence}</td><td><button type="button" class="btn btn-secondary">View</button></td><td><button type="button" class="btn btn-secondary">View</button></td><td><button type="button" class="btn btn-success vrfy">Verify</button></td></tr>`)
                }

            }
        }
    });
}

$('#cusSearch').click(function () {

    let name = $('#txtCussearch').val();

    if (name == ''){
        alert('please enter name');
    }else{
        $('#tblSearchCus').empty();

        $.ajax({
            url: 'http://localhost:8080/carRental/api/v1/customer/' + name,
            method: 'GET',
            success: function (res) {
                let values = res.data;
                let id = values.customerID;
                let name = values.name;
                let address = values.address;
                let contact = values.contact;
                let email = values.email;
                let nic = values.nicNo;
                let licence = values.drivingLicenceNo;

                $('#tblSearchCus').append(`<tr><th>${id}</th><td>${name}</td><td>${address}</td><td>${contact}</td><td>${email}</td><td>${nic}</td><td>${licence}</td></tr>`);
            }
        });
    }
});

function loadAllBookings() {
    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/carRental/api/v1/bookings',
        success: function (res) {
            console.log(res);
            // let values = res.data;
            // for (i in values){
            //     let carID = values[i].carID;
            //     let registrationNo = values[i].registrationNumber;
            //     let rentDuration = " ";
            //
            //     $('#tblBookings')
            // }
        }
    });
}

$('#btnDriverSave').click(function () {
    let name = $('#txtDriverName').val();
    let contact = $('#txtDriverContact').val();
    let nic = $('#txtDriverNic').val();
    let userName = $('#txtDriverUserName').val();
    let password = $('#txtDriverPassword').val();

    $.ajax({
        method: 'POST',
        url: 'http://localhost:8080/carRental/api/v1/driver',
        data: JSON.stringify(
            {
                "driverID": "",
                "name": name,
                "contactNo": contact,
                "nic": nic,
                "available": true,
                "userName": userName,
                "password": password,
            }
        ),
        dataType: 'Json',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            console.log(res);
        }
    });

});

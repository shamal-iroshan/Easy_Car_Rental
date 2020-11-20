$('#btnSaveCar').click(function () {
    let carID = "";
    let Brand = $('#txtBrand').val();
    let Type = $('#').val();//
    let numberOfPassengers = $('#txtNoPassengers').val();
    let transmissionType = $('#').val();//
    let fuelType = $('#').val();//
    let priceForExtraKM = $('#txtPriceForExtraKM').val();
    let registrationNumber = $('#txtRegistrationNo').val();
    let colour = $('#txtColour').val();
    let dailyRate = $('#txtDailyRate').val();
    let monthlyRate = $('#txtMonthlyRate').val();
    let freeMillagePrice = $('#txtPrice').val();
    let freeMillageDuration = $('#txtDuration').val();

    $.ajax({
        method: "POST",
        url: 'http://localhost:8080/carRental/api/v1/car',
        data:JSON.stringify({
            "carID":carID,
            "Brand":Brand,
            "Type":Type,
            "numberOfPassengers":numberOfPassengers,
            "transmissionType":transmissionType,
            "fuelType":fuelType,
            "priceForExtraKM":priceForExtraKM,
            "registrationNumber":registrationNumber,
            "colour":colour,
            "dailyRate":dailyRate,
            "monthlyRate":monthlyRate,
            "freeMillagePrice":freeMillagePrice,
            "freeMillageDuration":freeMillageDuration
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

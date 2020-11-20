let arr = ['#btnDashboard','#btnAddCar','#btnCustomer','#btnBookings','#btnDriver','#btnPayments','#btnReports','#btnCarMaintenances'];

let containers = ['#dashboard','#car','#customer','#bookings','#driver','#payments','#reports','#maintenance']

$('#btnDashboard').click(function () {

    setClass();
    $('#btnDashboard').addClass('btn-custom-selected');

    setVisible();
    $('#dashboard').css('display','block');

});

$('#btnAddCar').click(function () {

    setClass();
    $('#btnAddCar').addClass('btn-custom-selected');

    setVisible();
    $('#car').css('display','block');
});

$('#btnCustomer').click(function () {

    setClass();
    $('#btnCustomer').addClass('btn-custom-selected');

    setVisible();
    $('#customer').css('display','block');
});

$('#btnBookings').click(function () {

    setClass();
    $('#btnBookings').addClass('btn-custom-selected');

    setVisible();
    $('#bookings').css('display','block');
});

$('#btnDriver').click(function () {

    setClass();
    $('#btnDriver').addClass('btn-custom-selected');

    setVisible();
    $('#driver').css('display','block');
});

$('#btnPayments').click(function () {

    setClass();
    $('#btnPayments').addClass('btn-custom-selected');

    setVisible();
    $('#payments').css('display','block');
});

$('#btnReports').click(function () {

    setClass();
    $('#btnReports').addClass('btn-custom-selected');

    setVisible();
    $('#reports').css('display','block');
});

$('#btnCarMaintenances').click(function () {

    setClass();
    $('#btnCarMaintenances').addClass('btn-custom-selected');

    setVisible();
    $('#maintenance').css('display','block');
});

function setClass() {
    for (id in arr){
        $(arr[id]).removeClass('btn-custom-selected');
        $(arr[id]).addClass('btn-custom');
    }
}

function setVisible() {
    for (i in containers){
        $(containers[i]).css('display','none');
    }
}

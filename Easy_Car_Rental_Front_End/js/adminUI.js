let arr = ['#btnDashboard','#btnAddCar','#btnCustomer','#btnBookings','#btnDriver','#btnPayments','#btnReports','#btnCarMaintenances'];

$('#btnDashboard').click(function () {

    setClass();

    $('#btnDashboard').addClass('btn-custom-selected');
});

$('#btnAddCar').click(function () {

    setClass();

    $('#btnAddCar').addClass('btn-custom-selected');
});

$('#btnCustomer').click(function () {

    setClass();

    $('#btnCustomer').addClass('btn-custom-selected');
});

$('#btnBookings').click(function () {

    setClass();

    $('#btnBookings').addClass('btn-custom-selected');
});

$('#btnDriver').click(function () {

    setClass();

    $('#btnDriver').addClass('btn-custom-selected');
});

$('#btnPayments').click(function () {

    setClass();

    $('#btnPayments').addClass('btn-custom-selected');
});

$('#btnReports').click(function () {

    setClass();

    $('#btnReports').addClass('btn-custom-selected');
});

$('#btnCarMaintenances').click(function () {

    setClass();

    $('#btnCarMaintenances').addClass('btn-custom-selected');
});

function setClass() {
    for (id in arr){
        $(arr[id]).removeClass('btn-custom-selected');
        $(arr[id]).addClass('btn-custom');
    }
}

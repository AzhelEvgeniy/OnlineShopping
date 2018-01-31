$(function () {

    // create a dataset
    var products = [
            ['1', 'ABC'],
            ['2', 'ABC'],
            ['3', 'ABC'],
            ['4', 'ABC'],
            ['5', 'ABC'],
            ['6', 'ABC'],
            ['7', 'ABC'],
            ['8', 'ABC'],
    ];

    var $table = $('#productListTable');

    // execute the below code only where we have this table
    if ($table.length) {
        //console.log('Inside the table!');

        $table.DataTable( {
            lengthMenu : [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'ALL']],
            pageLength : 5,
            data : products
        });
    }

});
$(function () {

    var $table = $('#productListTable');

    // execute the below code only where we have this table
    if ($table.length) {
        //console.log('Inside the table!');

        var jsonUrl = '';

        var categoryId = window.categoryId;
        if (categoryId == '') {
            jsonUrl = window.contextRoot + "/json/data/all/products";
        } else {
            jsonUrl = window.contextRoot + "/json/data/category/" + categoryId + "/products";
        }

        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'ALL']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'code',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        return '<img src="' + window.contextRoot + '/resources/assets/images/' + data + '.jpg" class="dataTableImg"/>';
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'brand'
                },
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '&#8377;' + data;
                    }
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if(data < 1) {
                            return '<span style="color:red">Out of Stock!</span>';
                        }

                        return data;
                    }
                },
                {
                    data: 'id',
                    mRender: function (data, type, row) {
                        var str = '';

                        str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary">' +
                                '<span class="glyphicon glyphicon-eye-open"></span> ' +
                            '<a/>' + '&#160;';

                        if (row.quantity < 1) {
                            str += '<a href="javascript:void(0)" class="btn btn-success disabled">' +
                                    '<span class="glyphicon glyphicon-shopping-cart"></span>' +
                                '</a>';
                        } else {
                            str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success">' +
                                    '<span class="glyphicon glyphicon-shopping-cart"></span>' +
                                '</a>';
                        }

                        return str;
                    }
                }
            ]
        });
    } // ----- end, if ($table.length)

});
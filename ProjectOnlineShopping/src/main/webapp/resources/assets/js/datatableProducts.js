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


    // dismissing the alert after 3 seconds
    var $alert = $(".alert");

    if ($alert.length) {
        setTimeout(function () {
            $alert.fadeOut('slow');
        }, 3000)
    }


    // --------------------------------------------
    // data table for admin
    // --------------------------------------------

    var $adminProductsTable = $('#adminProductsTable');

    // execute the below code only where we have this table
    if ($adminProductsTable.length) {
        //console.log('Inside the table!');

        var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

        $adminProductsTable.DataTable({
            lengthMenu: [[10, 30, 50, -1], ['10 records', '30 records', '50 records', 'ALL']],
            pageLength: 30, // default
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'id'
                },
                {
                    data: 'code',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        return '<img src="' + window.contextRoot + '/resources/assets/images/' + data + '.jpg" class="adminDataTableImg"/>';
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'brand'
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
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '&#8377;' + data;
                    }
                },
                {
                    data: 'active',     // switch field
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<label class="switch">';
                        if (data) {
                            str += '<input type="checkbox" checked="checked" value="' + row.id + '" />';
                        }
                        else {
                            str += '<input type="checkbox" value="' + row.id + '" />';
                        }
                        str += '<div class="slider"></div></label>';
                        return str;
                    }
                },
                {
                    data : 'id',        // EDIT field
                    bSortable : false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/' + data + '/product" class="btn btn-warning">';
                        str += '<span class="glyphicon glyphicon-pencil"></span></a>';
                        return str;
                    }
                }
            ],
            
            initComplete: function () {
                var api = this.api();

                api.$('.switch input[type="checkbox"]').on('change', function () {
                    var checkbox = $(this);
                    var checked = checkbox.prop('checked');
                    var dMsg = (checked) ? 'You want to activate the product?' :
                        'You want to deactivate the product?';
                    var value = checkbox.prop('value');
                    bootbox.confirm({
                        size: 'medium',
                        title: 'Product Activation & Deactivation',
                        message: dMsg,
                        callback: function (confirmed) {
                            if (confirmed) {
                                console.log(value);

                                var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';

                                $.post(activationUrl, function (data) {
                                    bootbox.alert({
                                        size: 'medium',
                                        title: 'Information',
                                        message: data   // callback message from server
                                    });
                                });
                            } else {
                                checkbox.prop('checked', !checked);
                            }
                        }
                    });
                });
            }
        });
    } // ----- end, if ($table.length)

    // --------------------------------------------
    // END data table for admin
    // --------------------------------------------


    // --------------------------------------------
    // validation code for category using jquery plugin

    //--------------------------------
    // validation code for category

    var $categoryForm = $('#categoryForm');

    if($categoryForm.length) {
        $categoryForm.validate({

            rules : {

                name : {

                    required: true,
                    minlength: 2

                },
                description: {
                    required: true
                }

            },

            messages : {

                name : {

                    required: 'Please add the category name!',
                    minlength: 'The category name should not be less than 2 characters'

                },
                description: {

                    required: 'Please add a description for this category!'
                }

            },

            errorElement: 'em',
            errorPlacement: function(error, element) {
                // add the class of help-block
                error.addClass('help-block');
                // add the error element after the input element
                error.insertAfter(element);
            }
        });
    }

});
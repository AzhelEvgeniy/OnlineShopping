$(function () {

    // handler the click event of refresh cart button
    $('button[name="refreshCart"]').click(function () {

        // fetch the cart line id
        var cartLineId = $(this).attr('value');
        var countElement = $('#count_' + cartLineId);

        var originalCount = countElement.attr('value');
        var currentCount = countElement.val();

        // work only the count has changed
        if (currentCount != originalCount) {
            //console.log("current count: " + currentCount);
            //console.log("original count: " + originalCount);

            if (currentCount < 1 || currentCount > 3) {
                // reverting back to the original count
                // user has given value below 1 and above 3
                countElement.val(originalCount);
                bootbox.alert({
                   size: 'medium',
                    title: 'Error',
                    message: 'Product count should be minimum 1 and max 3!'
                });
            } else {
                var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
                // forward it to the controller
                window.location.href = updateUrl;
            }
        }
    });

});
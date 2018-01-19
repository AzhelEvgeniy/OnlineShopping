$(function () {

    // view PageController
    switch (menu) {

        case 'About us': {
            $("#about").addClass("active"); break;
        }
        case 'All Products': {
            $("#listProducts").addClass("active"); break;
        }
        case 'Contact': {
            $("#contact").addClass("active"); break;
        }

    }

})
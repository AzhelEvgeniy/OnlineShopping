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
        default: {
            if (menu == "Home") break;
            $("#listProducts").addClass("active");
            $("#a_"+ menu).addClass("active");
            break;
        }

    }

});
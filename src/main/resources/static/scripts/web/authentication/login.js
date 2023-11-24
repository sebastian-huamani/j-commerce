
$(document).on("click", "#tab-login", function(){
    $("#box-login").removeClass("d-none");
    $("#box-register").addClass("d-none");
    $("#tab-register").removeClass("active");
    $("#tab-login").addClass("active");
});

$(document).on("click", "#tab-register", function(){
    $("#box-login").addClass("d-none");
    $("#box-register").removeClass("d-none");
    $("#tab-register").addClass("active");
    $("#tab-login").removeClass("active");
});

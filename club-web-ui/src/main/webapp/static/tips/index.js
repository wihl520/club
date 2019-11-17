$(function(){
    $(".headerwap ul li").addClass("disnone");
    $("#logo").bind("click",function(){
        $(".headerwap ul li").toggleClass("disnone");
    });
    $(window).scroll(function(){
        var $scrollvalue=$(document).scrollTop();
        if($scrollvalue>30){
            $(".art_nav_title").css("margin-left","15%");
        }else{
            $(".art_nav_title").css("margin-left","0px");
        }
        if($scrollvalue>200){
            $(".header").css("background","rgba(0,0,0,0.4)");
        }else{
            $(".header").css("background","rgba(0,0,0,0.2)");
        }
        if($scrollvalue>300){
            $(".header").css("background","rgba(0,0,0,0.5)");
        }
        if($scrollvalue>400){
            $(".header").css("background","rgba(0,0,0,0.6)");
        }
        if($(document).scrollTop()>45){
            $(".ac-ln-wrapper").addClass("nax_fixed");
            $(".ac-ln-content").css("width","100%");
            $(".ac-ln-content").css("margin-left","0px");
            $(".ac-ln-content>span").css("padding-left","20px")
        }else{
            $(".ac-ln-wrapper").removeClass("nax_fixed");
            $(".ac-ln-content").css("width","80%");
            $(".ac-ln-content").css("margin-left","10%");
            $(".ac-ln-content>span").css("padding-left","0px")
        }

    });

    $(".head-img").css("width",$(window).width()*3);
    $(".head-img-1").css("width",$(window).width());
    $(".head-img-2").css("width",$(window).width());
    $(".head-img-3").css("width",$(window).width());
    $(".jobs-info-btn").bind("click",function(){
        $(".position-list").toggleClass("display");
    });
    $("input[name=shop-color]").bind("click",function(){
        var $id=$("input[name=shop-color]:checked").attr("id");
        $("input[name=shop-color]+label>div").removeClass("selected");
        $("#"+$id+"+label>div").addClass("selected");
    });
    $("input[name=shop-size]").bind("click",function(){
        var $id=$("input[name=shop-size]:checked").attr("id");
        $("input[name=shop-size]+label>div").removeClass("selected");
        $("#"+$id+"+label>div").addClass("selected");
    });
    $("a").click(function() {
        $("html, body").animate({
            scrollTop: $($(this).attr("href")).offset().top + "px"
        }, {
            duration: 500,
            easing: "swing"
        });
        return false;
    });
    $("#country-select").bind("change",function(){
        if($("#country-select").val()=="gz"){
            $(".club-1-left").hide();
            $(".gz").show();
        }else if($("#country-select").val()=="sz"){
            $(".club-1-left").hide();
            $(".sz").show();
        }else if($("#country-select").val()=="dg"){
            $(".club-1-left").hide();
            $(".dg").show();
        }else if($("#country-select").val()=="fs"){
            $(".club-1-left").hide();
            $(".fs").show();
        }else if($("#country-select").val()=="cq"){
            $(".club-1-left").hide();
            $(".cq").show();
        }else if($("#country-select").val()=="tj"){
            $(".club-1-left").hide();
            $(".tj").show();
        }else{
            $(".club-1-left").show();
        }
    });
    $("#tripsignup-location").bind("change",function(){
        window.location=$("#tripsignup-location").val();
    });

    $(".img-thumb").bind("click",function(){
        $(".ceng").toggleClass("display");
    });
    $(".ceng img").bind("click",function(){
        $(".ceng").addClass("display");
    });
    $(".ceng").bind("click",function(){
        $(".ceng").addClass("display");
    });
    $("#video_img").bind("change",function(){
        $(".inner").css("background","#000");
        $(".inner").css("opacity","0.5");
    });
    //    window.onresize=function(){
    //    	if($(window).width()>426){
    //     	$(".pc_main").css("display","none");
    //     	$(".branch-main").css("display","block");
    //    	}
    //    	if($(window).width()<426){
    //     	$(".branch-main").css("display","none");
    //     }
    //    }

    //    if($(window).width()<426){
    //    	$(".branch-main").css("display","none");
    //    }

    //    if($(window).width()>426){
    // 	setTimeout(function(){
    //     	$(".pc_main").css("display","none");
    //     	$(".branch-main").css("display","block");
    //     },6000);
    // }


});
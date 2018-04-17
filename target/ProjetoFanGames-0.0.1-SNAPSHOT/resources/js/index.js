$(document).ready(function() {
	
		/*
        $(".img-principal-ativa").mouseover(function (){
            $(".img-principal-ativa").css("opacity","0.5");
            $(".img-principal1").css("opacity","0.5");
        });
        
        $(".img-principal-ativa").mouseout(function(){
            $(".img-principal-ativa").css("opacity","1");
        });
        */
        $(".img-principal1").mouseover(function(){
            $(".img-principal1").animate({width:'150px',
                                            height:'130px;'},"fast");
                                  
        });
        
        $(".img-principal1").mouseout(function(){
            $(".img-principal1").animate({width:'112px',
                                         height:'125px;'},"fast");
        });
        
        $(".img-principal2").mouseover(function(){
            $(".img-principal2").animate({width:'150px',
                                            height:'130px;'},"fast");
        });
        
        $(".img-principal2").mouseout(function(){
            $(".img-principal2").animate({width:'112px',
                                         height:'125px;'},"fast");
        });
        
        $(".img-principal3").mouseover(function(){
            $(".img-principal3").animate({width:'150px',
                                            height:'130px;'},"fast");
        });
        
        $(".img-principal3").mouseout(function(){
            $(".img-principal3").animate({width:'112px',
                                         height:'125px;'},"fast");
        });
        
        $(".img-principal4").mouseover(function(){
            $(".img-principal-ativa").attr("name","principal4.jpg");
            $(".img-principal4").animate({width:'150px',
                                         height:'130px;'},"fast");
        });
        
        $(".img-principal4").mouseout(function(){
            $(".img-principal4").animate({width:'112px',
                                         height:'125px;'},"fast");
        });
        
        
        
});
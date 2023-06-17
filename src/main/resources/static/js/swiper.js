window.onload = function(){
    swiperfunc();    
}
function swiperfunc(){
    const swiper = new Swiper('#swiper', {
        direction: 'horizontal',
        effect:'fade',
        loop: true,
    
        autoplay:{
            display:3000,
            disableOnInteraction:false,
        },

        pagination: {
            el: '.swiper-pagination',
        },

    });
}

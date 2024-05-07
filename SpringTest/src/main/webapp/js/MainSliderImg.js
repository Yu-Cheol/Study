$(document).ready(function () {
    // 상수 선언
    var slideChildWidth = $(window).width();
    const sliderChildCount = $('.slider').children().length;
    let pos = 0;

    // 슬라이드 크기 초기화 함수
    function initSliderSize() {
        slideChildWidth = $(window).width();
        const slideWidth = $(window).width() * sliderChildCount;
        $('.slider').width(slideWidth);
        $('.slider').css('left', -(pos * slideChildWidth));
        console.log(pos);
    }

    // 다음 슬라이드로 이동하는 함수
    function moveNextSlide() {
        pos++;
        if (pos < sliderChildCount) {
            $('.slider').animate({ left: '-=' + slideChildWidth }, 500, function () {
                $('.slider').css('left', -slideChildWidth * pos);
            });
        } else {
            pos = 0;
            $('.slider').animate({ left: 0 }, 500);
        }
    }

    // 이전 슬라이드로 이동하는 함수
    function movePrevSlide() {
        pos--;
        if (pos >= 0) {
            $('.slider').animate({ left: '+=' + slideChildWidth }, 500, function () {
                $('.slider').css('left', -slideChildWidth * pos);
            });
        } else {
            pos = 0;
        }
    }

    // 슬라이드 크기 초기화
    initSliderSize();

    // 윈도우 크기가 변경될 때 슬라이드 크기 초기화
    $(window).on('resize', function () {
        initSliderSize();
    });

    // 다음 버튼 클릭 시 다음 슬라이드로 이동
    $('.next').click(moveNextSlide);

    // 이전 버튼 클릭 시 이전 슬라이드로 이동
    $('.prev').click(movePrevSlide);
});
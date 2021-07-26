$(document).on('click','#send-userdata',function(){
    var dataset=$(document).find('form').serialize();
    $.ajax({
        url: '/add/',
        method: 'post',
        data:dataset,
        success: function(data){
            console.log(data);
        },
        error:function(){
            alert('Ошибка передачи данных');
        }
    });
});
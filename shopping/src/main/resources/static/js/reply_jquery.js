


let editModal;

$(document).ready(function (){

    editModal = new bootstrap.Modal('#replyEditModal')

    // 댓글 등록 버튼 이벤트 등록
    $("#btn_reply").on('click', insertReply)
    // 수정 submit 버튼 이벤트
    $('#btn_edit').click(editReply)

    // 리스트 항목의 수정 버튼 이벤트 등록, 동적으로 생성되는 Tag에 이벤트 연결
    $('#replyList').on('click', '.edit',showEditModal)
    // 리스트 항목의 삭제 버튼 이벤트 등록, 동적으로 생성되는 Tag에 이벤트 연결
    $('#replyList').on('click', '.del',deleteReply)

    // 페이지가 로드되면 리스트를 출력
    setList()

})

// 댓글 리스트
function setList(){

    // 비동기 통신 :댓글 리스트
    $.getJSON('/reply/'+sidx, function (data){

        console.log(data)

        $.each(data, function(index, reply){

            // 새로운 tr을 만들어서 replyList 영역에 추가
            let html = `
                    <td class="col-2">${reply.replyer.uid}</td>
                        <td class="col">${reply.reply}</td>
                        <td class="col-2">${reply.replydate}</td>
                        <td class="col-2">
                            <a href="javascript:" replyer_idx="${reply.replyer.uidx}" class="badge text-decoration-none edit">수정</a>
                            <a href="javascript:" replyer_idx="${reply.replyer.uidx}" class="badge text-decoration-none del">삭제</a>
                        </td>`


            const newTR = $('<tr></tr>').attr('class', 'fs-6 text-center').attr('tr-index', reply.rno).html(html)

            // 부모 태그에 요소 추가
            $('#replyList').append(newTR)
        })
    })
}

// 댓글 입력
function insertReply(){
    // 서버로 전송할 payload
    const payload = {
        sidx : sidx,
        reply : $("#reply").val(),
        replyer : $("#replyer").val()
    }

    console.log("payload", payload)

    $.ajax({
        url : '/reply',
        type : 'post',
        contentType : 'application/json',
        data : JSON.stringify(payload),
        dataType: 'json',
        success: function(data){

            const reply = data

            let html = `
                    <td class="col-2">${reply.replyer.uid}</td>
                        <td class="col">${reply.reply}</td>
                        <td class="col-2">${reply.replydate}</td>
                        <td class="col-2">
                            <a href="javascript:" replyer_idx="${reply.replyer.uidx}" class="badge text-bg-light edit">수정</a>
                            <a href="javascript:" replyer_idx="${reply.replyer.uidx}" class="badge text-bg-dark del">삭제</a>
                         </td>`


            const newTR = $('<tr></tr>').attr('class', 'fs-6 text-center').attr('tr-index', reply.rno).html(html)

            // 부모 태그에 요소 추가
            $('#replyList').append(newTR)

            $("#reply").val('')
        },
        error : function (request, httpStatus, error) {
            console.log(request)
            console.log(httpStatus)
            console.log(error)
        }
    })


}
// 댓글 삭제
function deleteReply(e){

    // 기본 기능 제거
    e.preventDefault()

    if(midx != $(this).attr('replyer_idx')){
        alert('작성자만 삭제 가능합니다.')
        return false;
    }

    if(!confirm('삭제하시겠습니까?')){
        return;
    }

    // rno 구하기
    const rno = $(this).parent('td').parent('tr').attr('tr-index')

    console.log('rno >>> ', rno)

    $.ajax({
        url : '/reply/'+rno,
        type : 'delete',
        success : function (data){
            console.log('delete - response => ', data)

            if( data == 1){
                // 화면에서 tr-index == rno 행을삭제
                // 삭제 대상 행
                $('tr[tr-index="'+rno+'"]').remove()
                alert('삭제되었습니다.')

            } else {
                alert('삭제할 대상이 존재하지 않습니다.')
            }
        },
        error : function (request, status, error){
            console.log(request)
            console.log(error)
            console.log(code)
        }
    })

}

// 수정 창
function showEditModal(e){

    // 기본 기능 제거
    e.preventDefault()

    if(midx != $(this).attr('replyer_idx')){
        alert('작성자만 수정 가능합니다.')
        return false;
    }

    editModal.show()

    const editTD = $(this).parent('td').parent('tr').children('td')
    const rno = $(this).parent('td').parent('tr').attr('tr-index')


    console.log($(editTD).eq(0).text())
    console.log($(editTD).eq(1).text())
    console.log($(editTD).eq(2).text())


    $('#erno').val(rno)
    $('#ereplyerName').val($(editTD).eq(0).text())

    $('#ereplyer').val($(this).attr("replyer_idx"))

    $('#ereply').val($(editTD).eq(1).text())
    $('#ereplydate').val($(editTD).eq(2).text())

}

// 댓글 수정
function editReply(){
    // 서버로 전송할 payload
    // put => 전체 데이터의 변경, 모든 데이터를 서버로 전송, 값이 없는 경우 기본값으로 저장
    const payload = {
        sidx : sidx,
        rno : $('#erno').val() ,
        reply : $("#ereply").val(),
        replyer : $("#ereplyer").val(),
        replydate : $('#ereplydate').val()
    }

    console.log(payload)

    $.ajax({
        url : '/reply/'+payload.rno,
        type : 'put',
        contentType : 'application/json',
        data : JSON.stringify(payload),
        dataType: 'json',
        success: function(data){

            const editTD = $('tr[tr-index="'+payload.rno+'"]>td')
            $(editTD).eq(1).text(payload.reply)

            editModal.hide()

        },
        error : function (request, status, error){
            console.log(request)
            console.log(error)
            console.log(code)
        }
    })
}
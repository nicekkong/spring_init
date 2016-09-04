<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/header.jsp"%>

<!-- Main content -->
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">READ BOARD</h3>
                </div>
                <!-- /.box-header -->

<form role="form" method="post">

    <input type='hidden' name='bno' value="${board.bno}">
    <input type="hidden" name="page" value="${cri.page}">
    <input type="hidden" name="perPageNum" value="${cri.perPageNum}">

    <div class="box-body">

        <div class="form-group">
            <label>NO.</label> <input type="text" name='bno' class="form-control" value="${board.bno}" readonly="readonly">
        </div>

        <div class="form-group">
            <label>Title</label> <input type="text" name='title' class="form-control" value="${board.title}">
        </div>
        <div class="form-group">
            <label>Content</label>
            <textarea class="form-control" name="content" rows="3">${board.content}</textarea>
        </div>
        <div class="form-group">
            <label>Writer</label> <input type="text" name="writer" class="form-control" value="${board.writer}">
        </div>
    </div>
    <!-- /.box-body -->
</form>


<div class="box-footer">
    <button type="submit" class="btn btn-primary">SAVE</button>
    <button type="submit" class="btn btn-warning">CANCEL</button>
</div>

<script>
    $(document).ready(function() {

        var formObj = $("form[role='form']");

        console.log(formObj);

        $(".btn-warning").on("click", function() {
            self.location = "/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
        });

        $(".btn-primary").on("click", function() {

            if (confirm("수정한 내용을 저장하시겠습니까?")) {
                formObj.attr("method", "post");
                formObj.submit();
            }
        });
    });

    var result = '${msg}';

    if(result == 'SUCCESS'){
        alert("처리가 완료되었습니다.");

        location.href = "/board/listPage?page=${page}&perPageNum=${perPageNum}";
    }
</script>
            </div>
            <!-- /.box -->
        </div>
        <!--/.col (left) -->

    </div>
    <!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="/WEB-INF/view/include/footer.jsp"%>

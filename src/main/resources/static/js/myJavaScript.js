$(function () {
    //左侧导航栏切换准备
    $(".left_tab").on("click", function () {
        $(".left_tab").removeClass("tab_active");
        $(this).addClass("tab_active");
        $(".right_content").empty();
    })
//点击查询学生信息事件
    $("#getStudents").on("click", function () {
        $.ajax({
            url:$(this).attr("data-url"),
            dataType:"json",
            type:"get",
            async:false,
            success:function (students) {
                $(".right_content").append("<table class='table_css' id='student_info'></table>");
                $("#student_info").append("<tr><td>学生姓名</td><td>性别</td><td>科目类别</td><td>成绩</td><td>修改</td><td>删除</td></tr>");
                $.each(students, function (i, student) {
                    $("#student_info").append("<tr><td>"+student.name+"</td><td>"+student.gender+"</td>" +
                        "<td>"+student.class_id+"</td><td>"+student.score+"</td><td class='update_css' data-url='/student/"+student.id+"'>修改</td>" +
                        "<td class='delete_css' data-url='/student/"+student.id+"'>删除</td></tr>");
                })
                $(".delete_css").on("click", function () {
                    $.ajax({
                        url:$(this).attr("data-url"),
                        type: "delete",
                        async: false,
                        success:function (data) {
                            alert(data);
                        }
                    })
                    $(this).parent().remove();
                })
                $(".update_css").on("click", function () {
                    $(".right_content").empty();
                    initForm();
                    $.ajax({
                        url:$(this).attr("data-url"),
                        type: "get",
                        dataType: "json",
                        success: function (student) {
                            $("input[name='id']").val(student.id);
                            $("input[name='num']").val(student.num);
                            $("input[name='name']").val(student.name);
                            $("input[name='gender'][value='"+student.gender+"']").attr("checked","checked");
                            $("select[name='class_id']").val(student.class_id);
                            $("input[name='score']").val(student.score);
                        }
                    })
                    $("#addButton").on("click", function () {
                        $.ajax({
                            url: "/student",
                            type: "put",
                            data: $("#addForm").serialize(),
                            success : function (data) {
                                alert(data);
                            }
                        })
                        return false;
                    })
                })
            }
        })
    })
//初始化表单界面函数
    function initForm(){
        $(".right_content").append("<form id='addForm' action='/student' method='post'></form>");
        $("#addForm").append("<input type='hidden' name='id' value='0'/>");
        $("#addForm").append("学号:<input name='num' type='text'/><br>");
        $("#addForm").append("姓名:<input name='name' type='text'/><br>");
        $("#addForm").append("性别:<label><input name='gender' type='radio' value='男'/>男</label><label><input name='gender' type='radio' value='女'/>女</label><br>");
        $("#addForm").append("科目号:<select class='select_css' name='class_id'></select><br>");
        $("#addForm").append("成绩:<input name='score' type='text'/><br>");
        $("#addForm").append("<button id='addButton' value='提交'>提交</button><br>");
        $.ajax({
            url: "/classId",
            dataType: "json",
            type: "get",
            success: function (data) {
                $.each(data, function (i, item) {
                    $("select[name='class_id']").append("<option value='"+item+"'>"+item+"班</option>");
                })
            }
        })
    }

//点击新增学生成绩事件
    $("#addStudent").on("click", function () {
        initForm();
        $("#addButton").on("click", function () {
            $.ajax({
                url:"/student",
                type: "post",
                data: $("#addForm").serialize(),
                success : function (data) {
                    alert(data);
                }
            })
            return false;
        })
    })
})
var allow_comment = true;
var allow_ping = true;
var allow_feed = true;

$('#tags').tagsInput({
    width: '100%',
    height: '35px',
    defaultText: '请输入文章标签'
});

$('.toggle').toggles({
    on: true,
    text: {
        on: '开启',
        off: '关闭'
    }
});

$(".select2").select2({
    width: '100%'
});

var tale = new $.tale();

/**
 * 保存文章
 * @param status
 */
function subArticle(status) {
    var title = $('#articleForm input[name=title]').val();
    var content = $('#text').val();
    if (title == '') {
        tale.alertWarn('请输入文章标题');
        return;
    }
    if (content == '') {
        tale.alertWarn('请输入文章内容');
        return;
    }
    $('#content-editor').val(content);
    $("#articleForm #status").val(status);
    var categories = $('#multiple-sel').val();
    var tag = $("#tags").val();
   // var params = $("#articleForm").serialize();
    var params = {
    		"title" : title,
    		"status" : status,
    		"tags" : tag,
    		"categories" : categories,
    		"allowComment" : allow_comment,
    		"allowPing" : allow_ping,
    		"allowFeed" : allow_feed,
    		"content" : content
    }
    var url = "/admin/insertArticle";
    tale.post({
        url:url,
        data:params,
        success: function (result) {
            if (result && "0000"==result.code) {
                tale.alertOk({
                    text:'文章保存成功',
                    then: function () {
                        setTimeout(function () {
                            window.location.href = '/admin/article';
                        }, 500);
                    }
                });
            } else {
                tale.alertError(result.msg || '保存文章失败');
            }
        }
    });
}

var textarea = $('#text'),
    toolbar = $('<div class="markdown-editor" id="md-button-bar" />').insertBefore(textarea.parent())
preview = $('<div id="md-preview" class="md-hidetab" />').insertAfter('.markdown-editor');

markdown(textarea, toolbar, preview);


function allow_comment(obj) {
    var this_ = $(obj);
    var on = this_.find('.toggle-on.active').length;
    var off = this_.find('.toggle-off.active').length;
    if (on == 1) {
        $('#allow_comment').val(false);
        allow_comment = true;
    }
    if (off == 1) {
        $('#allow_comment').val(true);
        allow_comment = false;
    }
}

function allow_ping(obj) {
    var this_ = $(obj);
    var on = this_.find('.toggle-on.active').length;
    var off = this_.find('.toggle-off.active').length;
    if (on == 1) {
        $('#allow_ping').val(false);
        allow_ping = true;
    }
    if (off == 1) {
        $('#allow_ping').val(true);
        allow_ping = false;
    }
}


function allow_feed(obj) {
    var this_ = $(obj);
    var on = this_.find('.toggle-on.active').length;
    var off = this_.find('.toggle-off.active').length;
    if (on == 1) {
        $('#allow_feed').val(false);
        allow_feed = true;
    }
    if (off == 1) {
        $('#allow_feed').val(true);
        allow_feed = false;
    }
}

$('div.allow-false').toggles({
    off: true,
    text: {
        on: '开启',
        off: '关闭'
    }
});
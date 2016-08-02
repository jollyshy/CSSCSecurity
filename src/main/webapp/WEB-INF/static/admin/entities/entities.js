window.Entities = (function() {
    var Entities = {};
    Entities.config = {
        apiUrl: 'http://localhost:8080'
    };
    Entities.sync = function(url, data, options) {
        var data = $.toJSON(data);
        console.log(data);
        options = options || {};
        var params = {
            url: url,
            type: options.type || 'post',
            data: data,
            contentType: 'application/json',
            dataType: 'json'
        };
        var xhr = options.xhr = $.ajax(params);
        // 处理链式调用情况
        return xhr.then(function(res, textStatus, jqXHR) {
            if (res.status == 0) {
                return res.data;
            } else {
                console.log(res.status);
                return $.Deferred().reject(jqXHR, data, 'INROAD_ERROR').promise();
            }
        });
    };
    Entities.formSync = function(url, data, options) {
        console.log(data);
        options = options || {};
        var params = {
            url: url,
            type: options.type || 'post',
            data: data,
            contentType: 'application/x-www-form-urlencoded',
            dataType: 'json'
        };

        var xhr = options.xhr = $.ajax(params);
        // 处理链式调用情况 application/json
        return xhr.then(function(res, textStatus, jqXHR) {
            console.log(res);
            if (res.status == 0) {
                return res.status;
            } else {
                return $.Deferred().reject(jqXHR, data, 'INROAD_ERROR').promise();
            }
        });
    };
    return Entities
}());
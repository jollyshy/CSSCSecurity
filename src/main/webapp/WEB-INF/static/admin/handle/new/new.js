/**
 * Created by huchao on 2016/8/27.
 */
/**
 * Created by huchao on 2016/7/8.
 */
Entities.Health = (function (Backbone, Entities, _) {
    var base = Entities.config.apiUrl;
    var API_SAVE = base + '/new/add';//�������
    var API_EDIT = base + '/new/edit';//�༭����
    var API_QUERY = base + '/new/queryDetail';//��ѯָ��id����
    var API_FETCH = base + '/new/query';//��ѯָ������
    var API_DESTROY = base + '/new/delete';//ɾ����������
    var API_DELETES = base + '/new/deletes';//ɾ���������
    var Model = Backbone.Model.extend({
        idAttribute: 'id',
        edit: function (data) {
            var model = this;
            data = _.extend({id: model.id}, data);
            console.log(data);
            return Entities.sync(API_EDIT, data).then(function (res) {
                model.set(_.extend(data, res));
            });
        },
        delete: function () {
            var model = this;
            var data = {id: model.id};
            return Entities.sync(API_DESTROY, data).then(function (res) {
                model.trigger('destroy', model, model.collection, {removeself: true});
            });
        },
    });

    var Collection = Backbone.Collection.extend({
        model: Model,
        fetch: function (data) {
            console.log(data);
            var collection = this;
            return Entities.sync(API_FETCH, data).then(function (res) {
                collection.reset(res);
            });
        },
        query: function (data) {
            var collection = this;
            return Entities.sync(API_QUERY, data).then(function (res) {
                console.log(res);
                collection.reset(res);
            });
        },
        create: function (data) {
            var collection = this;
            return Entities.sync(API_SAVE, data).then(function (res) {
                collection.unshift(_.extend(data,res));
            });
        },
        deletes: function (data) {
            var collection = this;
            return Entities.sync(API_DELETES, data).then(function (res) {
                collection.unshift(_.extend(data,res));
            });
        }
    });
    return {
        Model: Model,
        Collection: Collection
    };
}(Backbone, Entities, _));

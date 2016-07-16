/**
 * Created by huchao on 2016/7/6.
 */
Entities.User = (function (Backbone, Entities, _) {
    var base = 'http://115.159.114.88';
    var API_SAVE = base + '/user/add';//��ӷ��ɷ���
    var API_EDIT = base + '/user/edit';//�༭���ɷ���
    var API_QUERY = base + '/user/queryDetail';//��ѯָ��id����
    var API_FETCH = base + '/user/query';//��ѯ���ɷ���
    var API_DESTROY = base + '/user/delete';//ɾ�����ɷ���
    var API_DELETES = base + '/user/deletes';//ɾ�����ɷ���
    var Model = Backbone.Model.extend({
        idAttribute: 'id',
        edit: function (data) {
            var model = this;
            data = _.extend({id: model.id}, data);
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

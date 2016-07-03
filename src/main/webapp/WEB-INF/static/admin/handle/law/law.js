/**
 * Created by huchao on 2016/7/3.
 */
Entities.Law = (function (Backbone, Entities, _) {
    var base = 'http://localhost:8080';
    var API_SAVE = base + '/law/add';//��ӷ��ɷ���
    var API_EDIT = base + '/law/edit';//�༭���ɷ���
    var API_QUERY = base + '/law/queryDetail';//��ѯָ��id����
    var API_FETCH = base + '/law/query';//��ѯ���ɷ���
    var API_DESTROY = base + '/law/delete';//ɾ�����ɷ���
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
                collection.reset(res);
            });
        },
        create: function (data) {
            var collection = this;
            return Entities.sync(API_SAVE, data).then(function (res) {
                collection.unshift(_.extend(data, res));
            });
        }
    });
    return {
        Model: Model,
        Collection: Collection
    };
}(Backbone, Entities, _));

/**
 * Created by huchao on 2016/7/6.
 */
Entities.Technique = (function (Backbone, Entities, _) {

    var base = Entities.config.apiUrl;
    var API_SAVE = base + '/technique/add';//��ӷ��ɷ���
    var API_EDIT = base + '/technique/edit';//�༭���ɷ���
    var API_QUERY = base + '/technique/queryDetail';//��ѯָ��id����
    var API_FETCH = base + '/technique/query';//��ѯ���ɷ���
    var API_DESTROY = base + '/technique/delete';//ɾ�����ɷ���
    var API_DELETES = base + '/technique/deletes';//ɾ�����ɷ���
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
        }
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

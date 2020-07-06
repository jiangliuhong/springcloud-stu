export default {
    name: 'route',
    data() {
        return {
            routers: [],
            routeQuery: {
                idname: ''
            },
            routeDialogVisible: false,
            // 表单状态，1 新增，2 编辑
            routeFormType: 1,
            routeForm: {
                id: '',
                name: '',
                predicatesList: [],
                filtersList: []
            },
            routeFormLabelWidth: '100px',
            // 路由断言关键字候选数据
            routePredicatesKeyData: [
                { "value": "Path" },
                { "value": "After" },
                { "value": "Before" },
                { "value": "Between" },
                { "value": "Cookie" },
                { "value": "Header" },
                { "value": "Host" },
                { "value": "Method" },
                { "value": "Query" },
                { "value": "RemoteAddr" }
            ],
            routeFiltersKeyData: [
                { "value": "AddRequestParameter" },
                { "value": "RewritePath" }
            ]
        }
    },
    methods: {
        init() {
            this.queryRouters();
        },
        doQuery() {
            this.queryRouters();
        },
        /**
         * 查询路由列表
         */
        queryRouters() {
            this.ajax.get(this.config.api.route, this.routeQuery).then(res => {
                if (res) {
                    this.routers = res;
                } else {
                    this.routers = [];
                }
            }).catch(err => {
                console.log(err);
            });
        },
        /**
         * 路由删除
         */
        routeDelete(route) {
            this.ajax.delete(this.config.api.route + "/" + route.id).then(() => {
                // 删除成功,刷新列表
                this.$notify({
                    title: '成功',
                    message: '删除路由成功',
                    type: 'success'
                });
                this.queryRouters();
            }).catch(err => {
                console.log(err);
                this.$notify({
                    title: '错误',
                    message: '删除路由失败',
                    type: 'error'
                });
            });
        },
        /**
         * 反解list
         */
        reslovePfList(str) {
            if (str) {
                const list = JSON.parse(str);
                if (list && list.length > 0) {
                    const res = [];
                    for (let i = 0; i < list.length; i++) {
                        const s = list[i];
                        const indexOf = s.indexOf("=");
                        const v = {
                            key: s.substring(0, indexOf),
                            value: s.substring(indexOf + 1, s.length)
                        }
                        res.push(v);
                    }
                    return res;
                } else {
                    return [];
                }
            } else {
                return [];
            }
        },
        /**
         * 路由编辑
         */
        routeEdit(route) {
            this.routeFormType = 2;
            route.predicatesList = this.reslovePfList(route.predicates);
            route.filtersList = this.reslovePfList(route.filters);
            this.routeForm = route;
            this.routeDialogVisible = true;
        },
        /**
         * 路由新增
         */
        routeAdd() {
            this.routeFormType = 1;
            this.routeDialogVisible = true;
            this.routeForm = {
                id: '',
                name: '',
                url: '',
                predicatesList: [],
                filtersList: []
            };
        },
        removeRoutePredicate(item) {
            var index = this.routeForm.predicatesList.indexOf(item)
            if (index !== -1) {
                this.routeForm.predicatesList.splice(index, 1)
            }
        },
        predicateQuerySearch(queryString, cb) {
            var restaurants = this.routePredicatesKeyData;
            var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
            // 调用 callback 返回建议列表的数据
            cb(results);
        },
        filterQuerySearch(queryString, cb) {
            var restaurants = this.routeFiltersKeyData;
            var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
            // 调用 callback 返回建议列表的数据
            cb(results);
        },
        createFilter(queryString) {
            return (restaurant) => {
                return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
            };
        },
        addPredicateList() {
            this.routeForm.predicatesList.push({ key: '', value: '' });
        },
        addFilterList() {
            this.routeForm.filtersList.push({ key: '', value: '' });
        },
        removeRouteFilter(item) {
            var index = this.routeForm.filtersList.indexOf(item)
            if (index !== -1) {
                this.routeForm.filtersList.splice(index, 1)
            }
        },
        /**
         * 提交路由请求
         */
        postRouter() {
            this.$refs['routeForm'].validate((valid) => {
                if (!valid) {
                    console.log('routeForm表单校验失败');
                    return;
                }
                // 构建数据
                const predicates = [];
                if (this.routeForm.predicatesList && this.routeForm.predicatesList.length > 0) {
                    for (let i = 0; i < this.routeForm.predicatesList.length; i++) {
                        const pre = this.routeForm.predicatesList[i];
                        predicates.push(pre.key + "=" + pre.value);
                    }
                }
                this.routeForm.predicates = JSON.stringify(predicates);
                const filters = [];
                if (this.routeForm.filtersList && this.routeForm.filtersList.length > 0) {
                    for (let i = 0; i < this.routeForm.filtersList.length; i++) {
                        const fil = this.routeForm.filtersList[i];
                        filters.push(fil.key + "=" + fil.value);
                    }
                }
                this.routeForm.filters = JSON.stringify(filters);
                if (this.routeFormType == 1) {
                    // 新增
                    this.ajax.post(this.config.api.route, this.routeForm).then(() => {
                        this.$notify({
                            title: '成功',
                            message: '新增路由成功',
                            type: 'success'
                        });
                        this.queryRouters();
                        this.routeDialogVisible = false;
                    }).catch(err => {
                        console.log(err);
                        this.$notify.error({
                            title: '错误',
                            message: '新增路由异常'
                        });
                    });
                } else {
                    // 修改
                    this.ajax.put(this.config.api.route, this.routeForm).then(() => {
                        // 修改成功,刷新列表
                        this.$notify({
                            title: '成功',
                            message: '修改路由成功',
                            type: 'success'
                        });
                        this.queryRouters();
                        this.routeDialogVisible = false;
                    }).catch(err => {
                        console.log(err);
                        this.$notify.error({
                            title: '错误',
                            message: '修改路由异常'
                        });
                    });
                }
            });
        },
        refreshRoute() {
            this.ajax.get(this.config.api.refreshRoute).then(() => {
                this.$notify({
                    title: '成功',
                    message: '刷新路由成功',
                    type: 'success'
                });
            }).catch(err => {
                console.log(err);
                this.$notify.error({
                    title: '错误',
                    message: '刷新路由成功'
                });
            });
        }
    },
    mounted() {
        this.init();
    }
}
var vm = new Vue({
    el: '#app',
    delimiters: ['[[', ']]'],
    data: function () {
        //自定义的校验规则
        var validatePass =function (rule, value, callback)  {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.create.password) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        //包含了整个页面所有的数据模型，数据模型数值的改变，对应的视图会自动改变
        return {
            //对应resetful资源的url
            url: '/ceb_poin/webapi/njriskfunds',
            //码值列表的资源url
            codetableurl: '',
            //返回的列表数据
            resultdatas: [],
            //查询form表单的数据模型
            searchform: {
            
                starttime: '',
                
                
                
                
                
                
            
                endtime: '',
                
                
                
                
                
                
            
            },
            
            //表格当前选中项的数据ID
            currentId: '',
            
            //表格更新数据form表单的数据模型
            update: {
            
            },
            
            //页面初始化时候需要获取的码值选项，如果需要获取码值的，将码值代码填写在下面的列表中
            codetableget: {
                code: []
            },
            //页面上所有码值对象的数据模型，一般对应下拉列表，checkbox列表，radiobox列表
            //在页面整个组件挂载的时候，会根据codetableget对象统一从服务器端获取
            //在整个页面的生命周期内不用重复获取，可以在查询form表单、create表单，更新表单内复用
            codetable: {
                
            },
            
            
            //更新风险金审核时候的form表单校验规则
            updateRules: {
            
            },
            
            //有关分页和其他一些公用的查下筛选条件模型
            filter: {
                limit: 10, // 页大小
                offset: 0, // 当前页
                sorts: '',
				page:1
            },
            //分页总条数
            total_rows: 0,
            //加载动画显示
            loading: true,
            //表格多选数据
            selected: [], //已选择项
            
            
            dialogUpdateVisible: false, //编辑对话框的显示状态
            //更新风险金审核动画显示
            updateLoading: false,
            
            dialogHelpVisible:false,//帮助对话框的显示状态    
        };
    },
//整个页面组件挂载时候要执行的方法
mounted: function () {
    //this.getCodeTalbe();
    this.getresultdatas();
},
//整个页面需要使用到函数定义
methods: {
    //表格复选框勾选事件处理
    handleSelectionChange: function(val) {
        this.selected = val;
    },
    //表格排序事件处理
    tableSortChange: function(val) {
        //  console.log(`排序属性: ${val.prop}`);
        //  console.log(`排序: ${val.order}`);
        if (val.prop != null) {
            if (val.order == 'descending') {
                this.filter.sorts = '-' + val.prop;
            } else {
                this.filter.sorts = '' + val.prop;
            }
        } else {
            this.filter.sorts = '';
        }
        this.getresultdatas();
    },
    //表格每页显示数据条数改变事件处理
    pageSizeChange: function(val) {
        //  console.log(`每页 ${val} 条`);
        this.filter.limit = val;
        this.getresultdatas();
    },
    //表格分页当前页改变事件处理
    pageCurrentChange: function(val) {
        //  console.log(`当前页: ${val}`);
        this.filter.offset = val;
        this.filter.page = val;
        this.getresultdatas();
    },
    
    //表格编辑当前行事件处理
    setCurrent: function(data) {
        var _this = this;
        _this.currentId = data.id;
        // 向请求服务端获取单个数据填充更新的form表单
        var instance = axios_encrypt();
        instance.get(_this.url + "/id", {
            params: {
                id: data.id
            }
        }).then(function (response) {
            _this.update = Object.assign({}, _this.update, response.data);
            _this.dialogUpdateVisible = true;
            _this.dialogUpdateVisible = true;
        })
            .catch(function (response) {
                _this.$message.error('获取风险金审核失败!');
            });
    },
    // 更新数据
    updateData: function() {
        var _this = this;
        _this.$refs.update.validate(function (valid) {
            if (valid) {
                _this.updateLoading = true;
                var instance = axios_encrypt();
                instance.post(_this.url + "/update", _this.update
                ).then(function (response) {
                    if (response.data.result == "success") {
                        _this.$message.success('修改风险金审核成功！');
                        _this.dialogUpdateVisible = false;
                        _this.updateLoading = false;
                        _this.reset('update');
                        _this.getresultdatas();
                    } else {
                        _this.$message.error(response.data.result);
                        _this.updateLoading = false;
                    }
                })
                    .catch(function (response) {
                        var data = response.data;
                        console.log(data);
                        if (data instanceof Array) {
                            _this.$message.error(data[0]["message"]);
                        } else if (data instanceof Object) {
                            _this.$message.error(data["message"]);
                        }
                        _this.updateLoading = false;
                    });
            } else {
                return false;
            }
        });
    },
    
    //查询form表单查询按钮事件处理
    query: function() {
        this.filter.offset = 0;
        this.filter.page = 1;
        this.getresultdatas();
    },
    //获取码值
    getCodeTalbe: function() {
        var _this = this;
        var instance = axios_encrypt();
        instance.get(_this.codetableurl, {
            params: _this.codetableget
        }).then(function (response) {
            _this.codetable = response.data;
        })
            .catch(function (response) {
                _this.$message.error('错了哦，这是一条错误消息');
            });
    },
    // 获取风险金审核列表
    getresultdatas: function() {
        var _this = this;
        _this.loading = true;
        var instance = axios_encrypt();
        instance.get(_this.url + "/page", {
            params: Object.assign({}, _this.searchform, _this.filter)
        })
            .then(function (response) {
                _this.resultdatas = response.data.rows;
                _this.total_rows = response.data.total;
                _this.loading = false;
            })
            .catch(function (response) {
                _this.$message.error('错了哦，这是一条错误消息');
                _this.total_rows = 0;
                _this.resultdatas = [];
                _this.loading = false;
            });
    },
    // 重置表单
    reset: function(formName) {
        this.$refs[formName].resetFields();
    },
    
    //数据导出
    exportdata: function () {
        alert("待实现！");
    },
    
    }
})
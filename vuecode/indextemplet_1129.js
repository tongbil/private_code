var vm = new Vue({
    el: '#app',
    delimiters: ['[[', ']]'],
    data: function () {
        //自定义的校验规则
        var validatePass = function(rule, value, callback)  {
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
            url: '{{page_resourceurrl}}',
            //码值列表的资源url
            codetableurl: '{{codetableurl}}',
            //返回的列表数据
            resultdatas: [],
            //查询form表单的数据模型
            searchform: {
            {% for formitem in searchForm %}
                {% if formitem.type=="普通输入框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="下拉列表框" %}{% if formitem.select_multiple=="true" %}{{formitem.name}}: [],{% else %} {{formitem.name}}: '', {% endif %}{% endif %}
                {% if formitem.type=="日期选择框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="时间选择框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="switch开关" %}{{formitem.name}}: false,{% endif %}
                {% if formitem.type=="多选框" %}{{formitem.name}}: [],{% endif %}
                {% if formitem.type=="单选框" %}{{formitem.name}}: '',{% endif %}
            {% endfor %}
            },
            {% if page_addbutton=="是" %}
            //增加form表单的数据模型
            create: {
            {% for formitem in createForm %}
                {% if formitem.type=="普通输入框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="下拉列表框" %}{% if formitem.select_multiple=="true" %}{{formitem.name}}: [],{% else %} {{formitem.name}}: '', {% endif %}{% endif %}
                {% if formitem.type=="日期选择框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="时间选择框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="switch开关" %}{{formitem.name}}: false,{% endif %}
                {% if formitem.type=="多选框" %}{{formitem.name}}: [],{% endif %}
                {% if formitem.type=="单选框" %}{{formitem.name}}: '',{% endif %}
            {% endfor %}
            },
            {% endif %}
            //表格当前选中项的数据ID
            currentId: '',
            {% if page_editbutton=="是" %}
            //表格更新数据form表单的数据模型
            update: {
            {% for formitem in updateForm %}
                {% if formitem.type=="普通输入框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="下拉列表框" %}{% if formitem.select_multiple=="true" %}{{formitem.name}}: [],{% else %} {{formitem.name}}: '', {% endif %}{% endif %}
                {% if formitem.type=="日期选择框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="时间选择框" %}{{formitem.name}}: '',{% endif %}
                {% if formitem.type=="switch开关" %}{{formitem.name}}: false,{% endif %}
                {% if formitem.type=="多选框" %}{{formitem.name}}: [],{% endif %}
                {% if formitem.type=="单选框" %}{{formitem.name}}: '',{% endif %}
            {% endfor %}
            },
            {% endif %}
            //页面初始化时候需要获取的码值选项，如果需要获取码值的，将码值代码填写在下面的列表中
            codetableget: {
                code: [{% for code in codetableget %}"{{code}}",{% endfor %}]
            },
            //页面上所有码值对象的数据模型，一般对应下拉列表，checkbox列表，radiobox列表
            //在页面整个组件挂载的时候，会根据codetableget对象统一从服务器端获取
            //在整个页面的生命周期内不用重复获取，可以在查询form表单、create表单，更新表单内复用
            codetable: {

            },
            {% if page_addbutton=="是" %}
            //创建{{page_entiyname}}时候的校验规则
            rules: {
            {% for formitem in createForm %}
                {{formitem.name}}: [ 
                    {% if formitem.required %}
                    {
                        required: true,
                        message: '请输入{{formitem.lable}}',
                        trigger: 'blur'
                    },
                    {% endif %}
                    {% if formitem.input_minlength || formitem.input_maxlength %}
                    {
                        {% if formitem.input_minlength %}min: {{formitem.input_minlength}},{% endif %}
                        {% if formitem.input_maxlength %}max: {{formitem.input_maxlength}},{% endif %}
                        message: '长度在 {{formitem.input_minlength}} 到 {{formitem.input_maxlength}} 个字符'
                    }
                    {% endif %}
                ],

            {% endfor %}
                
            },
            {% endif %}
            {% if page_editbutton=="是" %}
            //更新{{page_entiyname}}时候的form表单校验规则
            updateRules: {
            {% for formitem in updateForm %}
                {{formitem.name}}: [ 
                    {% if formitem.required %}
                    {
                        required: true,
                        message: '请输入{{formitem.lable}}',
                        trigger: 'blur'
                    },
                    {% endif %}
                    {% if formitem.input_minlength || formitem.input_maxlength %}
                    {
                        {% if formitem.input_minlength %}min: {{formitem.input_minlength}},{% endif %}
                        {% if formitem.input_maxlength %}max: {{formitem.input_maxlength}},{% endif %}
                        message: '长度在 {{formitem.input_minlength}} 到 {{formitem.input_maxlength}} 个字符'
                    }
                    {% endif %}
                ],

            {% endfor %}
            },
            {% endif %}
            //有关分页和其他一些公用的查下筛选条件模型
            filter: {
                per_page: 10, // 页大小
                page: 1, // 当前页
                sorts: ''
            },
            //分页总条数
            total_rows: 0,
            //加载动画显示
            loading: true,
            //表格多选数据
            selected: [], //已选择项
            {% if page_addbutton=="是" %}
            dialogCreateVisible: false, //创建对话框的显示状态
            //创建{{page_entiyname}}动画显示
            createLoading: false,
            {% endif %}
            {% if page_editbutton=="是" %}
            dialogUpdateVisible: false, //编辑对话框的显示状态
            //更新{{page_entiyname}}动画显示
            updateLoading: false,
            {% endif %}
            dialogHelpVisible:false,//帮助对话框的显示状态
            
            
            
        };
    },
    //整个页面组件挂载时候要执行的方法
    mounted: function () {
       // this.getCodeTalbe();
        this.getresultdatas();
    },
    //整个页面需要使用到函数定义
    methods: {
        //表格复选框勾选事件处理
        handleSelectionChange: function (val) {
            this.selected = val;
        },
        //表格排序事件处理
        tableSortChange: function (val) {
           // console.log(`排序属性: ${val.prop}`);
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
        pageSizeChange: function (val) {
           // console.log(`每页 ${val} 条`);
            this.filter.per_page = val;
            this.getresultdatas();
        },
        //表格分页当前页改变事件处理
        pageCurrentChange: function (val) {
           // console.log(`当前页: ${val}`);
            this.filter.page = val;
            this.getresultdatas();
        },
        {% if page_editbutton=="是" %}
        //表格编辑当前行事件处理
        setCurrent: function (data) {
            this.currentId = data.id;

            // 向请求服务端获取单个数据填充更新的form表单
            var resource = this.$resource(this.url + "{/id}");
            resource.query({
                    id: data.id
                })
                .then(function(response)  {
                    this.$message.success('成功获取{{page_entiyname}}' + data.username + '!');
                    this.update.name = response.data.name;
                    this.update.phone = response.data.phone;
                    this.update.email = response.data.email;
                    this.dialogUpdateVisible = true;
                })
                .catch(function(response)  {
                    this.$message.error('获取{{page_entiyname}}失败!');
                });

        },
        // 更新数据
        updateData: function () {
            this.$refs.update.validate(function(valid) {
                if (valid) {
                    this.updateLoading = true;
                    var actions = {
                        update: {
                            method: 'put'
                        }
                    }
                    var resource = this.$resource(this.url, {}, actions);
                    resource.update({
                            "ids": this.currentId
                        }, this.update)
                        .then(function(response)  {
                            this.$message.success('修改{{page_entiyname}}成功！');
                            this.dialogUpdateVisible = false;
                            this.updateLoading = false;
                            this.getresultdatas();
                        })
                        .catch(function(response)  {
                            var data = response.data;
                            console.log(data);
                            if (data instanceof Array) {
                                this.$message.error(data[0]["message"]);
                            } else if (data instanceof Object) {
                                this.$message.error(data["message"]);
                            }
                            this.updateLoading = false;
                        });
                } else {
                    return false;
                }
            });
        },
        {% endif %}
        
        //查询form表单查询按钮事件处理
        query: function () {
            this.filter.page = 1;
            this.getresultdatas();
        },
        //获取码值
        getCodeTalbe: function () {
            var resource = this.$resource(this.codetableurl, this.codetableget);
            resource.query()
                .then(function(response)  {
                    this.codetable = response.data;
                })
                .catch(function(response)  {
                    this.$message.error('错了哦，这是一条错误消息');
                });
        },
        // 获取{{page_entiyname}}列表
        getresultdatas: function () {
            var _this = this;
            _this.loading = true;
            _this.total_rows = 0;
            _this.resultdatas = [];
            var instance = axios_encrypt();
            instance.post(_this.url + "/Adminperge", {
                params: Object.assign({}, _this.searchform, _this.filter)
            })
                .then(function (response) {
                    _this.resultdatas = response.data.rows;
                    _this.total_rows = response.data.total;
                    _this.loading = false;
                })
                .catch(function (response) {
                    _this.$message.error('错了哦，这是一条错误消息');
                    _this.loading = false;
                });

        },
        {% if page_addbutton=="是" %}
        // 重置表单
        reset: function () {
            this.$refs.create.resetFields();
        },
        // 创建数据
        createData: function () {
            // 主动校验
            this.$refs.create.validate(function(valid) {
                if (valid) {
                    this.createLoading = true;
                    var resource = this.$resource(this.url);
                    resource.save(this.create)
                        .then(function(response)  {
                            this.$message.success('创建成功！');
                            this.dialogCreateVisible = false;
                            this.createLoading = false;
                            this.reset();
                            this.getresultdatas();
                        })
                        .catch(function(response)  {
                            var data = response.data;
                            if (data instanceof Array) {
                                this.$message.error(data[0]["message"]);
                            } else if (data instanceof Object) {
                                this.$message.error(data["message"]);
                            }
                            this.createLoading = false;
                        });
                } else {
                    return false;
                }
            });
        },
        {% endif %}

        
        //数据导出
        exportdata : function () {
            alert("待实现！");
        },
        {% if page_delbutton=="是" %}
        // 删除单个数据
        removeData: function (user) {
            this.$confirm('此操作将永久删除{{page_entiyname}} ' + user.username + ', 是否继续?', '提示', {
                    type: 'warning'
                })
                .then(function()  {
                    // 向请求服务端删除
                    var resource = this.$resource(this.url + "{/id}");
                    resource.delete({
                            id: user.id
                        })
                        .then(function(response)  {
                            this.$message.success('成功删除了{{page_entiyname}}' + user.username + '!');
                            this.getresultdatas();
                        })
                        .catch(function(response)  {
                            this.$message.error('删除失败!');
                        });
                })
                .catch(function()  {
                    this.$message.info('已取消操作!');
                });
        },
        //删除多个数据
        removeresultdatas: function () {
            this.$confirm('此操作将永久删除 ' + this.selected.length + ' 个{{page_entiyname}}, 是否继续?', '提示', {
                    type: 'warning'
                })
                .then(function()  {
                    console.log(this.selected);
                    var ids = [];
                    //提取选中项的id
                    this.selected.forEach(function(user) {
                        ids.push(user.id);
                    });
                    // 向请求服务端删除
                    var resource = this.$resource(this.url);
                    resource.remove({
                            ids: ids.join(",")
                        })
                        .then(function(response)  {
                            this.$message.success('删除了' + this.selected.length + '个{{page_entiyname}}!');
                            this.getresultdatas();
                        })
                        .catch(function(response) {
                            this.$message.error('删除失败!');
                        });
                })
                .catch(function() {
                    this.$message.info('已取消操作!');
                });
        },
        {% endif %}
    }
})
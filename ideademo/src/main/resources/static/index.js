var vm = new Vue({
    el: '#app',

    data: function () {

        //包含了整个页面所有的数据模型，数据模型数值的改变，对应的视图会自动改变
        return {
            //对应resetful资源的url
            url: 'http://129.211.190.128/people_context',
            //码值列表的资源url
            codetableurl: '',
            //返回的列表数据
            resultdatas: [],
            //留言
            edit_form: false,
            edit_form_loading: false,
            //查询form表单的数据模型
            searchform: {

            },

            currentDate: new Date(),

            //留言
            ruleForm: {
                content_message: '',
                email: '',
            },

            //增加form表单的数据模型
            create: {



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
            //校验规则
            rules: {
                content_message: [

                    {
                        required: true,
                        message: '扔下建议和联系方式',
                        trigger: 'blur'
                    },


                ],
                scoretypeMinnum: [
                    { trigger: 'blur' },
                    { min: 0, max: 3, message: '输入框不能超过3个字符，请重新输入！' },
                    { pattern: /^\d+$/, message: '最小比例只能为数字！' },

                ],
                scoretypeMaxnum: [
                    { trigger: 'blur' },
                    { min: 0, max: 3, message: '输入框不能超过3个字符，请重新输入！' },
                    { pattern: /^\d+$/, message: '最大比例只能为数字！' },
                ],
                scoretypeMin: [
                    { trigger: 'blur' },

                    { pattern: /^\d+$/, message: '最小总分只能为数字！' },
                ],

                scoretypeMax: [
                    { trigger: 'blur' },

                    { pattern: /^\d+$/, message: '最大总分只能为数字！' },
                ],
            },


            //更新测评时候的form表单校验规则
            updateRules: {

            },

            //有关分页和其他一些公用的查下筛选条件模型
            filter: {
                limit: 10, // 页大小
                offset: 0, // 当前页
                sorts: '',
                page: 1
            },
            //分页总条数
            total_rows: 0,
            //加载动画显示
            loading: true,
            //表格多选数据
            selected: [], //已选择项

            dialogCreateVisible: false, //创建对话框的显示状态
            //创建测评动画显示
            createLoading: false,


            dialogUpdateVisible: false, //编辑对话框的显示状态
            //更新测评动画显示
            updateLoading: false,

            dialogHelpVisible: false,//帮助对话框的显示状态    
            showadd: true,

        };
    },
    //整个页面组件挂载时候要执行的方法
    mounted: function () {


    },
    //整个页面需要使用到函数定义
    methods: {
        // 重置表单
        reset: function (formName) {
            this.$refs[formName].resetFields();
        },
        //提交留言form表单查询按钮事件处理
        submit_content_form: function () {
            var _this = this;
            // 主动校验
            this.$refs.ruleForm.validate(function (valid) {
                if (valid) {
                    _this.edit_form_loading = true;
                    axios.post(_this.url + "/edit_message", _this.ruleForm)
                        .then(function (response) {

                            if (response.data.result == "success") {
                                _this.$message.success('成功！');
                            } else {
                                _this.$message.success('失败!');
                            }
                            _this.edit_form_loading = false;
                            _this.reset('ruleForm');
                        })
                } else {
                    return false;
                }
            });

        },
        handleOpen(key, keyPath) {

        },
        handleClose(key, keyPath) {

        }
    }
})
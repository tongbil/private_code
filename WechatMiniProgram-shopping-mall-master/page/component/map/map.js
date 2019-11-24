// page/component/map/map.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
     
   
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    let plugin = requirePlugin('routePlan');
    let key = 'Z4YBZ-KYTKX-IVT4P-7H5GU-T7SFF-RXBBN';  //使用在腾讯位置服务申请的key
    let referer = 'SplidermanWeb';   //调用插件的app的名称
    let endPoint = JSON.stringify({  //终点
      'name': '可随便定位,我选崇仁县',
      'latitude': 27.76437,
      'longitude': 116.06124
    });
    wx.navigateTo({
      url: 'plugin://routePlan/index?key=' + key + '&referer=' + referer + '&endPoint=' + endPoint
    });

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
     
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
// page/component/new-pages/user/user.js
const app = getApp()
Page({
  data: {
    thumb: '',
    nickname: '',
    orders: [],
    hasAddress: false,
    address: {},
    shareshow: true,
    openid:''
  },
  //获取用户信息
  userinfo(event) {
    wx.login({
      success(e) {

        wx.request({
          url: 'http://192.168.0.113:8080/human/key',
          method: "POST",
          data: {
            code: e.code,
            encryptedData: event.detail.encryptedData,
            iv: event.detail.iv,
          },
          success(res) {
            wx.setStorage(
             'openid', res.data,
            )
          }
        })
      }
    })






    if (event.detail.userInfo.nickName != undefined && event.detail.userInfo.avatarUrl != undefined) {
      this.setData({
        nickname: event.detail.userInfo.nickName,
        thumb: event.detail.userInfo.avatarUrl
      })
      const userall = {
        thumb: event.detail.userInfo.avatarUrl,
        nickname: event.detail.userInfo.nickName
      }
      wx.setStorage({
        key: 'data',
        data: userall,
      })

    }
    if (this.data.thumb != "") {
      this.setData({
        shareshow: false
      })
    }

    wx.getStorage({
      key: 'openid',
      success: function(res) {},
    })
  },
  onPullDownRefresh: function() {
    this.onLoad()
  },

  //（待做：自动刷新）
  onLoad() {
    var self = this;
    wx.getSetting({
      success(res) {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          wx.getUserInfo({
            success(res) {
              self.setData({
                thumb: res.userInfo.avatarUrl,
                nickname: res.userInfo.nickName,
                shareshow: false
              })
            }
          })
        }
      }
    })
 
    app.getOpenid().then(function (res) {
      if (res.status == 200) {

        self.setData({
          openid: wx.getStorageSync('openid')
        })
      } else {

        console.log(res.data);
      }
    });
    /**
     * 发起请求获取订单列表信息（待做：自动刷新）
     */
    setTimeout(function() { //用延迟执行的方式避免因为事务冲突得到刚刚删除空的数据库而得不到数据
      wx.request({
        url: 'http://192.168.0.113:8080/order/get_all?openid='+wx.getStorageSync('openid')+"&status=1",
        success(res) {

          if (res.data.length > 0) {
            for (let i = 0; i < res.data.length; i++) { // 循环列表得到每个数据
              res.data[i].goodPrice = parseInt(res.data[i].goodPrice) * parseInt(res.data[i].goodNum);
            }
          }

          self.setData({
            orders: res.data
          })
        }
      });
    }, 1000)
  },
  onShow() {
    var self = this;
    self.onLoad();


    /**
     * 获取本地缓存 地址信息
     */
    wx.getStorage({
      key: 'address',
      success: function(res) {
        self.setData({
          hasAddress: true,
          address: res.data
        })
      }
    })

  },
  /**
   * 发起支付请求
   */
  payOrders() {
    wx.requestPayment({
      timeStamp: 'String1',
      nonceStr: 'String2',
      package: 'String3',
      signType: 'MD5',
      paySign: 'String4',
      success: function(res) {

      },
      fail: function(res) {
        wx.showModal({
          title: '支付提示',
          content: '商家才能注册支付。',
          showCancel: false
        })
      }
    })
  },

  
   

})
// page/component/orders/orders.js
const app = getApp()
Page({
  data: {
    address: {},
    hasAddress: false,
    total: 0,
    orders: [],
    ma: "happy",
    openid: '',
  },

  //从服务器获取订单数据,onShow比onReady先执行
  onLoad() {
    var self=this;
    app.getOpenid().then(function (res) {
      if (res.status == 200) {
        self.setData({
          openid: wx.getStorageSync('openid')
        })
      } else {
        console.log(res.data);
      }
    });


    setTimeout(function () {//用延迟执行的方式避免因为事务冲突得到刚刚删除空的数据库而得不到数据
      wx.request({
        url: 'http://192.168.0.113:8080/order/get_all?openid=' + wx.getStorageSync('openid')+"&status=0",
        success(res) {          
          console.log(res)
          self.setData({
            orders: res.data
          })
          self.getTotalPrice();
        }
      });
    }, 2000)
  },

  onShow: function () {
    const self = this;
    wx.getStorage({
      key: 'address',
      success(res) {
        self.setData({
          address: res.data,
          hasAddress: true
        })
      }
    });
  },

  /**
   * 计算总价
   */
  getTotalPrice() {
    let orders = this.data.orders;
    let total = 0;
    for (let i = 0; i < orders.length; i++) {
      total += orders[i].goodNum * orders[i].goodPrice;
    }
    this.setData({
      total: total
    })
  },

  toPay() {
    wx.showModal({
      title: '提示',
      content: '个人小程序无法做支付，先暂搁',
      text: 'center',
      complete() {
        wx.switchTab({
          url: '/page/component/user/user'
        })
      }
    })
  }
})
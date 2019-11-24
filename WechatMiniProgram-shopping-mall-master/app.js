App({
  onLaunch: function () {
    console.log('App Launch')
  },
  onShow: function () {
    console.log('App Show')
  },
  onHide: function () {
    console.log('App Hide')
  },
  globalData: {
    hasLogin: false
  },
  getOpenid: function () {
    let that = this;
    return new Promise(function (resolve, reject) {
      wx.login({
        success: function (res) {
          //code 获取用户信息的凭证
          if (res.code) {
            //请求获取用户openid
            wx.request({
              url: "http://192.168.0.113:8080/human/key",
              data: { "code": res.code },
              method: 'POST',
              header: {
                'Content-type': 'application/json'
              },
              success: function (res) {
            
                wx.setStorageSync('openid', res.data);//存储openid
                var res = {
                  status: 200,
                  data: res.data
                }
                resolve(res);
              }
            });
          } else {
            console.log('获取用户登录态失败！' + res.errMsg)
            reject('error');
          }
        }
      })
    });
  },
})

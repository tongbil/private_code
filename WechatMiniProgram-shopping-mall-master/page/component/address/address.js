// page/component/new-pages/user/address/address.js
const app = getApp()
Page({
  data: {
    address: {
      name: '',
      phone: '',
      detail: ''
    }
  },
  onLoad() {
    var self = this;

    app.getOpenid().then(function (res) {
      if (res.status == 200) {

        self.setData({
          openid: wx.getStorageSync('openid')
        })
      } else {

        console.log(res.data);
      }
    });

    wx.getStorage({
      key: 'address',
      success: function(res) {
        self.setData({
          address: res.data
        })
      }
    })
  },
  formSubmit(e) {
    const value = e.detail.value;
    let flag = "";
    let msg = "";
    let telStr = /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
    let inputStr = value.phone;
    if (!(telStr.test(inputStr))) {
      wx.showModal({
        title: '提示',
        content: '手机号码不规范',
        showCancel: false
      })
    } else {
      if (value.name && value.phone && value.detail) {
        console.log("1")
        wx.setStorage({
          key: 'address',
          data: value,
          success() {
            wx.navigateBack();
            wx.request({
              url: 'http://192.168.0.113:8080/human/addUser',
              data: {
                name: value.name,
                phone: value.phone,
                detail: value.detail,
                openid: wx.getStorageSync('openid'),
              },
              success(res) {
                console.log(res)
              }
            });

          }
        })
      } else {
        wx.showModal({
          title: '提示',
          content: '请填写完整资料',
          showCancel: false
        })
      }
    }
  }
})
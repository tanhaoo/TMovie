<template>
  <div class="login v2">
    <div class="wrapper">
      <div class="dialog dialog-shadow" style="display: block; margin-top: -362px;">
        <div class="title">
          <h4>使用 Moive 账号 登录系统</h4>
        </div>
        <div class="content">
          <el-form :model="login" :rules="rules" ref="login">
            <el-form-item prop="account">
              <el-input
                  v-model="login.account"
                  size="large"
                  placeholder="手机号/邮箱"
                  auto-complete="off"
              ></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input
                  type="password"
                  v-model="login.password"
                  size="large"
                  placeholder="密码"
                  auto-complete="off"
                  show-password
              ></el-input>
            </el-form-item>
            <el-form-item>
              <div id="captcha">
                <p id="wait">正在加载验证码...</p>
              </div>
            </el-form-item>
            <el-form-item>
              <el-col :span="5">
                <el-checkbox class="auto-login" v-model="login.auto">自动登录</el-checkbox>
              </el-col>
              <el-col :span="12" style="float: right;">
                <a href="javascript:" @click="toRegister">注册 Movie 账号</a>
                <a style="padding: 1px 0 0 10px" @click="toForgetPassword">忘记密码 ?</a>
              </el-col>
            </el-form-item>
            <el-button
                type="primary"
                @click="toLogin(login)"
                style="width: 370px; height: 48px;"
            >{{ loginTxt }}
            </el-button>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {geeTest, memberLogin} from 'api/index.js'

require('@static/geetest/gt.js')
var captcha
export default {
  data() {
    return {
      login: {
        account: '',
        password: '',
        auto: true,
      },
      rules: {
        account: [{required: true, message: '请输入用户名', trigger: 'blur'}],
        password: [{required: true, message: '请输入密码', trigger: 'blur'}],
      },
      loginTxt: '登录',
      verAccount: false,
      verPassword: false,
    }
  },
  components: {},
  methods: {
    toRegister() {
    },
    toForgetPassword() {
    },
    initGeetest() {
      geeTest().then((res) => {
        window.initGeetest(
            {
              gt: res.gt,
              challenge: res.challenge,
              new_captcha: res.new_captcha,
              offline: !res.success,
              product: 'popup',
              width: '100%',
            },
            function (captchaObj) {
              captcha = captchaObj
              captchaObj.appendTo('#captcha')
              captchaObj.onReady(function () {
                document.getElementById('wait').style.display = 'none'
              })
            }
        )
      })
    },
    toLogin(login) {
      this.$refs.login.validate((valid) => {
        this.loginTxt = '登录中...'
        let result = captcha.getValidate()
        if (!result) {
          this.message('请完成验证')
          this.loginTxt = '登录'
          return false
        }
        let account = this.login.account
        let password = this.login.password
        let auto = this.login.auto
        memberLogin({
          account,
          password,
          auto
        }).then(res => {
          if (res.status == 200) {
            this.$router.push({
              path: '/home'
            })
          } else {
            this.loginTxt = '登录'
            this.message(res.message)
            captcha.reset()
            return false
          }
        })
      });
    },
    message(m) {
      this.$message.error({
        message: m
      })
    }
  },
  mounted() {
    this.initGeetest()
  },

}
</script>

<style rel="stylesheet/scss" lang="scss">
.login {
  overflow-x: hidden;
  overflow-y: hidden;

  .wrapper {
    background-size: 100px;
    min-height: 800px;
    min-width: 630px;
  }
}

.v2 .dialog {
  width: 450px;
  border: 1px solid #dadada;
  border-radius: 10px;
  top: 50%;
  left: 50%;
  margin-left: -225px;
  position: absolute;

  .title {
    color: #333;
    font-weight: 400;
    background: linear-gradient(#fff, #f5f5f5);
    height: auto;
    overflow: visible;
    box-shadow: 0 1px 4px rgba(0, 0, 0, 0.08);
    position: relative;
    background-image: url(~@static/image/M.png);
    background-size: 180px;
    background-position: top center;
    background-repeat: no-repeat;
    height: 92px;
    margin: 0px 0 30px;
    padding: 75px 0 20px;
    box-shadow: none;

    h4 {
      padding: 0;
      text-align: center;
      color: #666;
      border-bottom: 1px solid #dcdcdc;
      -webkit-box-shadow: none;
      -moz-box-shadow: none;
      box-shadow: none;
      font-weight: 700;
      position: absolute;
      bottom: 0;
      width: 100%;
      text-align: center;
      margin: 0;
      padding: 0;
      border-bottom: 0;
      -webkit-box-shadow: none;
      -moz-box-shadow: none;
      box-shadow: none;
      line-height: 1em;
      height: auto;
      color: #333;
      font-weight: 400;
    }
  }

  .content {
    padding: 0 40px 22px;
    height: auto;

    .el-input {
      margin: 0 0 0px;
    }
  }
}

.dialog-shadow,
.v2 .bbs .dialog-shadow,
.v2 .dialog-shadow {
  -webkit-box-shadow: 0 9px 30px -6px rgba(0, 0, 0, 0.2),
  0 18px 20px -10px rgba(0, 0, 0, 0.04), 0 18px 20px -10px rgba(0, 0, 0, 0.04),
  0 10px 20px -10px rgba(0, 0, 0, 0.04);
  -moz-box-shadow: 0 9px 30px -6px rgba(0, 0, 0, 0.2),
  0 18px 20px -10px rgba(0, 0, 0, 0.04), 0 18px 20px -10px rgba(0, 0, 0, 0.04),
  0 10px 20px -10px rgba(0, 0, 0, 0.04);
  box-shadow: 0 9px 30px -6px rgba(0, 0, 0, 0.2),
  0 18px 20px -10px rgba(0, 0, 0, 0.04), 0 18px 20px -10px rgba(0, 0, 0, 0.04),
  0 10px 20px -10px rgba(0, 0, 0, 0.04);
}

@media screen and (min-width: 737px),
screen and (-webkit-max-device-pixel-ratio: 1.9) and (max-width: 736px) and (min-device-width: 737px) {
  .wrapper {
    background: url(/src/assets/logo.png) repeat-x;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
  }
  .dialog {
    background: url(~@static/images/dialog-gray-bg.png) #fff bottom repeat-x;
    border-radius: 12px;
    display: none;
    margin: -163px 0 0 -218px;
    width: 436px;
    position: fixed;
    left: 50%;
    top: 50%;
  }
  .dialog .title h4 {
    border-bottom: #d1d1d1 solid 1px;
    box-shadow: 0 2px 6px #d1d1d1;
    color: #666;
    font-size: 20px;
    height: 61px;
    line-height: 61px;
    padding: 0 0 0 35px;
  }
  .auto-login {
    position: absolute;
    top: 0px;
    left: 2px;
    color: #999;
  }
}

#wait {
  text-align: left;
  color: #999;
  margin: 0;
}
</style>
